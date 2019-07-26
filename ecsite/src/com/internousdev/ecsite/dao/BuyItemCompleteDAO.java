package com.internousdev.ecsite.dao;



//商品購入機能の作成
//購入手続き完了画面
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行う。
//問い合わせで取得した値をDTOクラスに格納。




public class BuyItemCompleteDAO {

		public void buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay)throws SQLException{

				//DBへの接続準備
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();

			DateUtil dateUtil = new DateUtil();
				//インスタンス化（コピー)

			String sql ="INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay) VAUES(?,?,?,?,?,?)";
				//INSERT文は、データをテーブルに書き込む
				//今回は購入した商品の全部の情報を書き込んでいるためINSERT文

			try{
							//↓SQL文の?に指定した値を挿入する。
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, item_transaction_id);//1番目の?にActionから送られてきたitem_transaction_id.
				preparedStatement.setString(2, total_price);		//2番目の?にActionから送られてきたtotal_price.
				preparedStatement.setString(3, total_count);		//3番目の?にActionから送られてきたtotal_count.
				preparedStatement.setString(4, user_master_id);	//4番目の?にActionから送られてきたuser_master_id.
				preparedStatement.setString(5, pay);	//5番目の?にActionかた送られてきたpay.
				preparedStatement.setString(6, dateUtil.getDate());	//6番目の?にDateUtilが設定している現在の日時を取得するためにdateUtil.
				preparedStatement.execute();						//現在の日時を取得している。

			}catch(Exception e){

				e.printStackTrace();

			}finally{

				connection.close();
			}


		}
					//←処理中に例外が発生した際に、実行する処理。
				//DB接続を終了する際は、必ず書く

				}