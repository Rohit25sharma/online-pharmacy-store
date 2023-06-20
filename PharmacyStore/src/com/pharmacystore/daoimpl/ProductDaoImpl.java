package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.ProductDao;
import com.pharmacystore.pojo.Product;

public class ProductDaoImpl implements ProductDao
{
	@Override
	public boolean addProduct(Product product) {
		try (Connection con = 
DbConnection.getDatabaseConnection()){
			
			PreparedStatement pst = 
con.prepareStatement("INSERT INTO product("
+ "productname,price,quantity,description,categoryId)"
+ " VALUES(?,?,?,?,?)");
			
			pst.setString(1, 
					product.getProductname());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getQuantity());
			pst.setString(4,product.getDescription());
			pst.setInt(5, product.getCategoryid());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
			
		} catch (NullPointerException |  
				SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int productId) {
		try (Connection con = 
				DbConnection.getDatabaseConnection()){
							
				PreparedStatement pst = 
		con.prepareStatement("DELETE FROM product"
				+ " WHERE productid = ?");
							
					pst.setInt(1, productId);
					
					int count = pst.executeUpdate();
							
					if(count > 0)
						return true;
					else
						return false;
							
			} catch (NullPointerException |  
				SQLException e) {
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public boolean updateProduct(Product product) {
		try (Connection con = 
				DbConnection.getDatabaseConnection()){
							
							PreparedStatement pst = 
				con.prepareStatement("UPDATE product SET "
				+ "productname = ? , price = ? , "
				+ "quantity = ? , description = ?"
				+ " WHERE productid = ?");
							
							pst.setString(1, 
									product.getProductname());
							pst.setInt(2, product.getPrice());
							pst.setInt(3, product.getQuantity());
							pst.setString(4,product.getDescription());
							pst.setInt(5, product.getProductid());
							
							int count = pst.executeUpdate();
							
							if(count > 0)
								return true;
							else
								return false;
							
						} catch (NullPointerException |  
								SQLException e) {
							e.printStackTrace();
							return false;
						}	
	}

	@Override
	public List<Product> getAllProducts(int start,
			int total) {
List<Product> productList = new ArrayList<>();
		
		try(Connection con = 
				DbConnection.getDatabaseConnection())
		{
			
			PreparedStatement pst = 
					con.prepareStatement(
			"SELECT * FROM product LIMIT ? , ?");
			
			pst.setInt(1, start-1);
			pst.setInt(2, total);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Product product = new Product();
					product.setProductid(rs.getInt("productid"));
					product.setProductname(
							rs.getString("productname"));
					product.setPrice(rs.getInt("price"));
					product.setQuantity(rs.getInt("quantity"));
					product.setDescription(
							rs.getString("description"));
					product.setCategoryid(rs.getInt("categoryId"));
					
					productList.add(product);
				}
			}
			
			return productList;
		}
		catch(NullPointerException | SQLException
				 exc) {
			exc.printStackTrace();
			productList.clear();
			return productList;
		}
	}

	@Override
	public List<Product> getAllProducts() {
List<Product> productList = new ArrayList<>();
		
		try(Connection con = 
				DbConnection.getDatabaseConnection())
		{
			
			PreparedStatement pst = 
					con.prepareStatement(
			"SELECT * FROM product");
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					Product product = new Product();
					product.setProductid(rs.getInt("productid"));
					product.setProductname(
							rs.getString("productname"));
					product.setPrice(rs.getInt("price"));
					product.setQuantity(rs.getInt("quantity"));
					product.setDescription(
							rs.getString("description"));
					product.setCategoryid(rs.getInt("categoryId"));
					
					productList.add(product);
				}
			}
			
			return productList;
		}
		catch(NullPointerException | SQLException
				 exc) {
			exc.printStackTrace();
			productList.clear();
			return productList;
		}
	}

	@Override
	public Product searchProduct(int productId) {
		Product pr = null;	
		
		try(Connection con = 
				DbConnection.getDatabaseConnection())
		{	
			PreparedStatement pst = 
					con.prepareStatement(
			"SELECT * FROM product WHERE "
			+ "productid = ?");
			
			pst.setInt(1, productId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				rs.next();
				
				Product product = new Product();
				product.setProductid(rs.getInt("productid"));
				product.setProductname(
						rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDescription(
						rs.getString("description"));
				product.setCategoryid(rs.getInt("categoryId"));
			
				return product;
			}
		else 
			return null;
		}
		catch(NullPointerException | SQLException
				 exc) {
			exc.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateQuantityAfterOrder(int pid,
			int new_quantity) {
		
		try(Connection con = DbConnection.getDatabaseConnection()){
			PreparedStatement pst = 
con.prepareStatement("UPDATE product SET "
		+ "quantity = ? where productid = ?");
		
			pst.setInt(1, new_quantity);
			pst.setInt(2, pid);
			
			int count = pst.executeUpdate();
			
			if(count > 0) 
				return true;
			else
				return false;
		}
		catch(NullPointerException | SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
