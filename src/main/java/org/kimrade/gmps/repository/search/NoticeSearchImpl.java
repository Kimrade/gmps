package org.kimrade.gmps.repository.search;

import java.time.LocalDateTime;
import java.util.List;

import org.kimrade.gmps.domain.NoticeCheck;
import org.kimrade.gmps.domain.QNoticeCheck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;

public class NoticeSearchImpl extends QuerydslRepositorySupport implements NoticeSearch {
	
	public NoticeSearchImpl() {
		super(NoticeCheck.class);
	}
	
	
	@Override
	public Page<NoticeCheck> searchByKeyword(String[] types, String keyword, LocalDateTime from, LocalDateTime to, Pageable pageable) {
		QNoticeCheck nc = QNoticeCheck.noticeCheck;
		
		JPQLQuery<NoticeCheck> query = from(nc);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		if((types != null && types.length > 0) && keyword != null) {
			for(String type : types) {
				switch(type) {
					case "n":
						bb.or(nc.noticeName.contains(""));
					break;
					case "p":
						bb.or(nc.pname.eq(keyword));
					break;
					case "d1":
						bb.or(nc.noticeDate.between(from, to));
					break;
					case "d2":
						bb.or(nc.noticeResDate.between(from, to));
					break;
					case "d3":
						bb.or(nc.noticeDesDate.between(from, to));
					break;
				}
			}
			query.where(bb);
		}
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<NoticeCheck> list = query.fetch();
		Page<NoticeCheck> result = new PageImpl<>(list, pageable, query.fetchCount());
		
		return result;
	}


	@Override
	public Page<NoticeCheck> searchTodayByResDate(LocalDateTime today, LocalDateTime tomorrow, Pageable pageable) {
		QNoticeCheck nc = QNoticeCheck.noticeCheck;
		
		JPQLQuery<NoticeCheck> query = from(nc);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		if(today != null && tomorrow != null) {
			bb.or(nc.noticeResDate.between(today, tomorrow));
			query.where(bb);
		}
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<NoticeCheck> list = query.fetch();
		Page<NoticeCheck> result = new PageImpl<>(list, pageable, query.fetchCount());
		
		return result;
	}


	@Override
	public Page<NoticeCheck> searchTodayByDesDate(LocalDateTime today, LocalDateTime tomorrow, Pageable pageable) {
		QNoticeCheck nc = QNoticeCheck.noticeCheck;
		
		JPQLQuery<NoticeCheck> query = from(nc);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		if(today != null && tomorrow != null) {
			bb.or(nc.noticeDesDate.between(today, tomorrow));
			query.where(bb);
		}
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<NoticeCheck> list = query.fetch();
		Page<NoticeCheck> result = new PageImpl<>(list, pageable, query.fetchCount());
		
		return result;
	}

}
