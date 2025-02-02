package org.kimrade.gmps.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.kimrade.gmps.domain.NoticeCheck;
import org.kimrade.gmps.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class NoticeCheckRepositoryTests {
	
	@Autowired
	private NoticeCheckRepository ncr;
	
	private UserInfo ui = UserInfo.builder().id("aaa").pw("134").userName("aaaa").companyName("bbbb").build();
	
//	@Test
	public void insertTest() {
		ncr.save(NoticeCheck.builder().noticeNo("03").noticeName("----- 구매").userInfo(ui).pname("국방전자조달").build());
	}
	
//	@Test
	public void insertTest2() {
		ncr.save(NoticeCheck.builder().noticeNo("045").noticeName("----- 제조1").userInfo(ui).pname("국방전자조달").noticeResDate(LocalDateTime.now()).build());
	}
	
//	@Test
	public void insertTest3() {
		ncr.save(NoticeCheck.builder().noticeNo("055").noticeName("----- 제조1").userInfo(ui).pname("국방전자조달").noticeDesDate(LocalDateTime.now()).build());
	}
	
//	@Test
	public void modifyTest() {
		log.info("확인용 : "+ncr.findAll());
	}
	
//	@Test
	public void deleteTest() {
		ncr.deleteById("01");
	}
	
//	@Test
	public void readOneTest() {
		log.info("확인용 : "+ncr.findById("03").orElseThrow());
	}
	
	
//	@Test
	public void searchKeywordTest1() {
		
		Pageable pageable = PageRequest.of(0, 10);
		
		String[] types = {"c"};
		
		ncr.searchByKeyword(types, "30", pageable).getContent().forEach(x -> log.info("확인용 : "+x));;
	}
	
//	@Test
	public void searchKeywordTest2() {
		
		Pageable pageable = PageRequest.of(0, 10);
		
		ncr.searchTodayByResDate(pageable).getContent().forEach(x -> log.info("확인용 : "+x));;
		
	}
	
//	@Test
	public void searchKeywordTest3() {
		
		Pageable pageable = PageRequest.of(0, 10);
		
		ncr.searchTodayByDesDate(pageable).getContent().forEach(x -> log.info("확인용 : "+x));;
		
	}
	
}
