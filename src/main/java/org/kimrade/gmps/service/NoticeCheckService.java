package org.kimrade.gmps.service;

import java.time.LocalDateTime;

import org.kimrade.gmps.dto.NoticeCheckDTO;
import org.kimrade.gmps.dto.PageRequestDTO;
import org.kimrade.gmps.dto.PageResponseDTO;
import org.springframework.data.domain.Pageable;

public interface NoticeCheckService {
	
	// 메모 추가
	public boolean noticeMemoInsert(NoticeCheckDTO noticeCheckDTO);
	
	// 메모 리스트 불러오기 - 페이지 처리
	public PageResponseDTO<NoticeCheckDTO> noticeMemoListAll(PageRequestDTO pageRequestDTO);
	
	// 메모 수정
	public boolean noticeMemoUpdate(NoticeCheckDTO noticeCheckDTO);
	
	// 메모 삭제
	public boolean noticeMemoDelete(String noticeNo);
	
	// 메모 검색 - 일반 키워드
	public PageResponseDTO<NoticeCheckDTO> noticeMemoSearch(PageRequestDTO pageRequestDTO, LocalDateTime from, LocalDateTime to);
	
	// 메모 자동 조회 - 하루남은 입찰 참가 신청건
	public PageResponseDTO<NoticeCheckDTO> noticeMemoSearchRes(PageRequestDTO pageRequestDTO, LocalDateTime today, LocalDateTime tomorrow);
	
	// 메모 자동 조회 - 하루남은 투찰 마감 신청건
	public PageResponseDTO<NoticeCheckDTO> noticeMemoSearchDes(PageRequestDTO pageRequestDTO, LocalDateTime today, LocalDateTime tomorrow);
	
}
