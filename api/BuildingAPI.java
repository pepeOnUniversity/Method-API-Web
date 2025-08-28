package com.javaweb.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@controller help program understand this is a RESTFUL API WEB SERVICE
public class BuildingAPI {
	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
	public void building() {
		System.out.print("done");
	}
}