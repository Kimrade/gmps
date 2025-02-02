package org.kimrade.gmps.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String pw;
	
	// 사업자명 - 회사명
	@Column(nullable = true)
	private String companyName;
	
	// 사용자 명
	@Column(nullable = false)
	private String userName;
	
}