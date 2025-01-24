package org.kimrade.gmps.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

	// 사용자 고유번호 -> 공고 테이블과 연동이 되게
	private String id;
	
	private String pw;
	
	// 사업자명 - 회사명
	private String companyName;
	
	// 사용자 명
	private String userName;
	
	
}
