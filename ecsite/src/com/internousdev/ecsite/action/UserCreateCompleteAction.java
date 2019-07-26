package com.internousdev.ecsite.action;
//ユーザー登録機能の作成

import java.sql.SQLException;
import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
									//↑継承する			↑インターフェイスを実装
									//↑ActionSupportから	↑SessionAwareで書いたメソッドと
									//↑UserCreateComplete	↑同じメソッドをActionSupportに書き、
									//↑Acitonへ継承する。	↑さらに処理内容を書く。


		//フィールド変数
		//JSPから受け取る値を定義。今回の場合userCreateConfrim.jspから送られたのを受け取っている。
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();



						//↓メソッド名は「execute」にする。
		public String execute() throws SQLException{

			userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),//sessionから値を取り出す。
								session.get("loginPassword").toString(),			//sessionから値を取り出す。
								session.get("userName").toString());				//sessionから値を取り出す。
														//↑DAO経由して、
														//入力された内容に登録する。
														//この場合UserCreateCompleteDAOを経由して登録する。

			String result = SUCCESS;//←メソッドの戻り値「execute」を定義し、初期値にSUCCESSを代入。

			return result;//条件に見たした時、SUCCESSに書き換える。
		}

															//sessionに値を登録するには session.put().
															//sessionの値を取り出すには session.get().


		public String getloginUserId(){

			return loginUserId;

		}

		public void setLoginUserId(String loginUserId){

			this.loginUserId = loginUserId;

		}

		public String getLogiPassword(){

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

		public Map<String,Object> getsession(){

			return session;

		}

		@Override
		public void setSession(Map<String,Object> session){

			this.session = session;
		}


}
