package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.AdminDao;
import com.pharmacystore.pojo.Admin;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean register(Admin admin) {
		try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = 
		con.prepareStatement("INSERT INTO admin"
				+ " VALUES(?,?)");
			
			pst.setString(1,admin.getUserid());
			pst.setString(2,admin.getPassword());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
		}
		catch(SQLException | 
				NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkAdmin(Admin admin) {
		try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = 
		con.prepareStatement("SELECT * FROM admin"
				+ " WHERE userid = ? AND"
				+ " password = ?");
			
			pst.setString(1,admin.getUserid());
			pst.setString(2,admin.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
				return true;
			else
				return false;
		}
		catch(SQLException | 
				NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
