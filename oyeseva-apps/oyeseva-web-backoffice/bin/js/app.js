var adminServices = angular.module("oyeadmin.services", ["ngResource"]);
var adminControllers = angular.module("oyeadmin.controllers", []);

var oyeAdminApp = angular.module('oyeAdminApp', [
 	"oyeadmin.controllers",
 	"oyeadmin.services"
 ]);



var discuss = adminServices.factory('SessionIdService', function() {
    var sessionID = '';
    return {
        getSessionId: function() {
            //if(sessionID=='' || sessionID==null)
            //{
			//	if ("localStorage" in window)
			//	{
             //  		sessionID = localStorage.getItem("SessionId");
			//	}
			//	else
			//	{
			//		alert("No local storage");
			//	}
			//}

            console.log("Get sessionId => " + sessionID);

            return sessionID;
        },

        setSessionId: function(sessId) {
            console.log("Set sessionId=" + sessId);
            localStorage.setItem("SessionId", sessId);
            sessionID = sessId;
            return;
        }
    }
});




//Customer (User/UserProfile table)
var user_admin = adminServices.factory('Customer', function($resource) {
	return $resource('/oyeseva-rest-customer-0.1/api/v1/customer/users/:id',{}, {
		//remove:{method: 'DELETE', params: {userId: '@id'}},
		//update:{method: 'PUT', params: {userId: '@id'}},
		get: {method: 'GET', params: {userId: '@id'}}
	})
});



oyeAdminApp.directive('bindHtmlUnsafe', function( $compile ) {
    return function( $scope, $element, $attrs ) {

        var compile = function( newHTML ) { // Create re-useable compile function
            newHTML = $compile(newHTML)($scope); // Compile html
            $element.html('').append(newHTML); // Clear and append it
        };

        var htmlName = $attrs.bindHtmlUnsafe; // Get the name of the variable
                                              // Where the HTML is stored

        $scope.$watch(htmlName, function( newHTML ) { // Watch for changes to
                                                      // the HTML
            if(!newHTML) return;
            compile(newHTML);   // Compile it
        });

    };
});


oyeAdminApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider
    .when('/oyeseva-rest-customer-0.1/api/v1/customer/users/list', {templateUrl: 'views/users/list.html', controller: 'AdminCustomerListController'})
    .when('/oyeseva-rest-customer-0.1/api/v1/customer/users/register', {templateUrl: 'views/users/create.html', controller: 'AdminCustomerCreateController'})
    .when('/oyeseva-rest-customer-0.1/api/v1/customer/users/:id', {templateUrl: 'views/users/edit.html', controller: 'AdminCustomerCreateController'});
    
    $routeProvider.otherwise({redirectTo: '/oyeseva-rest-customer-0.1/api/v1/customer/users/login'});
  }]);


//Routing and Session Check for Login
oyeAdminApp.run(function($rootScope, $location, SessionIdService) {

    // register listener to watch route changes
    $rootScope.$on("$routeChangeStart", function(event, next, current) {

        console.log("Routechanged... ");

       	var session = SessionIdService.getSessionId();
       	
       	//if (session == '' || session == null) {
//
            // no logged user, we should be going to #login
  //          if (next.templateUrl == "views/users/login.html") {
            // already going to #login, no redirect needed
    //        } else {
                // not going to #login, we should redirect now
      //      	$location.path("/users/login");
        //    }
        //}
    });
});




adminControllers.controller('AdminCustomerCreateController', ['$scope', '$routeParams', '$location', 'Customer',
  function($scope, $routeParams, $location, Customer) {
     var userId = $routeParams.userId;
     	if(userId != null )
	 	{
	 		$scope.user = Customer.get({userId: userId});
	 		$scope.edituser = function () {
	 			$scope.user.$save(function (user, headers) {
	 				toastr.success("Edited User");
	 				$location.path('/oyeseva-rest-customer-0.1/api/v1/customer/users/list');
	 			});
	 		};
	 	}
	 	else
	 	{
	 		$scope.user = new Customer();

			$scope.register = function () {
				if($scope.userForm.$invalid) return;
				$scope.user.$save(function (user, headers)
				{

					$scope.message = "User registered successfully";
					$scope.error = '';
					$scope.submitted = true;
					$location.path('/oyeseva-rest-customer-0.1/api/v1/customer/users/list');

				}, function (error) {
					// failure
					console.log("$save failed " + JSON.stringify(error));
					$scope.error = 'Error in registering.Check your inputs and try again. Make sure that the Email is unique to the system.';
					$scope.message = '';
					$scope.submitted = false;
					$scope.userName = '';
					$scope.email = '';
					$scope.password = '';
					$scope.userRoleId = '';

					$location.path('/oyeseva-rest-customer-0.1/api/v1/customer/users/register');

				});

			};
		}
  }]);



//User Listing
adminControllers.controller('AdminCustomerListController', ['$scope', 'Customer',
	function($scope, Customer) {
	   $scope.users = Customer.query();
	}]);


















