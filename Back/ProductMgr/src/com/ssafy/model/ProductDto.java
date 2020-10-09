package com.ssafy.model;

public class ProductDto {
	private int no;
	private String name;
	private int price;
	private String content;
	
	public ProductDto() {}
	public ProductDto(int no, String name, int price, String content) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ProductDto [no=" + no + ", name=" + name + ", price=" + price + ", content=" + content + "]";
	}
	
	
}
