package org.kimrade.gmps.controller;

import java.time.LocalDateTime;

import org.kimrade.gmps.dto.PageRequestDTO;
import org.kimrade.gmps.service.NoticeCheckService;
import org.kimrade.gmps.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class NoticeCheckController {
	
	private final NoticeCheckService ncs;
	private final UserInfoService uis;
	
	@GetMapping("/")
	public String main1() {
		return "login";
	}
	
	@GetMapping("/main")
	public void main2(Model model) {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().size(5).page(1).build();
		
		LocalDateTime present = LocalDateTime.now();
		
		log.info("날짜 확인용 : "+present);
		log.info("날짜 확인용 : "+present.plusDays(2));

		model.addAttribute("reslist", ncs.noticeMemoSearchRes(pageRequestDTO, present, present.plusDays(2)));
		model.addAttribute("deslist", ncs.noticeMemoSearchDes(pageRequestDTO, present, present.plusDays(2)));
	}
	
	@GetMapping("/gmps/memo")
	public void memoListGet(Model model) {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().size(10).page(1).build();
		
		model.addAttribute("listAll", ncs.noticeMemoListAll(pageRequestDTO));
	}
	
	
	
	
}
