package net.daum.vo;

import lombok.Getter;

@Getter
public class ProductVO {//중간에 데이터 저장하는 데이터 저장빈 클래스
	
	private String name;//상품 이름
	private int price;//상품 가격

	public ProductVO(String name,int price) {
		this.name=name;
		this.price=price;//멤버변수 초기화
	}//매개변수 개수를 다르게 한 생성자 오버로딩			
}