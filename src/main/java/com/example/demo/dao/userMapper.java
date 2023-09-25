package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.user;


@Mapper
public interface userMapper {
	//Create
	@Insert("insert into user(name,address) values(#{name},#{address})")
	void add(user u);
	
	//Read
	@Select("select * from user")
	List<user> queryAll();
	
	@Select("select * from user where id=#{id}")
	user queryId(int id);
	//update
	@Update("update user set name=#{name},address=#{address} where id=#{id}")
	void update(user u);
	
	//delete
	@Delete("delete from user where id=#{id}")
	void delete(int id);

}