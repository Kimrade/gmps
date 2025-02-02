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
public class PageRequestDTO2 {
	
	@Builder.Default
	private int page2=1;
	
	@Builder.Default
	private int size2=5;
	
	private String type2;	// 검색어로 공고명, 날짜, 플랫폼 - n, d1, d2, d3, p
	
	private String keyword2;
	
	
	// type을 문자열의 배열로 만들어서 리턴
	public String[] getTypes() {	// el등에서는 이와 같이 사용해야 호출됨 types
		if(type2 == null || type2.isEmpty()) {
			return null;
		}
		return type2.split("");
	}
	
	
	// Pageable 객체 리턴용
	public Pageable getPageable(String...props) {
		return PageRequest.of(page2-1, size2, Sort.by(props).descending());
	}
	
	
	// 링크용 쿼리스트링을 만들어주는 메소드
	private String link;
	
	public String getLink() {
		
		if(link == null) {
			StringBuilder builder = new StringBuilder();
			builder.append("page="+this.page2);
			builder.append("&size="+this.size2);
			
			if(type2 != null && type2.length()>0) {
				builder.append("&type="+this.type2);
			}
			if(keyword2 != null) {
				builder.append("&keyword="+this.keyword2);
			}
			link = builder.toString();
		}
		return link;
	}
	
	
	
}