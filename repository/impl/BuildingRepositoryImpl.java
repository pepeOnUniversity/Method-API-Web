/**
 * 
 */
package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

/**
 * 
 */
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	// require attribute of db
	static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	static final String USER = "root";
	static final String PASS = "hung";

	@Override
	public List<BuildingEntity> findAll() {
		// sql sentence
		String sql = "Select * From building b";
		// create new list to store values
		List<BuildingEntity> listBulBuildingEntities = new ArrayList<>();
		// connect to db
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {

			// loop when resultSet null
			while (resultSet.next()) {
				// create buildingDTO
				BuildingEntity buildingEntity = new BuildingEntity();
				// set data for building DTO
				buildingEntity.setName(resultSet.getString("name"));
				buildingEntity.setFloor(resultSet.getInt("floor"));
				buildingEntity.setSize(resultSet.getString("size"));
				buildingEntity.setStreet(resultSet.getString("street"));
				buildingEntity.setCity(resultSet.getString("city"));
				// add building into list
				listBulBuildingEntities.add(buildingEntity);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listBulBuildingEntities;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from building where id = " + id;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement statement = connection.createStatement()) {

			int rowsAffected = statement.executeUpdate(sql);

			if (rowsAffected > 0) {
				System.out.println("Xóa thành công building có ID: " + id);
			} else {
				System.out.println("Không tìm thấy building có ID: " + id);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
