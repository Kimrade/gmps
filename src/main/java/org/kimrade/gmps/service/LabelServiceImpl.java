package org.kimrade.gmps.service;

import org.kimrade.gmps.domain.Label;
import org.kimrade.gmps.dto.LabelDTO;
import org.kimrade.gmps.repository.LabelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class LabelServiceImpl implements LabelService {

	private final LabelRepository lr;
	private final ModelMapper modelMapper;
	
	@Override
	public boolean labelInfoInsert(LabelDTO labelDTO) {
		
		boolean result = false;
		
		if(lr.findById(labelDTO.getLno()).isPresent()) {
			
		}else {
			lr.save(modelMapper.map(labelDTO, Label.class));
			result = true;
		}
	
		return result;
	}

	@Override
	public ResponseEntity<byte[]> labelMake(LabelDTO labelDTO) {
		// 라벨 생성 - 구글 api 처리해야함.
		// 바코드 api도 해야함.
		// 차후에 진행해야할듯
		
		
		return null;
	}

	@Override
	public boolean labelInfoModify(LabelDTO labelDTO) {
		
		boolean result = false;
		
		if(lr.findById(labelDTO.getLno()).isPresent()) {
			lr.save(modelMapper.map(labelDTO, Label.class));
			result = true;
		}else {
			
		}
		
		return result;
	}

	@Override
	public boolean labelInfoDelete(int lno) {
		
		boolean result = false;
		
		if(lr.findById(lno).isPresent()) {
			lr.deleteById(lno);
			result = true;
		}else {
			
		}
		
		return result;
	}

}
