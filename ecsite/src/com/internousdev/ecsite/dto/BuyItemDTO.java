package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private String itemName;
	private String itemPrice;
	private int id;

	public int getId(){

		return id;

	}

	public void setId(int id){

		this.id = id;

	}

	public String getItemPrice(){

		return itemPrice;

	}

	public void setItemPrice(String itemPrice){

		this.itemPrice = itemPrice;

	}

	public String getItemName(){

		return itemName;

	}

	public void setItemName(String itemName){

		this.itemName = itemName;

	}

}
