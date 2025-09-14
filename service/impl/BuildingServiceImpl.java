/**
 * 
 */
package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

/**
 * 
 */
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<BuildingDTO> findAllBuildingDTOs() {
		// get data from DB through entity
		List<BuildingEntity> listBiBuildingEntities = buildingRepository.findAll();
		// create a list to store value after filter data from entiry
		List<BuildingDTO> listBuildingDTOs = new ArrayList<>();
		// loop list Entities to filter
		for (BuildingEntity itemBuildingEntity : listBiBuildingEntities) {
			// create DTO to store value
			BuildingDTO buildingDTO = new BuildingDTO();
			// set value for DTO
			buildingDTO.setName(itemBuildingEntity.getName());
			buildingDTO.setSize(itemBuildingEntity.getSize());
			buildingDTO.setFloor(itemBuildingEntity.getFloor());
			buildingDTO.setAddress(itemBuildingEntity.getStreet() + " " + itemBuildingEntity.getCity());
			// add DTO for list DTO
			listBuildingDTOs.add(buildingDTO);
		}
		// return list DTO
		return listBuildingDTOs;
	}

}
