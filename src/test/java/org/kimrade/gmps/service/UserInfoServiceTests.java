package org.kimrade.gmps.service;

import org.junit.jupiter.api.Test;
import org.kimrade.gmps.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class UserInfoServiceTests {

	@Autowired
	private UserInfoService uis;
	
	@Test
	public void insertTest() {
		uis.userInfoInsert(UserInfoDTO.builder().id("aa").pw("bb").userName("cc").companyName("dd").build());
	}
	
	@Test
	public void modifyTest() {
		uis.userInfoUpdate(UserInfoDTO.builder().id("aa").pw("b1").userName("c1").companyName("d1").build());
	}
	
	@Test
	public void deleteTest() {
		uis.userInfoDelete("aa");
	}
	
	@Test
	public void searchTest() {
		log.info("확인용 : "+uis.userInfoSearchById("aa"));
	}
	
	
}
