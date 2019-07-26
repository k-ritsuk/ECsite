package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//購入履歴機能を作成

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行う。
//問い合わせで取得した値をDTOクラスに格納。

public class MyPageDAO {


		//DBの接続準備
	private DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();


	//↓DBから購入履歴を取得するためのメソッド
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws SQLException{

		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();//複数の要素を順番に保持する。


							//sql文を見る
							//テーブルA.カラム1,テーブルA.カラム1,・・・と続いていく
		String sql ="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date "
					//↑SELECT文は、テーブルに入っているデータを抽出。取得するために使用する。
				+ "FROM user_buy_item_transaction ubit "		//テーブルA
				+ "LEFT JOIN item_info_transsaction iit "		//テーブルB		//「LEFTJOIJN」を用いて複数のテーブルを結合することによって
																				//ユーザー情報と履歴情報を紐づけて一括することがある
				+ "ON ubit.item_transaction_id = iit.id "		//ON は	結合条件 tableA.カラム1 = tableB.カラム2
				+ "WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? "
					//↑where句は検索条件：
				+ "ORDER BY insert_date DESC" ;	//ソート DESCは大きい順(降順)に並ぶ。
				//↑SELECT文は、テーブルに入っているデータを抽出。取得するために使用する。

		try{

				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, item_transaction_id);//1番目の?にActionから送られてきたitem_transaction_id.
				preparedStatement.setString(2, user_master_id);		//2番目の?にActionから送られてきたuser_master_id.


				ResultSet resultSet = preparedStatement.executeQuery();


				while(resultSet.next()){

					MyPageDTO dto = new MyPageDTO();
					dto.setId(resultSet.getString("id"));					//取得した結果を１件ずつDTOに格納し。更にDTOをArrayListに格納している。
					dto.setItemName(resultSet.getString("item_Name"));		//取得した結果を１件ずつDTOに格納し。更にDTOをArrayListに格納している。
					dto.setTotalPrice(resultSet.getString("total_price"));	//取得した結果を１件ずつDTOに格納し。更にDTOをArrayListに格納している。
					dto.setTotalCount(resultSet.getString("total_count"));	//取得した結果を１件ずつDTOに格納し。更にDTOをArrayListに格納している。
					dto.setPayment(resultSet.getString("pay"));				//取得した結果を１件ずつDTOに格納し。更にDTOをArrayListに格納している。
					dto.setInsert_date(resultSet.getString("insert_date"));	//取得した結果を１件ずつDTOに格納し。更にDTOをArrayListに格納している。
					myPageDTO.add(dto);
				}

		}catch(Exception e){

			e.printStackTrace();//←処理中に例外が発生した際に、実行する処理。
		}finally{

			connection.close();//DB接続を終了する際は、必ず書く
		}
		return myPageDTO;

	}

		//↓DBから購入履歴を削除するためのメソッド。
		public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{


				String sql= "DELETE EROM user_buy_item_transaction "			 //テーブルに入っているデータを削除するためのSQL文
											//↑削除したい対象のテーブル名を書く。

						+ "WHERE item_transaction_id = ? AND user_master_id = ?";
							//↑where句は検索条件： A かつ B


			PreparedStatement preparedStatement;
			int result = 0;

		try{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, item_transaction_id);//1番目の?にActionから送られてきたitem_transaction_id.
				preparedStatement.setString(2, user_master_id);		//2番目の?にActionから送られてきたuser_master_id.

											//↓DELETE文なのでexecuteUpdate()で実行。
				result = preparedStatement.executeUpdate();
		}catch(SQLException e){//データべース処理に関する例外

			e.printStackTrace();//データべース処理に関する例外

		}finally{

			connection.close();//DB接続を終了する際は、必ず書く

		}

		return result;//Actionクラスに削除した件数を返す。


		}

}

