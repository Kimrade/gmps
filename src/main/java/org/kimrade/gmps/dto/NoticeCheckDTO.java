package org.kimrade.gmps.dto;

import java.time.LocalDateTime;

import org.kimrade.gmps.domain.UserInfo;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeCheckDTO {
	
	// 공고 번호
	private String noticeNo;
	
	// 공공명
	private String noticeName;
	
	// 기초 예가
	private double noticeOriginalPrice;
	
	// 상한가
	private double noticeUpNum;
	
	// 하한가
	private double noticeDownNum;
	
	// 낙찰 사정률
	private double noticePer;
	
	// 입찰 공고 기관
	private String noticeAgency;
	
	// 공고시작일 - 시간
	private LocalDateTime noticeDate;
	
	// 입찰참가신청 마감 - 시간까지
	private LocalDateTime noticeResDate;
	
	// 입찰서 제출 마감 - 시간까지
	private LocalDateTime noticeDesDate;
	
	// 메모 생성 날짜
	private LocalDateTime memoCreatedDate;
	
	// 국방 혹은 나라장터등 플랫폼 설정
	private String pname;
	
	// - 투찰 정보등 -> null 가능
	// 투찰가
	private double userInputPrice;
		
	// 선택 번호 1
	private int pNo1;
	
	// 선택 번호 2
	private int pNo2;
	
	// 회사 정보
	// 유저정보 - 테이블 조인용
	private String id;
}
