package com.xzw.crud.service;

import java.util.List;

import com.xzw.crud.pojo.User;

public interface UserService {
	
	User login(String username, String password);

	void register(String username, String password);
	List<User> findAll();

	User findById(Integer id);

	void updateById(Integer id, String username, String password);

	void deleteById(Integer id);

}
