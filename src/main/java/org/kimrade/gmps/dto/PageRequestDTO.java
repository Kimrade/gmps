package org.kimrade.gmps.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 사용자가 페이지를 요청할때 추가정보(페이지정보, 검색정보)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
	
	@Builder.Default
	private int page=1;
	
	@Builder.Default
	private int size=10;
	
	private String type;	// 검색어로 공고명, 날짜, 플랫폼 - n, d1, d2, d3, p
	
	private String keyword;
	
	
	// type을 문자열의 배열로 만들어서 리턴
	public String[] getTypes() {	// el등에서는 이와 같이 사용해야 호출됨 types
		if(type == null || type.isEmpty()) {
			return null;
		}
		return type.split("");
	}
	
	
	// Pageable 객체 리턴용
	public Pageable getPageable(String...props) {
		return PageRequest.of(page-1, size, Sort.by(props).descending());
	}
	
	
	// 링크용 쿼리스트링을 만들어주는 메소드
	private String link;
	
	public String getLink() {
		
		if(link == null) {
			StringBuilder builder = new StringBuilder();
			builder.append("page="+this.page);
			builder.append("&size="+this.size);
			
			if(type != null && type.length()>0) {
				builder.append("&type="+this.type);
			}
			if(keyword != null) {
				builder.append("&keyword="+this.keyword);
			}
			link = builder.toString();
		}
		return link;
	}
	
	
	
}