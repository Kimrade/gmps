package org.kimrade.gmps.service;

import org.kimrade.gmps.dto.UserInfoDTO;

public interface UserInfoService {
	
	// 사용자 정보 등록
	public boolean userInfoInsert(UserInfoDTO userInfoDTO);
	
	// 정보 수정
	public boolean userInfoUpdate(UserInfoDTO userInfoDTO);
	
	// 정보 삭제
	public boolean userInfoDelete(String id);
	
	// 사용자 정보 조회
	public UserInfoDTO userInfoSearchById(String id);
	
	
}
