package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.UserDao;
import com.pharmacystore.pojo.User;

public class UserDaoImpl implements UserDao {
	@Override
	public boolean register(User user) {
		try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = 
		con.prepareStatement("INSERT INTO user"
				+ " VALUES(?,?,?,?,?,?,?,?)");
			
			pst.setString(1,user.getUserid());
			pst.setString(2,user.getPassword());
			pst.setString(3,user.getEmailid());
			pst.setInt(4,user.getAge());
			pst.setString(5,user.getContact());
			pst.setString(6,user.getCity());
			pst.setString(7,user.getState());
			pst.setString(8,user.getPincode());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkUser(User user) {
		try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = 
		con.prepareStatement("SELECT * FROM user"
				+ " WHERE userid = ? AND"
				+ " password = ?");
			
			pst.setString(1,user.getUserid());
			pst.setString(2,user.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
				return true;
			else
				return false;
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
