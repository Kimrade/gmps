package org.kimrade.gmps.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.kimrade.gmps.domain.UserInfo;
import org.kimrade.gmps.dto.NoticeCheckDTO;
import org.kimrade.gmps.dto.PageRequestDTO;
import org.kimrade.gmps.dto.PageRequestDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class NoticeCheckServiceTests {

	@Autowired
	private NoticeCheckService ncs;
	
	@Test
	public void insertTest() {
		ncs.noticeMemoInsert(NoticeCheckDTO.builder().noticeNo("10").noticeName("----- 구매3").pname("국방전자조달").id("aaa").build());
	}
	
	@Test
	public void insertTest2() {
		ncs.noticeMemoInsert(NoticeCheckDTO.builder().noticeNo("10").noticeName("----- 구매3").pname("국방전자조달").id("aaa").noticeDesDate(LocalDateTime.now()).build());
	}
	
	@Test
	public void insertTest3() {
		ncs.noticeMemoInsert(NoticeCheckDTO.builder().noticeNo("11").noticeName("----- 구매3").pname("국방전자조달").id("aaa").noticeResDate(LocalDateTime.now()).build());
	}
	
	
	@Test
	public void modifyTest() {
		ncs.noticeMemoUpdate(NoticeCheckDTO.builder().noticeNo("10").noticeName("----- 제조").pname("국방전자조달").id("aaa").build());
	}
	
	@Test
	public void deleteTest() {
		ncs.noticeMemoDelete("10");
	}
	
	@Test
	public void readOneTest() {
		log.info("확인용 : "+ncs.noticeReadOne("09"));
	}
	
	@Test
	public void listAllTest() {
		ncs.noticeMemoListAll(PageRequestDTO.builder().size(5).page(2).build()).getDtoList().stream().forEach(x -> log.info("확인용 : "+x));
	}
	
	@Test
	public void searchTest1() {
		ncs.noticeMemoSearch(PageRequestDTO.builder().size(5).page(1).type("a").keyword("03").build()).getDtoList().stream().forEach(x -> log.info("확인용 : "+x));
	}
	
	@Test
	public void searchTest2() {
		ncs.noticeMemoSearchDes(PageRequestDTO2.builder().size2(1).page2(1).build()).getDtoList().stream().forEach(x -> log.info("확인용 : "+x));
	}
	
	@Test
	public void searchTest3() {
		ncs.noticeMemoSearchRes(PageRequestDTO2.builder().size2(1).page2(1).build()).getDtoList().stream().forEach(x -> log.info("확인용 : "+x));
	}
	
	
	
}
