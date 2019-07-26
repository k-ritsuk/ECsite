package com.internousdev.ecsite.action;

			//ユーザー登録機能の作成

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport{
							//↑継承
							//↑AcutionSupportからUserCreateActionへ継承する。

	public String execute(){
				//新規のユーザー登録するための画面
				//login.jspの画面の中から要求されて開く。

		return SUCCESS;

	}

}
