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
adminServices.factory('Customer', function($resource) {
	return $resource('/oyeseva-rest-backoffice-0.1/api/v1/backoffice/customers/:id',{}, {
		update:{method: 'PUT', params: {id: '@id'}},
		show: {method: 'GET', params: {id: '@id'}},
		delete: {method: 'GET', params: {id: '@id'}},
		get: {method: 'GET', params: {id: '@id'}}
	})
});

adminServices.factory('CustomerListing', function($resource) {
	return $resource('/oyeseva-rest-backoffice-0.1/api/v1/backoffice/customers/list',{}, {
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
    .when('/customers/list', {templateUrl: 'views/customers/list.html', controller: 'BO_CustomerController'})
    .when('/customers/-1', {templateUrl: 'views/customers/create.html', controller: 'BO_CustomerController'})
    .when('/customers/new', {templateUrl: 'views/customers/create.html', controller: 'BO_CustomerController'})
    .when('/customers/:id', {templateUrl: 'views/customers/edit.html', controller: 'BO_CustomerController'});

    //$routeProvider.otherwise({redirectTo: '/customers/login'});
    $routeProvider.otherwise({redirectTo: ''});
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
  //          if (next.templateUrl == "views/customers/login.html") {
            // already going to #login, no redirect needed
    //        } else {
                // not going to #login, we should redirect now
      //      	$location.path("/customers/login");
        //    }
        //}
    });
});



//BackOffice Customer Controller
adminControllers.controller('BO_CustomerController', ['$scope', '$routeParams', '$location', 'Customer', 'CustomerListing',
	function($scope, $routeParams, $location, Customer, CustomerListing) {
		var customerId = $routeParams.id;
		var url = $location.absUrl();
    	$scope.customer = [];
    	$scope.customers = [];

    	if(url.endsWith('list'))
    	{
    		$scope.customers = CustomerListing.query();
    	}
    	else
    	{
		 	if(customerId !== undefined && customerId > 0 )
		 	{
		 		$scope.customer = Customer.get({id: customerId});
		 	}
		 	else
		 	{
		 		$scope.customer = Customer.get({id: -1});
			}
		}
		$scope.editCustomer = function () {
			if($scope.customerForm.$invalid) return;

			$scope.customer.$save(function (customer, headers) {
				$scope.message = "Customer updated successfully";
				$scope.error = '';
				$scope.submitted = true;
				toastr.success("Updated Customer");
				$location.path('/customers/list');
			}, function (error) {
				// failure
				console.log("$save failed " + JSON.stringify(error));
				$scope.error = 'Error in updating. Check your inputs and try again. Make sure that the Email and Phone is unique to the system.';
				$scope.message = '';
				$scope.submitted = false;
				$location.path('/customers/' + customerId);
			});
		};

 		$scope.register = function () {
			if($scope.customerForm.$invalid) return;
			$scope.customer.$save(function (customer, headers)
			{
				$scope.message = "Customer registered successfully";
				$scope.error = '';
				$scope.submitted = true;
				toastr.success("Created New Customer");
				$location.path('/customers/list');

			}, function (error) {
				// failure
				console.log("$save failed " + JSON.stringify(error));
				$scope.error = 'Error in registering. Check your inputs and try again. Make sure that the Email and Phone is unique to the system.';
				$scope.message = '';
				$scope.submitted = false;
				$scope.phone = '';
				$scope.isActive = '0';
				$scope.email = '';
				$scope.password = '';
				$location.path('/customers/new');
			});
		};
  }]);
