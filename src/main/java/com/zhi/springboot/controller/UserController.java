package com.zhi.springboot.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.zhi.springboot.pojo.Orders;
import com.zhi.springboot.pojo.User;
import com.zhi.springboot.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String login() throws Exception{
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/userLogin")
	public String userLogin(RedirectAttributesModelMap modelMap, HttpSession session, @Validated User user, BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			//model.addAttribute("errors", errors);
			modelMap.addFlashAttribute("errors", errors);
			return "redirect:/login";
		}
		User existUser = userService.findUserByUsernameAndPassword(user.getName(), user.getPassword());
		if(existUser == null){
			//model.addAttribute("error", "User name or password wrong");
			modelMap.addFlashAttribute("error", "User name or password wrong");
			return "redirect:/login";
		}
		
		session.setAttribute("name", user.getName());
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String index() throws Exception{
		return "welcome";
	}
	
	
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
	
	@RequestMapping("/register")
	public String register() throws Exception{
		return "register";
	}
	
	@RequestMapping("/userRegister")
	public String userRegister(User user, HttpSession session) throws Exception{
		if(user == null || user.getName() == ""){
			session.setAttribute("user", user);
			session.setAttribute("errMsg", "username is empty");
			return "redirect:/register";
		}
		userService.addUser(user);
		return "redirect:/success";
	}
	
	@RequestMapping("/success")
	public String success() throws Exception{
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/findUserByUsername")
	public boolean findUserByUsername(String username) throws Exception{
		User user = userService.findUserByUsername(username);
		//System.out.println(username + " " + "333");
		if(user == null){
			//System.out.println("mei zhao dao");
			return true;
		}else{
			//System.out.println(user.getName());
			return false;
		}
		
		
	}
	
}
