package net.codejava.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.dao.InstitutionDao;
import net.codejava.dao.UserDao;
import net.codejava.entity.Institution;
import net.codejava.entity.User;

@Controller
public class MainController {

	@Autowired
	private UserDao userRepo;
	@Autowired
	private InstitutionDao institutionRepo;
	
	
	
	
	
	@GetMapping("")
	public String index() {
		return "index";
	}	
	@RequestMapping("/signin")
	public String signin(){
		
		return "signin";
	}
	//註冊
	@RequestMapping("/signup")
	public String signup(Model model){
		model.addAttribute("user",new User());
		model.addAttribute("institution",new Institution());
		return "signup";
	}
	@PostMapping("process_signup_user")
	public String processSignupUser(User user) {
		userRepo.save(user);
		return "signup_success";
	}
	@PostMapping("process_signup_institution")
	public String processSignupInstitution(Institution institution) {
		institutionRepo.save(institution);
		return "signup_success";
	}
	
//	@PostMapping("/signup")
//	public String submitForm(@ModelAttribute("user") User user) {
//		System.out.println(user);
//		return "signup_success";
//	}
	
	
	
	@GetMapping("/signup_success")
	public String signup_success() {
		return "signup_success";
	}
	@GetMapping("/signout")
	public String signout() {
		return "signout";
	}
	@RequestMapping("/wishlist")
	public String wishlist(){
		return "wishlist";
	}
	@RequestMapping("/wishdetails")
	public String wishdetails(){
		return "wishdetails";
	}
	
//	profile
	@RequestMapping("/member")
	public String member(){
		return "profile/member";
	}
	@RequestMapping("/institution")
	public String institution(){
		return "profile/institution";
	}
	@RequestMapping("/give")
	public String give(){
		return "profile/give";
	}
	@RequestMapping("/giverecord")
	public String giverecord(){
		return "profile/giverecord";
	}
	@RequestMapping("/wish")
	public String wish(){
		return "profile/wish";
	}
	@RequestMapping("/wishrecord")
	public String wishrecord(){
		return "profile/wishrecord";
	}
	
	//service
	@RequestMapping("/aboutus")
	public String aboutus(){
		return "service/aboutus";
	}
	@RequestMapping("/qa")
	public String qa(){
		return "service/qa";
	}
	@RequestMapping("/agreement")
	public String agreement(){
		return "service/agreement";
	}
	@RequestMapping("/privacy")
	public String privacy(){
		return "service/privacy";
	}
	
	
	
	
	//test
	@RequestMapping("/info/{msg}")
//	@ResponseBody此註釋會返回Restful內容
	public String show(@PathVariable String msg) {
//		@PathVariable此註釋表示{msg}收到的內容會傳至show()的參數
		return "show" + msg;
	}
}
