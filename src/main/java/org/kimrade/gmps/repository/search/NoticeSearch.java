package org.kimrade.gmps.repository.search;

import java.time.LocalDateTime;

import org.kimrade.gmps.domain.NoticeCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeSearch {
	
	public Page<NoticeCheck> searchByKeyword(String types[], String keyword, LocalDateTime from, LocalDateTime to,Pageable pageable);

	public Page<NoticeCheck> searchTodayByResDate(LocalDateTime today, LocalDateTime tomorrow, Pageable pageable);
	
	public Page<NoticeCheck> searchTodayByDesDate(LocalDateTime today, LocalDateTime tomorrow, Pageable pageable);
}
