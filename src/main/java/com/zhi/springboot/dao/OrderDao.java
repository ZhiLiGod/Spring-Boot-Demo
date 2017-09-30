package com.zhi.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhi.springboot.pojo.Orders;

@Transactional
public interface OrderDao extends PagingAndSortingRepository<Orders, String> {
	public List<Orders> findByUser_Id(int user_id) throws Exception;
	
}
