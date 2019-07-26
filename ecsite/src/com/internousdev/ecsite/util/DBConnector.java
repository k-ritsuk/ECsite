package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

						//MySQL接続に必要な情報を設定
			private static String driverName = "com.mysql.jdbc.Driver";

			private static String url = "jdbc:mysql://localhost/ecsite";
																//↑接続先のデータべース名を設定


			private static String user = "root";

			private static String password = "mysql";









		public Connection getConnection(){
		//↑接続状態にする。
		Connection con = null;
		//↑一度初期化する。

		try{
											//↓接続情報から自分のパソコンにインストール
			Class.forName(driverName);		//↓されているされているMySQLへ接続する準備が整う。
			con= (Connection) DriverManager.getConnection(url,user,password);

		}catch(ClassNotFoundException e){
				//↑クラスが見つからなかった場合の例外

			e.printStackTrace();

		}catch(SQLException e){
				//↑データベース処理に関する例外。
			e.printStackTrace();

		}

		return con;//Mysqlに接続出来たか情報を渡す。















			//指定された名前のクラスの定義が見つからなかった場合にスローされる






			//↑JDBCを使用した際に問題が発生するとSQLExceptionが投げられる。



//↑MySQLに接続できたか情報を渡す。
		}
}

