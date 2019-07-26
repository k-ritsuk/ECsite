package com.internousdev.ecsite.action;

//商品購入機能の作成
//選択している商品の確認画面
//購入方法を選択を表している。
import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

public class BuyItemAction extends ActionSupport implements SessionAware{
							//↑継承する			↑インターフェイスを実装
							//↑ActionSupportから	↑SessionAwareで書いたメソッドと
							//BuyItemAcitonへ継承する。  同じメソッドをActionSupportに書き、さらに処理内容を書く。

		//フィールド変数
		//JSPから受け取る値を定義。今回はbuyItem.jspから受け取る
		public Map<String,Object> session;
		private int count;
		private String pay;


		//メソッド名をexecuteにする
		public String execute(){

			String result = SUCCESS;//メソッドの戻り値を result にして初期値にSUCCESSを代入。


			session.put("count",count);//←DBから取得した商品情報をsessionに格納している。



			//↓sessionをString型にしてくださいの後に、Int型にしてください。
			String strCount = session.get("count").toString();
			int intCount = Integer.parseInt(strCount);

			//↓簡略化.sessionをString型にしてくださいの後に、Int型にしてください。
			int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
			//↑INT型にしたいときに書く文

			session.put("total_price", intCount*intPrice);
			//↑IntCountとIntPriceをかけたのをsessionに格納している。



			//↓buyItem.jspから要求されたもの、購入方法を表している。
			String payment;

			if(pay.equals("1")){

				payment = "現金払い";
				session.put("pay",payment);
			}else{
				payment = "クレジットカード";
				session.put("pay", payment);
			}
			return result;//条件に見たした時、SUCCESSに書き換える。
		}

		public void setCount(int count){

			this.count = count;
		}

		public void setPay(String pay){

			this.pay = pay;

		}
		@Override
		public void setSession(Map<String,Object> session){

			this.session = session;
		}


}