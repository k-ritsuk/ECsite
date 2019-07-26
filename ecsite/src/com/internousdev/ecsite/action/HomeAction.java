package com.internousdev.ecsite.action;

import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;
//struts2で提供されているインターフェイス
//sessionを使用したいActionでSessionAwareを実装

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;

//  ログイン機能の作成
										//ログイン画面作成

import com.opensymphony.xwork2.ActionSupport;

//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。



															//↓インターフェイス
public class HomeAction extends ActionSupport implements SessionAware{
						//↑継承する			↑インターフェイスを実装
						//↑ActionSupportから	↑SessionAwareで書いたメソッドと
						//HomeAcitonへ継承する。  同じメソッドをActionSupportに書き、さらに処理内容を書く。

		//フィールド変数
		//JSPから受け取る値、を定義。今回の場合home.jspとuserCreateComplete.jspから受けとる値。
		public Map<String,Object> session;
				//Mapでセッションオブジェクトにアクセスする。



		public String execute(){
								//↓いまからログインする際の記述
				String result="login";
				//↓ログイン済み判定を行う
				if(session.containsKey("login_user_id")){
						//↑sessionに該当するlogin_user_idが存在するか否かをチェック


						BuyItemDAO buyItemDAO = new BuyItemDAO();
						BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();


						session.put("id", buyItemDTO.getId());	//←DBから取得した商品情報をsessionに格納している。
						session.put("buyItem_name", buyItemDTO.getItemName());
						session.put("buyItem_price", buyItemDTO.getItemPrice());
						//↑ログイン済み判定を行う


						return result = SUCCESS;//もうログインしていたときの記述

				}

				return result;//「execute」メソッドを戻り値にして、ログイン状態の場合は、「SUCCESS」
							  //ログインしていない場合は、「"login"」を返す。

		}
		@Override
		public void setSession(Map<String,Object> session){

			this.session = session;



		}

		public Map<String,Object> getSession(){

			return session;
		}







}
