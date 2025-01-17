package org.kimrade.gmps.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
	
	// 사용자 고유번호 -> 공고 테이블과 연동이 되게
	@Id
	private int userNo;
	
	// 사업자명 - 회사명
	private String companyName;
	
	// 사용자 명
	private String userName;
	
}