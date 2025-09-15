package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
//@controller help program understand this is a RESTFUL API WEB SERVICE
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	// function get data, return list building in db
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding() {
		List<BuildingDTO> listBudiBuildingDTOs = buildingService.findAllBuildingDTOs();
		return listBudiBuildingDTOs;
	}

	// function delete building by id
	@DeleteMapping(value = "/delete-building/")
	public void deleteBuilding(@RequestParam(value = "id") int id) {
		buildingService.deleteById(id);
	}
}