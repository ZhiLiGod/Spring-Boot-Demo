package com.zhi.springboot.user.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;


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
public class UserControllerTest {
	
	private MockMvc mockMVC;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setup(){
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testAddUser() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zhangsan111");
		map.put("sex", "1");
		MvcResult result = mockMVC.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSONObject.toJSONString(map)))
				.andExpect(status().isOk())
//				.andExpect(content()
//						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();
				
		System.out.println(result.getResponse().getContentAsString());		
				
		
	}
	
	@Test
	public void testFindAll() throws Exception{
		MvcResult result = mockMVC.perform(get("/user"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();
				
		System.out.println(result.getResponse().getContentAsString());	
	}

}
