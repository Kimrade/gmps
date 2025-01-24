package org.kimrade.gmps.service;

import java.util.Optional;

import org.kimrade.gmps.domain.UserInfo;
import org.kimrade.gmps.dto.UserInfoDTO;
import org.kimrade.gmps.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

	private final ModelMapper modelMapper;
	private final UserInfoRepository uir;
	
	@Override
	public boolean userInfoInsert(UserInfoDTO userInfoDTO) {
		log.info("UserInfoService 진입");
		boolean result = false;
		
		if(uir.findById(userInfoDTO.getId()).isEmpty()){
			uir.save(modelMapper.map(userInfoDTO, UserInfo.class));
			result = true;
		}
		
		return result;
	}

	@Override
	@Transactional
	public boolean userInfoUpdate(UserInfoDTO userInfoDTO) {
		boolean result = false;
		
		UserInfo userInfo = modelMapper.map(userInfoDTO, UserInfo.class);
		
		if(uir.findById(userInfo.getId()).isEmpty()) {
			
		}else {
			uir.save(userInfo);
			result = true;
		}
		
		return result;
	}

	@Override
	@Transactional
	public boolean userInfoDelete(String id) {
		boolean result = false;
		
		if(uir.findById(id).isEmpty()) {
			
		}else {
			uir.deleteById(id);;
			result = true;
		}
		
		return result;
	}

	@Override
	public UserInfoDTO userInfoSearchById(String id) {
		Optional<UserInfo> result = uir.findById(id);
		
		if(result.isEmpty()) {
			return null;
		}else {
			return modelMapper.map(result.orElseThrow(), UserInfoDTO.class);
		}
	}

}
