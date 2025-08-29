package com.javaweb.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.beans.BuildingDTO;

@RestController
//@controller help program understand this is a RESTFUL API WEB SERVICE

public class BuildingAPI {
//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
	// add parameter required=false. The default of this parameter is true.
	// it means any variable in request param must has value
	// when set it is false, it don't need required any variable in request
	// must has value, so it can null
//	public void getBuilding(@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "size", required = false) String size,
//			@RequestParam(value = "floor", required = false) Integer floor) {
//		System.out.println(name + " " + size + " " + floor);
//	}

	// get data by Map (1 way of RequestParam)
//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
//	public void getBuilding2(@RequestParam Map<String, String> params) {
//		System.out.println("ok");
//	}

	// get data by body
//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	public void getBuilding3(@RequestBody Map<String, String> params) {
//		System.out.println("done body");
//	}
//	

	// get data by DTO (1 way of RequestBody) / Java beans
//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	public void getBuilding4(@RequestBody BuildingDTO buildingDTO) {
//		// building DTO (variable:value) store data of JSON (key:value)
//		System.out.println("done by DTO");
//	}

	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
	public BuildingDTO getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "floor", required = false) Integer floor) {
		BuildingDTO response = new BuildingDTO();
		response.setName(name);
		response.setSize(size);
		response.setFloor(floor);
		return response;
	}
}