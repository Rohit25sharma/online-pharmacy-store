package com.pharmacystore.dao;

import com.pharmacystore.pojo.Admin;

public interface AdminDao {

	boolean register(Admin admin);
	boolean checkAdmin(Admin admin);
}