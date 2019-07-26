package com.internousdev.ecsite.dao;
//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行う。
//商品を登録、購入する画面作成


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;




public class LoginDAO {
			//DBへの接続準備
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();

	LoginDTO loginDTO = new LoginDTO();
		//インスタンス化（コピー)


	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
			//↑LoginDTO型を戻り値にしたメソッドを作る。Actionクラスの値を引数として受け取る。

		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";
		// login_user_transactionの中login_id =? かつ login_pass=? の2つの条件にあったものを代入される。
		//SELECT文は  抽出


		try{

				PreparedStatement preparedStatement = connection.prepareStatement(sql);




				preparedStatement.setString(1, loginUserId);//1番目の？にActionから送られてきたloginUserId
				preparedStatement.setString(2, loginPassword);//2番目の?にAcitonから送られてきたloginPasswordがそれぞれ入る。


				ResultSet resultSet = preparedStatement.executeQuery();//select文のSQL文を実行するメソッドで、戻り値をResultSetになる。


				if(resultSet.next()){
						loginDTO.setLoginId(resultSet.getString("login_id"));
						loginDTO.setLoginPassword(resultSet.getString("login_pass"));
						loginDTO.setUserName(resultSet.getString("user_name"));
						//select文でDBから取得する情報をString型に変換してDTOクラスに格納する。
						//LoginDTOクラスのsetLoginId,setLoginPassword,setUserName(setter)を利用。


						if(resultSet.getString("login_id") != null){
							loginDTO.setLoginFlg(true);
						}
				}


				}catch(Exception e){
					e.printStackTrace();//←処理中に例外が発生した際に、実行する処理。
				}

				return loginDTO;//ActionクラスにDTOクラスを返す。
		}
	}




