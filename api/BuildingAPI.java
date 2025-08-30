package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.beans.BuildingDTO;

@RestController
//@controller help program understand this is a RESTFUL API WEB SERVICE

public class BuildingAPI {
	@GetMapping(value = "/api/building/")
	// add parameter required=false. The default of this parameter is true.
	// it means any variable in request param must has value
	// when set it is false, it don't need required any variable in request
	// must has value, so it can null
	public List<BuildingDTO> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "floor", required = false) Integer floor) {
		List<BuildingDTO> listBuildings = new ArrayList<>();
		BuildingDTO buildingDTO1 = new BuildingDTO();
		buildingDTO1.setName("vinhome");
		buildingDTO1.setFloor(10);
		buildingDTO1.setSize("large");
		BuildingDTO buildingDTO2 = new BuildingDTO();
		buildingDTO2.setName("ocean");
		buildingDTO2.setFloor(20);
		buildingDTO2.setSize("small");
		listBuildings.add(buildingDTO1);
		listBuildings.add(buildingDTO2);
		return listBuildings;
	}

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

//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
//	public BuildingDTO getBuilding(@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "size", required = false) String size,
//			@RequestParam(value = "floor", required = false) Integer floor) {
//		BuildingDTO response = new BuildingDTO();
//		response.setName(name);
//		response.setSize(size);
//		response.setFloor(floor);
//		return response;
//	}

	// @PathVariable use to get value from URL and assign it for parameter of method
	// in Controller
	@DeleteMapping(value = "/api/building/{id}/{name}")
	/*
	 * if declear variable in @PathVariable has same name in URL => dont need
	 * declear in @PathVariable (id)
	 */
	// if name of variable different from URL => must declear in @PathVariable
	// (name)
	public void deleteBuilding(@PathVariable Integer id, @PathVariable("name") String nameOfBuilding) {
		System.out.println(id);
		System.out.println(nameOfBuilding);
	}
}