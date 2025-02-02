package org.kimrade.gmps.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelDTO {
	
	// 라벨 번호 - auto increment
	private int lno;
	
	// 재고 번호
	private String pno;
	
	// 품목 수량
	private String pqty;
	
	// 품목 수량 단위
	private String punit;
	
	// 품목 가로
	private String pwidth;
	
	// 품목 세로
	private String plength;
	
	// 품목 높이
	private String pheigth;
	
	// 품목 로트 번호
	private String plotno;
	
	// 품 목 명
	private String pname;
	
	// 품 목 명 - 영문
	private String pnameE;
	
	// 생산 일자
	private String pproducedate;
	
	// 사용 기한
	private String penddate;
	
	// 계약 번호
	private String pcontactno;
	
	// 계약 업체
	private String pcontactcompany;
	
	// 전화 번호
	private String ptelno;
	
	// 무게
	private String pweight;
	
	// 회사 정보
	// 유저 정보 - 테이블 조인용
	private String id;
		
}
