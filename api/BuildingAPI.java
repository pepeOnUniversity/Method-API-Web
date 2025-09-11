package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.beans.BuildingDTO;

@RestController
//@controller help program understand this is a RESTFUL API WEB SERVICE

public class BuildingAPI {
	// require attribute of db
	static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	static final String USER = "root";
	static final String PASS = "hung";

	// function get data, return list building in db
	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding() {
		// sql sentence
		String sql = "Select * From building";
		// create new list to store values
		List<BuildingDTO> listBudiBuildingDTOs = new ArrayList<>();
		// connect to db
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {

			// loop when resultSet null
			while (resultSet.next()) {
				// create buildingDTO
				BuildingDTO buildingDTO = new BuildingDTO();
				// set data for building DTO
				buildingDTO.setName(resultSet.getString("name"));
				buildingDTO.setFloor(resultSet.getInt("floor"));
				buildingDTO.setSize(resultSet.getString("size"));
				// add building into list
				listBudiBuildingDTOs.add(buildingDTO);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// return list
		return listBudiBuildingDTOs;
	}

}