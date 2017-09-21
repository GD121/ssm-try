package com.xzw.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xzw.crud.pojo.User;

public interface UserMapper {
	
	User findWithUsernameAndPassword(@Param("username")String username,@Param("password")String password);

	User findWithId(@Param("id")int id);

	void register(@Param("username")String username,@Param("password") String password);
	
	List<User>findAll();

	void updateById(@Param("id")Integer id, @Param("username")String username,@Param("password") String password);

	void deleteById(@Param("id")Integer id);



}
