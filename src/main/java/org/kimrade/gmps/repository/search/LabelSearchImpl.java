package org.kimrade.gmps.repository.search;

import java.util.List;

import org.kimrade.gmps.domain.Label;
import org.kimrade.gmps.domain.QLabel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;

public class LabelSearchImpl extends QuerydslRepositorySupport implements LabelSearch {

	public LabelSearchImpl() {
		super(Label.class);
	}

	@Override
	public Page<Label> searchByKeyword(String keyword, Pageable pageable) {
		
		QLabel ql = QLabel.label;
		
		JPQLQuery<Label> query = from(ql);
		
		BooleanBuilder bb = new BooleanBuilder();
		
		if(keyword != null) {
			bb.or(ql.pno.contains(keyword));
			query.where(bb);
		}
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<Label> list = query.fetch();
		Page<Label> result = new PageImpl<>(list,pageable,query.fetchCount());
		
		return result;
	}
}
