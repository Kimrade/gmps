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
	public Page<NoticeCheck> searchByKeyword(String[] types, String keyword, Pageable pageable) {
		QNoticeCheck nc = QNoticeCheck.noticeCheck;
		
		JPQLQuery<NoticeCheck> query = from(nc);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		if((types != null && types.length > 0) && keyword != null) {
			for(String type : types) {
				switch(type) {
					case "b":
						bb.or(nc.noticeName.contains(keyword));
					break;
					case "c":
						bb.or(nc.pname.eq(keyword));
					break;
					case "a":
						bb.or(nc.noticeNo.contains(keyword));
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
	public Page<NoticeCheck> searchTodayByResDate(Pageable pageable) {
		QNoticeCheck nc = QNoticeCheck.noticeCheck;
		
		JPQLQuery<NoticeCheck> query = from(nc);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		bb.or(nc.noticeResDate.between(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(3L)));
		query.where(bb);
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<NoticeCheck> list = query.fetch();
		Page<NoticeCheck> result = new PageImpl<>(list, pageable, query.fetchCount());
		
		return result;
	}


	@Override
	public Page<NoticeCheck> searchTodayByDesDate(Pageable pageable) {
		QNoticeCheck nc = QNoticeCheck.noticeCheck;
		
		JPQLQuery<NoticeCheck> query = from(nc);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		bb.or(nc.noticeDesDate.between(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(3L)));
		query.where(bb);
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<NoticeCheck> list = query.fetch();
		Page<NoticeCheck> result = new PageImpl<>(list, pageable, query.fetchCount());
		
		return result;
	}

}
