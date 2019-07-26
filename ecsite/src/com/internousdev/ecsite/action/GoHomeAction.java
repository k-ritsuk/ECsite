package com.internousdev.ecsite.action;
//ここでは、一番最初の画面を作成

import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

public class GoHomeAction extends ActionSupport implements SessionAware{
							//↑継承する			↑インターフェイスを実装
							//↑ActionSupportから	↑SessionAwareで書いたメソッドと
							//↑GoHomeActionへ		↑同じメソッドをActionSupportに書き、
							//↑継承する。


		public Map<String,Object> session;

		public String execcute(){

				return SUCCESS;
		}

		public Map<String,Object> getSession(){

			return session;

		}


		@Override
		public void setSession(Map<String,Object> session){

			this.session = session;

		}

}
