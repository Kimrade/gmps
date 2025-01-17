package org.kimrade.gmps.controller;

import org.kimrade.gmps.service.NoticeCheckService;
import org.kimrade.gmps.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/gmps")
public class NoticeCheckController {
	
	private final NoticeCheckService ncs;
	private final UserInfoService uis;
	
	@GetMapping("/")
	public String main() {
		
		return "redirect:/main";
	}
	
	@GetMapping("/memo")
	public void memoListGet() {
		
	}
	
	
	
	
}
