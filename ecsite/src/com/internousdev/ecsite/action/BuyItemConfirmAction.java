package com.internousdev.ecsite.action;

//商品購入機能の作成
//購入手続き完了画面
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。
import com.opensymphony.xwork2.ActionSupport;


//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
									//↑継承する			↑インターフェイスを実装
									//↑ActionSupportから	↑SessionAwareで書いたメソッドと
									//BuyItemConfirmAciton	↑同じメソッドをActionSupportに書き、
									//へ継承する。  		↑さらに処理内容を書く。


			//フィールド変数
			//JSPから受け取る値を定義。今回はbuyItemConfirm.jspから受け取っている。
		public Map<String,Object> session;
		private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
		//BuyItemCompleteDAOを呼び出している。

					//メソッド名をexecuteにする
		public String execute() throws SQLException{

				//↓sessionから取得した商品情報をBuyItemCompleteDAOのbuyItemInfoメソッドに渡している。
			buyItemCompleteDAO.buyItemInfo(//ser_buy_item_transactionからとっている。最終確認の所
					session.get("id").toString(),			//item_transaction_idのこと（商品の名前?)
					session.get("total_price").toString(),	//買った合計の値段
					session.get("count").toString(),		//買った合計個数
					session.get("login_user_id").toString(),//ログインしたuserのId
					session.get("pay").toString());			//購入方法

			String result = SUCCESS;//条件に見たした時、SUCCESSに書き換える。
			return result;
		}

		@Override
		public void setSession(Map<String,Object> session){

			this.session = session;
		}
}
