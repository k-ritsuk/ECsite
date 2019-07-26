package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

//ユーザー登録機能の作成

import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行う。
//問い合わせで取得した値をDTOクラスに格納。

public class UserCreateCompleteDAO {


		//DBへの接続準備
	DBConnector dbConnector = new DBConnector();
	Connection connection = dbConnector.getConnection();
	//登録した生年月日を登録
	DateUtil dateUtil = new DateUtil();
	//インスタンス化（コピー）

	public String sql = "INSERT INTO logjn_user_transaction(login_id,login_pass,user_name,insert_date) VALUES(?,?,?,?)";
			//INSERT文は、データをテーブルに書き込む
			//今回は新規ユーザーを登録するからINSERT文

	public void createUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{
					//↑Actionクラスの値を引数として受け取る。

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, loginUserId);//１番目の?にActionから送られたloginUserId.

				preparedStatement.setString(2, loginUserPassword);//2番目の?にActionから送られたloginUserPassword.

				preparedStatement.setString(3, userName);//3番目の?にActionから送られたuserName.

				preparedStatement.setString(4, dateUtil.getDate());//4番目の?にDateUtilから送られたdateUtil.

				preparedStatement.execute();
			}catch(Exception e){

				e.printStackTrace();//←処理中に例外が発生した際に、実行する処理。


			}finally{

				connection.close();//DB接続を終了する際は、必ず書く。

			}


	}


}