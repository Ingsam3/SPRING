package net.daum.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter 
public class BoardDTO {

	private int bno;
	private String bname;//글쓴이
	private String btitle;//글제목->bbs_title컬럼이 생성
	private int bhit;//조회수
	private String bdate;//조회수
}
