package com.zhi.springboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zhi.springboot.pojo.Orders;

public interface OrderService {

	public void addOrder(Orders order) throws Exception;
	public Page<Orders> findOrders(Pageable pageable) throws Exception;
}
