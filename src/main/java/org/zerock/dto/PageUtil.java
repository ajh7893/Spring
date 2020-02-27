package org.zerock.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageUtil {

	private PageDTO dto;
	private int total, start, end;
	private boolean prev, next;

	public PageUtil(PageDTO dto, int total) {
		this.dto = dto;
		this.total = total;

		int pageNum = dto.getPage();
		
		// end 반올림
		int tempEnd = (int)Math.ceil(pageNum / 10.0) * 10;

		// start 음수가 있으면 안됨. 3항연산자  9보다 작으면 1 아니면 그값
		this.start = tempEnd - 9 < 0 ? 1 : tempEnd - 9;

		// 1이 아니면
		this.prev = this.start != 1; //false

		// 엔드값
		int realEnd = (int)(total / 10.0);

		// 123건이라면, 12 > 20 false
		this.next = realEnd > tempEnd;

		if (realEnd > tempEnd) {
			this.end = tempEnd;

		} else {
			this.end = realEnd + 1;
		}

	}

}
