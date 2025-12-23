package kr.co.sist.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RangeDTO {
	private int startNum, endNum;//시작번호, 끝번호
	private String field, keyword;//검색필드 1,2,3, 검색 값
	private String fieldStr;//검색필드(1,2,3)에 대응되는 컬럼명의 문자열(getter에서 작업 함)
	private String url;// 이동할 URL
	private int currentPage=1;//현재페이지. 첫페이지는 1이니깐 1 초기값으로 설정.
	private int totalPage=0;//총 페이지

	public String getFieldStr() {
		String[] filedTitle= {"title", "content", "id"};//검색 조건을 1,2,3으로 구별하여 title,content,id를 넣어줌. 검색 조건 보면 3가지 있는데 그거임.
		int tempField = Integer.parseInt(field);
		if( !(tempField > 0 && tempField < 4) ) {//사용자가 필드 숫자를 지맘대로 바꾼 경우 1로 고정.
			tempField=1;
		}//end if
		fieldStr=filedTitle[tempField-1];
		return fieldStr;
	}
	
}//class
