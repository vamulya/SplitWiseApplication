package com.example.sw.split.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sw.split.model.Login;
import com.example.sw.split.model.User;
import com.example.sw.split.services.UserServiceImpl;

@Controller
public class LoginController {

	public String loggedUser = "";

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	@Autowired
	public UserServiceImpl userservice;

	@RequestMapping("/join")
	public ModelAndView joinPage() {
		return new ModelAndView("join");
	}

	@RequestMapping("/usersaved")
	public ModelAndView userSavedPage() {
		return new ModelAndView("usersaved");
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user, RedirectAttributes redirectattributes,
			HttpServletRequest request, HttpServletResponse response) {
		String page = "";
		if (checkUser(user)) {
			redirectattributes.addAttribute("message", "user already exists");
			page = "redirect:/join";
		} else {
			userservice.save(user);
			redirectattributes.addAttribute("username", user.getUsername());
			page = "redirect:/usersaved";
		}

		return page;
	}

	private Boolean checkUser(User user) {

		User existinguser = userservice.findByUsername(user.getUsername());
		if (existinguser != null) {
			// redirectattributes.addAttribute("message", "user already exists");
			return true;
		} else {
			return false;
		}

	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/check-login", method = RequestMethod.POST)
	public String logincPage(RedirectAttributes redirectAttributes, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("login") Login login) {
		String s = "";
		loggedUser = login.getUsername();
		User usercreds = userservice.findByUsername(login.getUsername());
		if (usercreds.getPassword().equals(login.getPassword())) {
			redirectAttributes.addAttribute("username", usercreds.getUsername());
			s = "redirect:/successpage";
		} else {
			redirectAttributes.addAttribute("message", "Username or password is wrong");
			s = "redirect:/login";
		}

		return s;

	}

	@RequestMapping("/successpage")
	public ModelAndView SuccessPage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		return new ModelAndView("successpage");
	}

	@RequestMapping("/addnew")
	public ModelAndView addNew() {

		List<String> list = userservice.findUsers();
		ModelAndView model = new ModelAndView("addnew");
		model.addObject("list", list);
		return model;
	}
	@RequestMapping("/settleup")
	public ModelAndView settleUp() {
		
		List<String> list=userservice.getFriendsForsettleUp(loggedUser);
		ModelAndView model=new ModelAndView("settleup");
		model.addObject("list", list);
		return model;
	}

	@RequestMapping(value = "/save-split", method = RequestMethod.POST)
	public String saveNewSplit(RedirectAttributes redirectAttributes, @RequestParam("friend") String friend,
			@RequestParam("amount") int amount) {
		
		int splitid = createId();
		
		userservice.insertNewSplit(splitid, friend, amount, loggedUser, dateFormat.format(date));

		updateBalance(splitid, loggedUser, amount);

		redirectAttributes.addAttribute("username", loggedUser);
		return "redirect:/successpage";
	}

	private void updateBalance(int splitid, String loggedUser2, float amount) {

		float existingBal = 0;

		if (userservice.getExistingAmount(loggedUser2) != null)
			existingBal = Float.parseFloat(userservice.getExistingAmount(loggedUser2));

		if (existingBal != 0) {
			userservice.deleteExistingRecord(loggedUser2);
			amount = amount + existingBal;
		}

		userservice.insertNewBalRecord(splitid, loggedUser2, amount);

	}
	@RequestMapping(value = "/update-settleup", method = RequestMethod.POST)
	public String updateForSettleUp(RedirectAttributes redirectattributes,@RequestParam("friend") String friend,@RequestParam("amount") float amount) {
		
		float existingBal=Float.parseFloat(userservice.getExistingAmount(loggedUser));
	    	float remainingamount=existingBal-amount;
	    	redirectattributes.addAttribute("username", loggedUser);
	       // insert into split table
	    		int splitid = createId1();
	    	String test="-"+String.valueOf(amount);
	    	
	    	float owed=Float.parseFloat(test);
	    	
	    	
	    userservice.insertNewSplit(splitid, friend, owed, loggedUser, dateFormat.format(date));
		userservice.updateBalForSettleUp(remainingamount, loggedUser);
		return "redirect:/successpage";
	}
	
	
	public int createId() {
		int id = (int) Math.round((Math.random()) * 10);
		while (!validId(id)) {
			id = (int) Math.round((Math.random()) * 10);
		}
		return id;
	}
	public int createId1() {
		int id = (int) Math.round((Math.random()) * 100);
		while (!validId(id)) {
			id = (int) Math.round((Math.random()) * 100);
		}
		return id;
	}

	public boolean validId(int id) {

		String splitid = userservice.getSplitId(id);

		if (splitid != null) {
			return false;
		} else {
			return true;
		}
	}

	

	@RequestMapping("/welcome")
	public ModelAndView Welcome() {
		return new ModelAndView("welcome");
	}

}
