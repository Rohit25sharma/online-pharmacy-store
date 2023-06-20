package com.pharmacystore.dao;

import com.pharmacystore.pojo.User;

public interface UserDao {

	boolean register(User user);
	boolean checkUser(User user);
}
