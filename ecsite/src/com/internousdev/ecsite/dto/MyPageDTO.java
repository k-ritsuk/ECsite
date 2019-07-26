package com.internousdev.ecsite.dto;
//購入履歴機能の作成



//DTOクラスは、DAOがDBから取得した値をActionへ戻す時、値を格納するのに利用。
//DTOクラスには、必要なテーブルのデータのカラムに対応したフィールド変数とgetter/setterのみを定義。

public class MyPageDTO {

	private String id;

	private String itemName;

	private String totalPrice;

	private String totalCount;

	private String payment;

	private String insert_date;


	public String getId(){

		return id;
	}

	public void setId(String id){

		this.id = id;

	}

	public String getItemName(){

		return itemName;

	}

	public void setItemName(String itemName){

		this.itemName = itemName;

	}

	public String getTotalPrice(){

		return totalPrice;

	}

	public void setTotalPrice(String totalPrice){

		this.totalPrice = totalPrice;

	}

	public String getTotalCount(){

		return totalCount;

	}

	public void setTotalCount(String totalCount){

		this.totalCount = totalCount;


	}

	public String getPayment(){

		return payment;

	}

	public void setPayment(String payment){

		this.payment = payment;

	}

	public String getInsert_date(){

		return insert_date;

	}

	public void setInsert_date(String insert_date){

		this.insert_date = insert_date;

	}

}
