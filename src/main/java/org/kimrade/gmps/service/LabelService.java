package org.kimrade.gmps.service;

import org.kimrade.gmps.dto.LabelDTO;
import org.springframework.http.ResponseEntity;

public interface LabelService {
	
	// 라벨 정보 생성
	public boolean labelInfoInsert(LabelDTO labelDTO);
	
	// 라벨 생성
	public ResponseEntity<byte[]> labelMake(LabelDTO labelDTO);
	
	// 라벨 정보 수정
	public boolean labelInfoModify(LabelDTO labelDTO);
	
	// 라벨 정보 삭제
	public boolean labelInfoDelete(int lno);
		
}