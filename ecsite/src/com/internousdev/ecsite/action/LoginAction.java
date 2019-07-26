package com.internousdev.ecsite.action;
//ここでは、商品を登録、購入する画面作成
	//商品画面の作成
import java.util.Map;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。

import org.apache.struts2.interceptor.SessionAware;
//struts2で提供されているインターフェイス
//sessionを使用したいActionでSessionAwareを実装

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

																//↓インターフェイス
public class LoginAction extends ActionSupport implements SessionAware{
							//↑継承する			↑インターフェイスを実装
							//↑ActionSupportから	↑SessionAwareで書いたメソッドと
							//↑LoginAcitonへ		↑同じメソッドをActionSupportに書き、
							//↑継承する。  		↑さらに処理内容を書く。


		private String loginUserId;
		private String loginPassword;
		public Map<String,Object>session;
		private LoginDAO loginDAO = new LoginDAO();
		private LoginDTO loginDTO = new LoginDTO();
		private BuyItemDAO buyItemDAO = new BuyItemDAO();


		public String execute(){

			String result = ERROR;//初期値をERRORにしてログイン失敗したらERRORが出てここに戻る。

			//↓loginDAOの中にあるgetLoginUserInfo()を呼び出し、loginDTOに代入。
			loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);


			if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
					result = SUCCESS;
					BuyItemDTO  buyItemDTO = buyItemDAO.getBuyItemInfo();


					//入力値からユーザー情報の検索を行う。
					//ログイン認証が成功したら、次の画面で
					//商品情報が必要だから商品情報を取得
					session.put("login_user_id", loginDTO.getLoginId());//userの検索だからloginDTOが入る。
					session.put("id",buyItemDTO.getId());					//商品情報を取得しているから、buyItemDTOが入る。
					session.put("buyItem_name",buyItemDTO.getItemName());	//商品情報を取得しているから、buyItemDTOが入る。
					session.put("buyItem_price",buyItemDTO.getItemPrice()); //商品情報を取得しているから、buyItemDTOが入る。

					//Mapを使っているからput()で要素を記憶

				//ここまで
					return result;


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


			public Map<String,Object> getSession(){

				return session;

			}

			@Override
			public void setSession(Map<String,Object> session){

				this.session = session;

			}







		}




