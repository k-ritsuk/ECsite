package com.internousdev.ecsite.action;
//ユーザー登録機能の作成

import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
										//↑継承する			↑インターフェイスを実装
										//↑ActionSupportから	↑SessionAwareで書いたメソッドと
										//↑UserCreateConfirm		↑同じメソッドをActionSupportに書き、
										//↑Acitonへ継承する。  	↑さらに処理内容を書く。

	//フィールド変数
	//JSPから受け取る値、を定義。今回の場合userCreate.jspから受けとる値。
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public  Map<String,Object> session;
	private String errorMessage;


				//↓メソッド名は「execute」にする。
	public String execute(){


				String result = SUCCESS;//←メソッドの戻り値「execute」を定義し、初期値にSUCCESSを代入。


			if(!(loginUserId.equals(""))//未入力項目の有無を確認
					&& !(loginPassword.equals(""))//未入力項目の有無を確認
					&& !(userName.equals(""))){//未入力項目の有無を確認
						session.put("loginUserId", loginUserId);//確認画面で表示したい値をセッションに格納します。
						session.put("loginPassword", loginPassword);//確認画面で表示したい値をセッションに格納します。
						session.put("userName",userName);//確認画面で表示したい値をセッションに格納します。
									//↑key    ↑値

			}else{


					setErrorMessage("未入力の項目があります。");//if文の条件に見たした時、SUCCESSに書き換える。
						result = ERROR;//満たさなかったときERRORになる。


			}

			return result;

			}

	public String getLoginUserId(){

			return loginUserId;


	}

	public void setLoginUserId(String loginUserId){

			this.loginUserId = loginUserId;
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


	public Map<String,Object> getSession(){

			return session;
	}

	@Override
	public void setSession(Map<String,Object> session){

			this.session = session;
	}


	public String getErrorMessage(){

		 	return errorMessage;

	}

	public void setErrorMessage(String errorMessage){

			this.errorMessage = errorMessage;
	}
}