package com.javaweb.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@controller help program understand this is a RESTFUL API WEB SERVICE

public class BuildingAPI {
	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
	// add paramerter required=false. The default of this paremeter is true.
	// it means any variable in request param must has value
	// when set it is false, it dont need required any variable in request
	// must has value, so it can null
	public void getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "floor", required = false) Integer floor) {
		System.out.println(name + " " + size + " " + floor);
	}
}