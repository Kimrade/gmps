package org.kimrade.gmps.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.kimrade.gmps.domain.NoticeCheck;
import org.kimrade.gmps.dto.NoticeCheckDTO;
import org.kimrade.gmps.dto.PageRequestDTO;
import org.kimrade.gmps.dto.PageRequestDTO2;
import org.kimrade.gmps.dto.PageResponseDTO;
import org.kimrade.gmps.dto.PageResponseDTO2;
import org.kimrade.gmps.repository.NoticeCheckRepository;
import org.kimrade.gmps.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeCheckServiceImpl implements NoticeCheckService {
	
	private final ModelMapper modelMapper;
	private final NoticeCheckRepository ncr;
	
	@Override
	public boolean noticeMemoInsert(NoticeCheckDTO noticeCheckDTO) {
		NoticeCheck nc = modelMapper.map(noticeCheckDTO, NoticeCheck.class);
		boolean result = false;
		
		if(ncr.findById(nc.getNoticeNo()).isEmpty()) {
			ncr.save(nc);
			result = true;
		}
		
		return result;
	}

	@Override
	public PageResponseDTO<NoticeCheckDTO> noticeMemoListAll(PageRequestDTO pageRequestDTO) {
		
		Page<NoticeCheck> result = ncr.findAll(pageRequestDTO.getPageable("memoCreatedDate"));
		List<NoticeCheck> list = result.getContent();
		List<NoticeCheckDTO> dtolist = list.stream().map(x -> modelMapper.map(x, NoticeCheckDTO.class)).collect(Collectors.toList());
		
		PageResponseDTO<NoticeCheckDTO> pageResponseDTO = PageResponseDTO.<NoticeCheckDTO>withAll().pageRequestDTO(pageRequestDTO).dtoList(dtolist).total((int)result.getTotalElements()).build();
		
		return pageResponseDTO;
	}

	@Override
	@Transactional
	public boolean noticeMemoUpdate(NoticeCheckDTO noticeCheckDTO) {
		boolean result = false;
		
		if(ncr.findById(modelMapper.map(noticeCheckDTO, NoticeCheck.class).getNoticeNo()).isEmpty()) {
			
		}else {
			ncr.save(modelMapper.map(noticeCheckDTO, NoticeCheck.class));
			result = true;
		}
		return result;
	}

	@Override
	@Transactional
	public boolean noticeMemoDelete(String noticeNo) {
		boolean result = false;
		
		if(ncr.findById(noticeNo).isEmpty()) {
			
		}else {
			ncr.deleteById(noticeNo);
			result = true;
		}
		
		return result;
	}

	@Override
	public PageResponseDTO<NoticeCheckDTO> noticeMemoSearch(PageRequestDTO pageRequestDTO) {
		
		Page<NoticeCheck> result = ncr.searchByKeyword(pageRequestDTO.getTypes(), pageRequestDTO.getKeyword(), pageRequestDTO.getPageable("memoCreatedDate"));
		int totalcount = (int)result.getTotalElements();
		
		List<NoticeCheckDTO> dtolist = result.getContent().stream().map(x -> modelMapper.map(x, NoticeCheckDTO.class)).collect(Collectors.toList());
		
		PageResponseDTO<NoticeCheckDTO> pageResponseDTO = PageResponseDTO.<NoticeCheckDTO>withAll().dtoList(dtolist).pageRequestDTO(pageRequestDTO).total(totalcount).build();
		
		return pageResponseDTO;
	}

	@Override
	public PageResponseDTO2<NoticeCheckDTO> noticeMemoSearchRes(PageRequestDTO2 pageRequestDTO2) {
		
		Page<NoticeCheck> result = ncr.searchTodayByResDate(pageRequestDTO2.getPageable("memoCreatedDate"));
		int totalcount = (int)result.getTotalElements();
		
		List<NoticeCheckDTO> dtolist = result.getContent().stream().map(x -> modelMapper.map(x, NoticeCheckDTO.class)).collect(Collectors.toList());
		
		PageResponseDTO2<NoticeCheckDTO> pageResponseDTO2 = PageResponseDTO2.<NoticeCheckDTO>withAll().dtoList(dtolist).pageRequestDTO2(pageRequestDTO2).total(totalcount).build();
		
		return pageResponseDTO2;
	}

	@Override
	public PageResponseDTO2<NoticeCheckDTO> noticeMemoSearchDes(PageRequestDTO2 pageRequestDTO2) {
		
		Page<NoticeCheck> result = ncr.searchTodayByDesDate(pageRequestDTO2.getPageable("memoCreatedDate"));
		int totalcount = (int)result.getTotalElements();
		
		List<NoticeCheckDTO> dtolist = result.getContent().stream().map(x -> modelMapper.map(x, NoticeCheckDTO.class)).collect(Collectors.toList());
		
		PageResponseDTO2<NoticeCheckDTO> pageResponseDTO2 = PageResponseDTO2.<NoticeCheckDTO>withAll().dtoList(dtolist).total(totalcount).pageRequestDTO2(pageRequestDTO2).build();
		
		return pageResponseDTO2;
	}

	@Override
	public NoticeCheckDTO noticeReadOne(String noticeNo) {
		
		if(ncr.findById(noticeNo).isPresent()) {
			NoticeCheck nc = ncr.findById(noticeNo).orElseThrow();
			
			return modelMapper.map(nc, NoticeCheckDTO.class);
		}else {
			
			return null;
		}
		
		
	}

}
