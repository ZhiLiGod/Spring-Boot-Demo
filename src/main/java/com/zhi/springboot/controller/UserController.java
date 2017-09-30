package com.zhi.springboot.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.pojo.User;
import com.zhi.springboot.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/users")
	public String addUser(@RequestBody User user) throws Exception{
		userService.addUser(user);
		return "Successful";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public List<User> findAll() throws Exception{
		return userService.findAll();
	}
	
	@RequestMapping("/user/orders")
	public String findOrdersByUid(@RequestBody int user_id) throws Exception{
		
//		List<Orders> orders = userService.findOrdersByUid(user_id);
//		Iterator<Orders> it = orders.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().getUser().getName());
//			
//		}
		Sort sort = new Sort(Sort.Direction.DESC, "oid");
		Pageable pageable = new PageRequest(0, 2, sort);
		User user = userService.findByOrdersUserId(user_id);
		List<Orders> orders = user.getOrders();
		Iterator<Orders> it = orders.iterator();
		while(it.hasNext()){
			System.out.println(it.next());	
		}
		return "success";
	}
	
}
