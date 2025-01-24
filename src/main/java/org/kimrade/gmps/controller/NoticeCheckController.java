package org.kimrade.gmps.controller;

import java.time.LocalDateTime;

import org.kimrade.gmps.dto.NoticeCheckDTO;
import org.kimrade.gmps.dto.PageRequestDTO;
import org.kimrade.gmps.dto.UserInfoDTO;
import org.kimrade.gmps.service.NoticeCheckService;
import org.kimrade.gmps.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "register";
	}
	
	@PostMapping("/")
	public String login(@RequestParam("id")String id, @RequestParam("pw")String pw, RedirectAttributes ra, Model model) {
		
		if(uis.userInfoSearchById(id) != null) {
			if(uis.userInfoSearchById(id).getPw().equals(pw)) {
				// 로그인 성공
				// session 처리를 통해서 main 화면 접속하여 정보가 유지되게 해야함
				ra.addFlashAttribute("alert1", "로그인 성공 "+id+"님 환영합니다.");
				model.addAttribute("userName", uis.userInfoSearchById(id).getUserName());
				return "main";
			}else {
				// 로그인 실패
				ra.addFlashAttribute("alert1", "아이디 또는 비밀번호가 잘못됬습니다.");
				return "redirect:/";
			}
		}else {
			// 아이디 또는 비밀번호가 잘못됬다는 알람 보내기
			ra.addFlashAttribute("alert1", "아이디 또는 비밀번호가 잘못됬습니다.");
			return "redirect:/";
		}
	}
	
	@GetMapping("/signup")
	public void signupGet() {
		log.info("signup get 진입");
	}
	
	@PostMapping("/signup")
	public String signupPost(@RequestParam("id")String id, @RequestParam("pw")String pw,@RequestParam("userName")String userName, @RequestParam("companyName")String companyName,RedirectAttributes ra) {
		
		boolean result = uis.userInfoInsert(UserInfoDTO.builder().id(id).pw(pw).userName(userName).companyName(companyName).build());
		
		log.info("확인옹 : "+result);
		
		if(result) {
			// 회원가입 성공
			ra.addFlashAttribute("alert1", "회원가입 성공하였습니다. id : "+id);
			return "redirect:/";
		}else {
			// 회원가입 실패
			ra.addFlashAttribute("alert1", "회원가입 실패하였습니다. 다시 진행하여 주세요.");
			return "redirect:/signup";
		}
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
	
	@GetMapping("/gmps/memoinsert")
	public void memoInsertGet() {
		
	}
	
	@PostMapping("/gmps/memoinsert")
	public String memoInsertPost(@RequestParam("noticeNo")String noticeNo, @RequestParam("noticeName")String noticeName,@RequestParam("noticeOriginalPrice")double noticeOriginalPrice, @RequestParam("noticeUpNum")double noticeUpNum, @RequestParam("noticeDownNum")double noticeDownNum, @RequestParam("noticeDate")LocalDateTime noticeDate, @RequestParam("noticeResDate")LocalDateTime noticeResDate, @RequestParam("noticeDesDate")LocalDateTime noticeDesDate, @RequestParam("userInputPrice")double userInputPrice, @RequestParam("pname")String pname, @RequestParam("noticePer")double noticePer,@RequestParam("noticeAgency")String noticeAgency,@RequestParam("pNo1")int pNo1, @RequestParam("pNo2")int pNo2,@RequestParam("id") String id,Model model, RedirectAttributes ra) {
		
		boolean result = ncs.noticeMemoInsert(NoticeCheckDTO.builder().noticeNo(noticeNo).noticeName(noticeName).noticeUpNum(noticeUpNum).noticeDownNum(noticeDownNum).noticePer(noticePer).userInputPrice(userInputPrice).noticeAgency(noticeAgency).noticeDate(noticeDate).noticeDesDate(noticeDesDate).noticeResDate(noticeResDate).id(id).noticeOriginalPrice(noticeOriginalPrice).pname(pname).pNo1(pNo1).pNo2(pNo2).build());
		
		if(result) {
			// 메모 등록 성공
			ra.addFlashAttribute("insertAlert", "공고 메모가 정상적으로 등록되었습니다.");
		}else {
			// 메모 등록 실패 => 이미 존재하는 공고번호에 대한 메모건
			ra.addFlashAttribute("insertAlert", "이미 존재하는 공고번호입니다.");
		}
		return "gmps/memo";
	}
	
	@GetMapping("/gmps/calculation")
	public void calculationGet() {

	}
	
	@GetMapping("/gmps/label")
	public void labelGet() {
		
	}
	
	
	
	
	
	
}
