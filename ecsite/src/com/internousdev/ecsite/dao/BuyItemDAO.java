package com.internousdev.ecsite.dao;
//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行う。
//商品を登録、購入する画面作成

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;



public class BuyItemDAO {
		//DBへの接続状態にする
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();

	BuyItemDTO buyItemDTO = new BuyItemDTO();
		//インスタンス化（コピー）

		public BuyItemDTO getBuyItemInfo(){
			//↑BuyItemDTO型を戻り値にしたメソッドを作る。


					//↓ecsite.sqlのitem_info_transactionのid,item_name,item_priceを抽出
				String sql = "SELECT id,item_name,item_price FROM item_info_transaction";
				//selece xxx from テーブル名;←抽出したい対象のテーブル名。
				//		↑抽出したいカラム名

					try{
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						ResultSet resultSet = preparedStatement.executeQuery();
														//SELECT文で実行するので、ここでexecuteQuery()になる。

						if(resultSet.next()){
									buyItemDTO.setId(resultSet.getInt("id"));
									buyItemDTO.setItemName(resultSet.getString("item_name"));
									buyItemDTO.setItemPrice(resultSet.getString("item_price"));
										//↑select文でDBから取得する情報をString型に変換してDTOクラスに格納する。
										//↑BuyItemDTOクラスのsetId,setItemName,setItemPrice(setter)を利用。
						}

					}catch(Exception e){

						e.printStackTrace();//←処理中に例外が発生した際に、実行する処理。
					}

					return buyItemDTO;	//ActionクラスにDTOクラスを返す。

		}






}
