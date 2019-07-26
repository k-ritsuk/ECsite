package com.internousdev.ecsite.dto;
//商品を登録、購入する画面作成
//ログインするときのId、パスワード、ユーザー名を登録

public class LoginDTO {

//DBから取得した情報を格納するため
	//tableから取得するデータに対応したフィールド変数を宣言
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	//boolean型とは、trueまたはfalseの
	//どちらかのデータが必ず入ることが決まっているデータ型。


	public String getLoginId(){

		return loginId;

	}


	public void setLoginId(String loginId){

		this.loginId = loginId;

	}

	public String getLoginPassword(){

		return loginPassword;

	}

	public void setLoginPassword(String loginPassword){

		this.loginPassword = loginPassword;

	}

	public String getUserName(){

		return userName;

	}

	public void setUserName(String userName){

		this.userName = userName;

	}

	public boolean getLoginFlg(){

		return loginFlg;

	}

	public void setLoginFlg(boolean loginFlg){

		this.loginFlg = loginFlg;

	}


}