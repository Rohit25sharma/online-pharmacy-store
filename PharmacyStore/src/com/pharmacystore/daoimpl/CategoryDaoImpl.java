package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.CategoryDao;
import com.pharmacystore.pojo.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		try (Connection con = 
DbConnection.getDatabaseConnection()){
			
			PreparedStatement pst = 
con.prepareStatement("INSERT INTO category"
+ "(categoryName) VALUES(?)");
			
			pst.setString(1, 
					category.getCategoryName());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
			
		} catch(SQLException | 
				NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(int catid) {
		try (Connection con = 
				DbConnection.getDatabaseConnection()){
							
		PreparedStatement pst = 
		con.prepareStatement("DELETE FROM category"
		+ " WHERE categoryId = ?");
							
		pst.setInt(1,catid);
							
		int count = pst.executeUpdate();
							
		if(count > 0)
			return true;
		else
			return false;
							
		} catch(SQLException | 
				NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> lst = new ArrayList<>();
		
		try (Connection con = 
DbConnection.getDatabaseConnection()){
			
			PreparedStatement pst = 
con.prepareStatement("SELECT * FROM category");
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					
					Category obj = new Category();
					obj.setCategoryId(
							rs.getInt("categoryId"));
					obj.setCategoryName(
					rs.getString("categoryName"));
					lst.add(obj);
				}
				
				return lst;
			}
			else 
				return lst;
			
		} catch (SQLException | 
				NullPointerException e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
	}
}
