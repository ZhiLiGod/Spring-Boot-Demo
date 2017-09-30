package com.zhi.springboot.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("/addOrder")
	public String addOrder(@RequestBody Orders order)throws Exception{//
		orderService.addOrder(order);
		return "haha";
	}
	
	@RequestMapping("/orders")
	public String findOrders() throws Exception{
		
		Sort sort = new Sort(Sort.Direction.DESC, "oid");
		Pageable pageable = new PageRequest(0, 4, sort);
		Page<Orders> pages = orderService.findOrders(pageable);
		Iterator<Orders> it = pages.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		return "";
	}
	
	
}
