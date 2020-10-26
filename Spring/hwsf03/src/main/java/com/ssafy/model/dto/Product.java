package com.ssafy.model.dto;

public class Product {
	
	/**************************** 멤버 변수 ****************************/
	private int no;
	private String id;
	private String name;
	private int price;
	private String content;
	
	/**************************** 생성자 ****************************/
	
	public Product() {}
	public Product(int no, String name, int price, String content) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.content = content;
	}
	
	public Product(String id, String name, int price, String content) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.content = content;
	}
	/**************************** Getters/Setters ****************************/
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Product [no=" + no + ", id=" + id + ", name=" + name + ", price=" + price + ", content=" + content
				+ "]";
	}
	
	
}
