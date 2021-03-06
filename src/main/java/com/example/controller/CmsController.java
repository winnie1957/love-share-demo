package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Category;
import com.example.model.Give;
import com.example.model.User;
import com.example.model.Wish;
import com.example.service.CategoryService;
import com.example.service.GiveService;
import com.example.service.UserService;
import com.example.service.WishService;

@Controller
public class CmsController {

	@Autowired
	private UserService userService;
	@Autowired
	private WishService wishService;
	@Autowired
	private GiveService giveService;
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/cms")
	public String viewCmsIndex() {
		return "cms/index";
	}
		
//Wish Category-----------------------------------------------------------
	@GetMapping("/cms/wish/category")
	public String wishCategoryList(Model model) {		
		//列表
		List<Category> wishCategoryList = categoryService.listByCode("wish_category");
		model.addAttribute("wishCategoryList", wishCategoryList);	
		//新增
		model.addAttribute("category", new Category());
		
		return "cms/wish_category";
	}
	
	//新增回列表
	@PostMapping("/cms/wish/category")
	public String wishCategoryCreate(Category category) {	
		categoryService.saveWithCode(category, "wish_category");
		
		return "redirect:/cms/wish/category";
	}
	
//Wish-----------------------------------------------------------
	//列表
	@GetMapping("/cms/wish/wishes")
	public String CmsWishes(Model model) {
		List<Wish> wishList = wishService.findAll();
		model.addAttribute("wishList", wishList);
		return "cms/wishes";
	}
	
	//修改
	@GetMapping("/cms/wish/edit/{wId}")
	public String wishFormForEdit(@PathVariable("wId") Long wId, Model model) {
		Wish wish = wishService.get(wId);
		model.addAttribute("wish", wish);

		List<Category> wishCategoryList = categoryService.listByCode("wish_category");		
		model.addAttribute("wishCategoryList", wishCategoryList);
		
		return "cms/wish_form";
	}

	//修改後回列表
	@PostMapping("/cms/wish/edit/{wId}")
	public String wishEdit(Wish wish) {	
		wishService.save(wish);
		
		return "redirect:/cms/wish/wishes";
	}
	
	//刪除
	@GetMapping("/cms/wish/delete/{wId}")
	public String wishDelete(@PathVariable("wId") Long wId, Model model) {
		wishService.delete(wId);

		return "redirect:/cms/wish/wishes";
	}
	

//User-----------------------------------------------------------
	//列表
	@GetMapping("/cms/user/users")
	public String CmsUsers(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "cms/users";
	}

	//修改
	@GetMapping("/cms/user/edit/{uId}")
	public String userFormForEdit(@PathVariable("uId") Long uId, Model model) {
		User user = userService.get(uId);
		model.addAttribute("user", user);
		
		List<Category> roleList = userService.getRoles();
		model.addAttribute("roleList", roleList);
		
		return "cms/user_form";
	}

	//修改後回列表
	@PostMapping("/cms/user/edit/{uId}")
	public String userEdit(User user) {	
		userService.save(user);
		
		return "redirect:/cms/user/users";
	}
	
	//刪除
	@GetMapping("/cms/user/delete/{uId}")
	public String userDelete(@PathVariable("uId") Long uId, Model model) {
		userService.delete(uId);

		return "redirect:/cms/user/users";
	}
	

//user role-----------------------------------------------------------
	@GetMapping("/cms/user/role")
	public String userRoleList(Model model) {	
		//列表
		List<Category> roleList = categoryService.listByCode("role_category");
		model.addAttribute("roleList", roleList);
		//新增
		model.addAttribute("category", new Category());
		
		return "cms/user_role";
	}
		
	//新增回列表
	@PostMapping("/cms/user/role")
	public String userRoleCreate(Category category) {		
		categoryService.saveWithCode(category, "role_category");
		
		return "redirect:/cms/user/role";
	}
	

//give-----------------------------------------------------------
	//列表
	@GetMapping("/cms/give/list")
	public String viewGiveList(Model model) {
		List<Give> giveList = giveService.findAll();
		model.addAttribute("giveList", giveList);
		
		return "cms/givelist";
	}
		
	//修改
	@GetMapping("/cms/give/edit/{gId}")
	public String viewGiveForm(@PathVariable("gId") Long gId, Model model) {
		Give give = giveService.get(gId);
		model.addAttribute("give", give);

		return "cms/give_form";
	}

	//修改後回列表
	@PostMapping("/cms/give/edit/{gId}")
	public String editGive(Give give) {	
		giveService.save(give);
		
		return "redirect:/cms/give/list";
	}
		
	//刪除
	@GetMapping("/cms/give/delete/{gId}")
	public String deleteGive(@PathVariable("gId") Long gId, Model model) {
		giveService.delete(gId);

		return "redirect:/cms/give/list";
	}
	
	
}
