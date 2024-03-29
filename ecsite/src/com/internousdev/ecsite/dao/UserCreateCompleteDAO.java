package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();

	DateUtil dateUtil = new DateUtil();

	public String sql = "INSERT INTO logjn_user_transaction(login_id,login_pass,user_name,insert_date) VALUES(?,?,?,?)";

	public void createUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();

		}catch(Exception e){

			e.printStackTrace();


		}finally{

			connection.close();
		}

	}


}