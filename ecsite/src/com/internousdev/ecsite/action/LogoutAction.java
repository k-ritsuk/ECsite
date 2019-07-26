package com.internousdev.ecsite.action;

//購入履歴機能の作成
//最初の画面に戻る。
import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

public class LogoutAction extends ActionSupport implements SessionAware{
							//↑継承する			↑インターフェイスを実装
							//↑ActionSupportから	↑SessionAwareで書いたメソッドと
							//LogoutActionへ		↑同じメソッドをActionSupportに書き、
							//継承する。  			↑さらに処理内容を書く。



	public Map<String,Object>session;
	public String execute(){
		session.clear();
		return SUCCESS;

	}
	@Override
	public void setSession(Map<String,Object> session){

		this.session = session;
	}

}
