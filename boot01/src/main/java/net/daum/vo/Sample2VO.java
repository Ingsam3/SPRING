package net.daum.vo;

import lombok.Data;
import lombok.ToString;

@Data //setter(),getter(),toString()메서드 등 자동 생성
@ToString(exclude = {"val03"}) //exclude를 사용해서 toString()메서드를 호출했을 때 val03변수를 제외
//시키고 출력한다.
public class Sample2VO {//데이터 저장빈 클래스

	private String val01;
	private String val02;
	private String val03;
	
}
