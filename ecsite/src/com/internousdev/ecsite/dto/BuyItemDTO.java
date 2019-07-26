package com.internousdev.ecsite.dto;
//商品を登録、購入する画面作成
//商品の名前、値段、在庫を登録。

public class BuyItemDTO {

	//DBから取得した情報を格納するため
		//tableから取得するデータに対応したフィールド変数を宣言
	//今回は商品の事だからecite.sqlのitem_info_transactionから使う。
	private String itemName;
	private String itemPrice;
	private int id;

	//テーブルカラムに対応したフィールド変数を宣言する。
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



	//フィールド変数に対応したGetter、Setterを定義。


}
