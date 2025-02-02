package org.kimrade.gmps.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

// 응답페이지 구성을 위한 객체
@Log4j2
@Getter
@ToString
public class PageResponseDTO2<E> {
	private int page;
	private int size;
	private int total;
	
	private int start;
	private int end;
	
	private boolean prev;
	private boolean next;
	
	private List<E> dtoList;  
	
	// 페이지 처리를 위한 메소드 
	@Builder(builderMethodName="withAll")
	public PageResponseDTO2(PageRequestDTO2 pageRequestDTO2, List<E> dtoList, int total) {
		this.page = pageRequestDTO2.getPage2();
		this.size = pageRequestDTO2.getSize2();
		this.dtoList = dtoList;
		this.total = total;
		
		// - 페이지 바 셋팅 -
		// 페이지 바의 끝은 -> (올림(현재페이지/10))*10		예> 27페이지면, 끝 페이지는 30
		// 올림 처리후 -> 값을 곱하기 전 int로 형변환후 사이즈 값을 곱함.
		this.end = (int)(Math.ceil(this.page/10.0))*10;
		this.start = this.end-9;
		
		// 실제 마지막 페이지 -> 올림 (전체 글개수 / size)
		// 예> 전체글이 141개고 한페이지에 10개씩 보여줄때 마지막 페이지는 15페이지
		int last = (int)Math.ceil((double)this.total/this.size);
		//end = (end > last) ? last : end ;
		if(this.end>last) this.end=last;
		
		// 이전으로 가기 
		this.prev = this.start > 1;
		
		// 이후로 가기(마지막 페이지 바의 계산 값은 total 값과 동일하거나 크기에)
		this.next = this.total > this.end*size;
		
	}
	
	
}
