package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Category;
import com.example.model.User;
import com.example.model.Wish;
import com.example.repo.CategoryRepository;
import com.example.repo.UserRepository;
import com.example.repo.WishRepository;
import com.example.service.CategoryService;
import com.example.service.UserService;


@Controller
public class WebController {

	@Autowired
	private WishRepository wishRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("")
	public String viewIndex() {
		return "web/index";
	}

//About-----------------------------------------------------------------
	@GetMapping("/about/loveandshare")
	public String viewAboutAboutloveshare() {
		return "web/about_aboutloveshare";
	}

	@GetMapping("/about/agreement")
	public String viewAboutAgreement() {
		return "web/about_agreement";
	}

	@GetMapping("/about/privacy")
	public String viewAboutPrivacy() {
		return "web/about_privacy";
	}

	@GetMapping("/about/qa")
	public String viewAboutQA() {
		return "web/about_qa";
	}
	
//Sign-----------------------------------------------------------------
	//登入
	@GetMapping("/signin")
	public String viewSignIn() {
		return "web/sign_in";
	}
	
	//登出
	@GetMapping("/signout")
	public String viewSignOut() {
		return "web/sign_out";
	}
	
	//註冊
	@GetMapping("/signup")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		
		return "web/sign_up";
	}	
	
	@PostMapping("/signup_success")
	public String registerSubmitForm(User user) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encoderPassword = encoder.encode(user.getUserPassword());
//		user.setUserPassword(encoderPassword);
//		userRepo.save(user);
		userService.saveDefaultRole(user);
		
		return "web/sign_up_success";
	}
	
//Wish-----------------------------------------------------------------
	//產品列表
	@GetMapping("/wishes")
	public String WishList(Model model) {		
		List<Wish> wishList = wishRepo.findAll();
		model.addAttribute("wishList", wishList);	
		
		return "web/wishes";
	}	
	
	//新增
	@GetMapping("/wish/create")
	public String createWish(Model model) {
		List<Category> wishCategoryList = categoryService.listByCode("wish_category");
		model.addAttribute("wish", new Wish());
		model.addAttribute("wishCategoryList", wishCategoryList);
		
		return "web/wish_form";
	}
	
	//新增後回列表
	@PostMapping("/wish/create")
	public String productCreate(Wish wish) {		
		wishRepo.save(wish);
		
		return "redirect:/wishes";
	}
	
	//
	@GetMapping("/wish/{wId}")
	public String WishDetail(@PathVariable("wId") Long wId, Model model) {		
		Wish wish = wishRepo.getById(wId);
		model.addAttribute("wish", wish);	
		
		return "web/wish";
	}	
	
		
	
}
	