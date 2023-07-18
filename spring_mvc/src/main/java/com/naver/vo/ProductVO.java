package com.naver.vo;
//상품 명과 가격을 중간 저장하는 데이터 저장빈 클래스

public class ProductVO {
	private String name;
	private int price;
	
	public ProductVO() {}
	//생성자 오버로딩
	public ProductVO(String name, int price) {
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	
	

}
