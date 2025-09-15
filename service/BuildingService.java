/**
 * 
 */
package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuildingDTO;

/**
 * 
 */
public interface BuildingService {
	List<BuildingDTO> findAllBuildingDTOs();

	/**
	 * @param id
	 */
	void deleteById(int id);
}
