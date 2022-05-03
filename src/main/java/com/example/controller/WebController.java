package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Category;
import com.example.model.Give;
import com.example.model.User;
import com.example.model.Wish;
import com.example.service.CategoryService;
import com.example.service.GiveService;
import com.example.service.UserService;
import com.example.service.WishService;


@Controller
public class WebController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private WishService wishService;
	@Autowired
	private GiveService giveService;
	
	
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
		userService.saveDefaultRole(user);
		
		return "web/sign_up_success";
	}
	
//Wish-----------------------------------------------------------------
	//產品列表
	@GetMapping("/wishes")
	public String WishList(Model model) {		
		List<Wish> wishList = wishService.findAllEnabled();
		model.addAttribute("wishList", wishList);	
		
		return "web/wishes";
	}	
	
	//新增
	@GetMapping("/wish/create")
	public String viewWishForm(Model model) {
		List<Category> wishCategoryList = categoryService.listByCode("wish_category");
		model.addAttribute("wish", new Wish());
		model.addAttribute("wishCategoryList", wishCategoryList);
		
		return "web/wish_form";
	}
	
	//新增後回列表
    @RequestMapping(value = {"/savewish_success"}, method = RequestMethod.POST, params="submit_button=add")
	public String createWish(Wish wish) {
		wishService.save(wish);
		
		return "redirect:/wishes";
	}
	
	//取得該項目
	@GetMapping("/wish/{wId}")
	public String WishDetail(@PathVariable("wId") Long wId, Model model) {
		Wish wish = wishService.get(wId);
		model.addAttribute("wish", wish);
		
		return "web/wish";
	}	

//User Profile-----------------------------------------------------------------
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String viewProfile(Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("user", userService.findByUserName(username));
		
		return "web/profile";
	}
	
	@RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
	public String saveProfile(User user) {	
		userService.saveDefaultRole(user);
		
		return "redirect:/user/profile";
	}

//User Record(wish)-----------------------------------------------------------------
	@RequestMapping(value = "/user/record_wish", method = RequestMethod.GET)
	public String viewRecordForWish(Model model, Principal principal) {
		String username = principal.getName();
		List<Wish> wishRecord = wishService.findAllWishRecord(username);
		model.addAttribute("wishRecord", wishRecord);
				
		return "web/record_wish";
	}

	//編輯
	@GetMapping("/user/editwish{wId}")
	public String editWishForm(@PathVariable("wId") Long wId, Model model) {
		Wish wish = wishService.get(wId);
		model.addAttribute("wish", wish);
		
		return "web/wish_form";
	}
	
	//編輯後回列表
    @RequestMapping(value = {"/savewish_success"}, method = RequestMethod.POST, params="submit_button=edit")
	public String editWish(Wish wish) {	
		wishService.edit(wish);
		
		return "redirect:/user/record_wish";
	}

    //取消
    @GetMapping("/user/cancelwish{wId}")
    public String cancelWish(@PathVariable("wId") Long wId) {
    	wishService.cancel(wId);
    	
    	return "redirect:/user/record_wish";
    }
    
    
//User Record(give)-----------------------------------------------------------------
	@RequestMapping(value = "/user/record_give", method = RequestMethod.GET)
	public String viewRecordForGive(Model model, Principal principal) {
		String username = principal.getName();
		List<Give> giveRecord = giveService.findAllGiveRecord(username);
		model.addAttribute("giveRecord", giveRecord);
				
		return "web/record_give";
	}

//Give-----------------------------------------------------------------
	//立即捐贈(取得wish)
	@RequestMapping(value = "/{wId}/give", method = RequestMethod.GET)
	public String catchWishId(@PathVariable("wId") Long wId, Model model) {	
		Wish wish = wishService.get(wId);
		model.addAttribute("wish", wish);
//		配送方式清單
//		List<Category> shippingCategoryList = categoryService.listByCode("shipping_category");
//		model.addAttribute("shippingCategoryList", shippingCategoryList);
		model.addAttribute("give", new Give(wish));
		
		return "web/give_form";
	}
	
	//新增訂單
	@RequestMapping(value = "/savegive", method = RequestMethod.POST)
	public String createGive(Give give) {		
		giveService.save(give);
		
		return "redirect:/user/record_give";
	}
	
    //取消
    @GetMapping("/user/cancelgive{gId}")
    public String cancelGive(@PathVariable("gId") Long gId) {
    	giveService.cancel(gId);
    	
    	return "redirect:/user/record_give";
    }
	
	
	
	
}
	