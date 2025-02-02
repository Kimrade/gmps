package org.kimrade.gmps.repository.search;

import org.kimrade.gmps.domain.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LabelSearch {
	public Page<Label> searchByKeyword(String keyword, Pageable pageable);
}
