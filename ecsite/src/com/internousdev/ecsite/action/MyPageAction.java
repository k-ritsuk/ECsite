package com.internousdev.ecsite.action;

import java.sql.SQLException;
//Mapとは、キーと要素とのマッピングを表す。キーで要素を識別。
//Mapでセッションオブジェクトにアクセスする。
import java.util.ArrayList;

//ここから、購入履歴機能の作成
//購入履歴画面

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
//Actionとは、JSPかた送られてきた「ページ要求」に対して、一番最初に実行されるjava側のクラスファイル
//DBに接続が必要な場合は、DAOを呼び出し処理を行う。

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{
							//↑継承する			↑インターフェイスを実装
							//↑ActionSupportから	↑SessionAwareで書いたメソッドと
							//MyPageActionへ		↑同じメソッドをActionSupportに書き、
							//継承する。  			↑さらに処理内容を書く。

			//フィールド変数
			public Map<String,Object> session;
			private MyPageDAO myPageDAO = new MyPageDAO();
			private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
			private String deleteFlg;
			private String message;

			//メソッド名をexecute()にする。
			public String execute()throws SQLException{


				if(!session.containsKey("logi_user_id")){//←sessionに該当するlogin_user_idが存在するかチェックする

					return ERROR;
				}

				if(deleteFlg == null){//履歴の削除がされているか否か、チェックしている。

						//↓sessionから取得した商品情報をmyPageDAOのgetMyPageUserInfoメソッドに渡している。
				String item_transaction_id = session.get("id").toString();
				String user_master_id = session.get("login_user_id").toString();

				myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
				//↑DBから取得した履歴情報を、「myPageList」に格納しています。

				//sessionに値を登録するには session.put().
				//sessionの値を取り出すには session.get().


			}else if(deleteFlg.equals("1")){

				delete();//deleteメソッドを呼び出して、履歴の削除処理を行う。

			}

				String result = SUCCESS;
				return result;


			}
				//メソッド名をdelete()にしている。
			public void delete() throws SQLException{
													//↓	履歴の削除を行うためのメソッド
					String item_transaction_id = session.get("id").toString();
					String user_master_id = session.get("login_user_id").toString();


					//↓DBから取得した履歴情報を、「res」に格納しています。
					int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);


					if(res > 0){//resが0より大きかったら、削除した。0と一緒だったら失敗しました。messageを指定。

						myPageList = null;
						setMessage("商品情報を正しく削除しました。");

					}else if(res == 0){

							setMessage("商品情報を削除に失敗しました。");
					}//↑１件以上削除されたか否かで正常に削除処理されたか判別する。

			}

			public void setDeleteFlg(String deleteFlg){

				this.deleteFlg = deleteFlg;
			}

			@Override
			public void setSession(Map<String,Object> session){

				this.session = session;
			}

			public ArrayList<MyPageDTO> getMyPageList(){

				return myPageList;
			}

			public void setMyPageList(ArrayList<MyPageDTO> myPageList){

				this.myPageList = myPageList;
			}

			public String getMessage(){

				return message ;

			}

			public void setMessage(String message){

				this.message = message;

			}








}
