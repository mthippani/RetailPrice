package com.target.retailproduct.model;

public class Product {

	private int id;
	private String name;
	private Price currentPrice;
	
	public Product(){
		
	}
	
	public Product(int id, String name, long price, String currency){
		this.id = id;
		this.name = name;
		Price amt = new Price();
		amt.setValue(price);
		CurrencyTypeEnum currencyCode = CurrencyTypeEnum.valueOf(currency);
		amt.setCurrencyCode(currencyCode);
		this.currentPrice = amt;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Price getCurrentPrice() {
		return currentPrice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentPrice(Price currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	@Override
	public String toString(){
		return "id:"+id+" name:"+name+" price:"+currentPrice;
	}
	
}
