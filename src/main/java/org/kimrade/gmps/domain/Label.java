package org.kimrade.gmps.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@ToString(exclude = "userInfo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Label {
	
	// 라벨 번호 - auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lno;
	
	// 재고 번호
	@Column(nullable = false)
	private String pno;
	
	// 품목 수량
	@Column(nullable = false)
	private String pqty;
	
	// 품목 수량 단위
	@Column(nullable = false)
	private String punit;
	
	// 품목 가로
	@Column(nullable = false)
	private String pwidth;
	
	// 품목 세로
	@Column(nullable = false)
	private String plength;
	
	// 품목 높이
	@Column(nullable = false)
	private String pheigth;
	
	// 품목 로트 번호
	@Column(nullable = true)
	private String plotno;
	
	// 품 목 명
	@Column(nullable = false)
	private String pname;
	
	// 품 목 명 - 영문
	@Column(nullable = false)
	private String pnameE;
	
	// 생산 일자
	@Column(nullable = false)
	private String pproducedate;
	
	// 사용 기한
	@Column(nullable = false)
	private String penddate;
	
	// 계약 번호
	@Column(nullable = true)
	private String pcontactno;
	
	// 계약 업체
	@Column(nullable = true)
	private String pcontactcompany;
	
	// 전화 번호
	@Column(nullable = true)
	private String ptelno;
	
	// 무게
	@Column(nullable = false)
	private String pweight;
	
	// 회사 정보
	// 유저 정보 - 테이블 조인용
	@ManyToOne(fetch = FetchType.LAZY)	// LAZY or EAGER
	private UserInfo userInfo;
	
}
