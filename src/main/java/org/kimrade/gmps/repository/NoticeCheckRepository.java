package org.kimrade.gmps.repository;

import org.kimrade.gmps.domain.NoticeCheck;
import org.kimrade.gmps.repository.search.NoticeSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeCheckRepository extends JpaRepository<NoticeCheck, String>, NoticeSearch {
	
}