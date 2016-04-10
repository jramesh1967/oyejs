package com.oyeseva.delivery.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ping")
@Controller
public class PingController {

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String ping() {
		System.out.println("PING OYESEVA DELIVERY REST**");
		return "{'ping':'oyeseva-rest-delivery'}";
	}
}
