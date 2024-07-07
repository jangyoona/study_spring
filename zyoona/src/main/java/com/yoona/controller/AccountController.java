package com.yoona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoona.dto.MemberDto;
import com.yoona.service.AccountService;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Setter(onMethod_ = @Autowired)
	private AccountService accountService;
	
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "/account/login";
	}
	
	@PostMapping("/login")
	public String login(MemberDto member, HttpSession session) {
		
		MemberDto loginMember = accountService.getLoginMember(member);
		
		if(loginMember != null) {
			session.setAttribute("loginuser", loginMember);
			return "redirect:/home";
		} else {
			return "redirect:login?loginfail";
		}
	}
	
	@GetMapping("/register")
	public String registerForm() {
		
		return "/account/register";
	}
	
	@PostMapping("/register")
	public String register(MemberDto member) {
		
		accountService.registerMember(member);
		
		return "redirect:/account/login";
	}
	
	@GetMapping("register-idCheck")
	@ResponseBody
	public String registerIdCheck(String memberId) {
		
		boolean isId = accountService.registerMemberIdCheck(memberId);
		
		return String.valueOf(isId);
	}
}
