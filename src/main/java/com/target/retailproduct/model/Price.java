package com.target.retailproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Price {

	@JsonIgnore
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private long value;
	private CurrencyTypeEnum currencyCode;
	
	public long getValue() {
		return value;
	}
	public CurrencyTypeEnum getCurrencyCode() {
		return currencyCode;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public void setCurrencyCode(CurrencyTypeEnum currencyCode) {
		this.currencyCode = currencyCode;
	} 
	
	@Override
	public String toString(){
		return value+currencyCode.name();
	}
}
