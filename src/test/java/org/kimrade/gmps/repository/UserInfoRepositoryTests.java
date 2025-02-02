package org.kimrade.gmps.repository;

import org.junit.jupiter.api.Test;
import org.kimrade.gmps.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class UserInfoRepositoryTests {
	
	@Autowired
	private UserInfoRepository uir;
	
	@Test
	public void insertTest() {
		uir.save(UserInfo.builder().id("aaa").pw("134").userName("aaaa").companyName("bbbb").build());
	}
	
	@Test
	public void modifyTest() {
		uir.save(UserInfo.builder().id("bbb").pw("134").userName("ab").companyName("ba").build());
	}

	@Test
	public void deleteTest() {
		uir.deleteById("bbb");
	}
	
	@Test
	public void readOneTest() {
		log.info("확인용 : "+uir.findById("aaa").orElseThrow());
	}
}
