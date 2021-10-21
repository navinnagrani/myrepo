package com.parle.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.parle.model.Plan;
import com.parle.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{
	
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
	
	public Connection connectDb() throws Exception {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			connect = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true");
		} catch (Exception e) {
			throw e;
		} 
		return connect;
	}
	@Override
	public String savePlan(Plan plan) {
		try {
			connect = connectDb();
			PreparedStatement statement = connect.prepareStatement("INSERT INTO mydb.plan VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, plan.getPlantName());
			statement.setString(2, plan.getPlantMachine());
			statement.setInt(3, plan.getFillVol());
			statement.setFloat(4, plan.getFillVol3());
			statement.setBoolean(5, plan.isClosureTorque());
			statement.setBoolean(6, plan.isClosureJumpTest());
			statement.setBoolean(7, plan.isClosurePilferBand());
			statement.setBoolean(8, plan.isClosureSecureSeal());
			statement.setBoolean(9, plan.isStressCrackTest());
			statement.setBoolean(10, plan.isDropTest());
			statement.setString(11, plan.getPackageAppearance());
			statement.setString(12, plan.getDateCodingRubTest());
			int res = statement.executeUpdate();
			System.out.println(res);
			if (res == 1) {
				return "Success";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		return "Failure";
	}

}
