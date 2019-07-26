package com.internousdev.ecsite.util;
//ユーザー登録画面の作成
//登録した生年月日を作成

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate(){

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/ddHH:mm:ss");


		return simpleDateFormat.format(date);
	}

}