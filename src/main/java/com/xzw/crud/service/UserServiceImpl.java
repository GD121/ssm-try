package com.xzw.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzw.crud.mapper.UserMapper;
import com.xzw.crud.pojo.User;

@Service("userService")
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	

	public User login(String username, String password) {
		
		return userMapper.findWithUsernameAndPassword(username, password);
	}



	@Override
	public void register(String username, String password) {
	
		userMapper.register(username, password);
	}



	public List<User> findAll() {
	  return userMapper.findAll();
	}



	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.findWithId(id);
	}



	public void updateById(Integer id, String username, String password) {
		// TODO Auto-generated method stub
		userMapper.updateById(id,username,password);
		
	}




	public void deleteById(Integer id) {
         
		userMapper.deleteById(id);
		
	}





}
