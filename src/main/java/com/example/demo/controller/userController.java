package com.example.demo.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.userMapper;

import jakarta.servlet.http.HttpServletResponse;
import com.example.demo.vo.user;


@RestController
@RequestMapping("/")
public class userController {
	@Autowired
	userMapper um;
	@Autowired
	HttpServletResponse response;
	
	@RequestMapping("/add")
	public void add(String name,String address) throws IOException
	{
		user  u=new user();
		u.setName(name);
		u.setAddress(address);
		
		um.add(u);
		
		response.sendRedirect("success.html");
		
	}
	
	@RequestMapping("/queryAll")
	public ModelAndView queryAll(Model m)
	{
		List<user> l=um.queryAll();
		m.addAttribute("USER", l);
		
		ModelAndView modelandview=new ModelAndView("query");
		
		return modelandview;
	}
	
	
	@RequestMapping("/update")
	public ModelAndView update(int id,String name,String address)
	{
		user u=um.queryId(id);
		u.setName(name);
		u.setAddress(address);
		
		um.update(u);
		
		ModelAndView modelandview=new ModelAndView("index");
		
		return modelandview;
		
	}
	@RequestMapping("/delete")
	public ModelAndView  delete(int id)
	{
			um.delete(id);
			ModelAndView modelandview = new ModelAndView("index");
			return modelandview;
		
	}
	

}