package org.kimrade.gmps.repository.search;

import java.time.LocalDateTime;

import org.kimrade.gmps.domain.NoticeCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeSearch {
	
	public Page<NoticeCheck> searchByKeyword(String types[], String keyword, Pageable pageable);

	public Page<NoticeCheck> searchTodayByResDate(Pageable pageable);
	
	public Page<NoticeCheck> searchTodayByDesDate(Pageable pageable);
}
