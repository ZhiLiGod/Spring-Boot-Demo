package com.zhi.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zhi.springboot.dao.OrderDao;
import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void addOrder(Orders order) throws Exception {
		// TODO Auto-generated method stub
		orderDao.save(order);
	
	}

	@Override
	public Page<Orders> findOrders(Pageable pageable) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findAll(pageable);
	}
	
}
