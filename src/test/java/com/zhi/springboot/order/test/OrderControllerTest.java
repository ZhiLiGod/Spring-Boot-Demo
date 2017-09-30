package com.zhi.springboot.order.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import net.minidev.json.JSONObject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
	
	private MockMvc mockMVC;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testAddOrder() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//String oid = UUID.randomUUID().toString().replaceAll("-", "");
		//map.put("oid", "aaa");
		map.put("user_id", "8");
		map.put("address", "上海");
		map.put("phone", "56789aa");
		MvcResult result = mockMVC.perform(post("/addOrder")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())
				.andReturn();		
		System.out.println(result.getResponse().getContentAsString());		
	}
	
	@Test
	public void testFindUsers() throws Exception{
		MvcResult result = mockMVC.perform(post("/orders")
				.contentType(MediaType.APPLICATION_JSON)
				.content(""))
				.andExpect(status().isOk())
				.andReturn();		
		System.out.println(result.getResponse().getContentAsString());		
	}
	
//	@Test
//	public void testFindAll() throws Exception{
//		MvcResult result = mockMVC.perform(get("/user"))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andReturn();
//				
//		System.out.println(result.getResponse().getContentAsString());	
//	}

}
