<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    									<!-- 商品購入機能の作成 -->
    									<!-- 購入手続き完了画面 -->


<%@taglib prefix="s" uri="/struts-tags" %><!-- ←↓jspどれもここの文を入力 -->
<!DOCTYPE html>
<html>
<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

			<meta http-equiv="Content-Style-Type" content="text/css" />

			<meta http-equiv="Content-Script-Type" content="text/javascript" />

			<meta http-equiv="imagetoolbar" content="no" />

			<meta name = "description" content="" />

			<meta name ="jeywords" content = "" />


			<title>BuyItemComplete画面</title>


			<style type="text/css">
			<!-- ここまで -->
			body{

								margin: 0;
								padding : 0;
								line-height : 1.6;
								letter-spacing : 1px;
								font_family:Verdana,Helvetica,sans-serif;
								font-size:12px;
								color:#333;
								background:#fff;

							}


							table{
								text-align:center;
								margin:0 auto ;
								}

							#top{

								margin:30px auto;
								border:1px solid #333;
								width: 780px;
								}
							#header{

								width: 100%;
								height: 80px;
								background-color: black;
							}

							#main{

								width: 100%;
								height: 500px;
								text-align: center;
							}

							#footer{

								width: 100%;
								height: 80px;
								background-color: black;
								clear:both;
							}






					</style>
</head>
<body>

			<div id = "header" >
					<div id ="pr">

					</div>

			</div>

			<div id = "main">
					<div id = "top">
							<p>BuyItemComplete</p>


					</div>
					<div>
							<p>購入手続きが完了致しました。</p>


							<div>					<!--↓ページを要求する。MyPageActionへ移る -->
						<!-- リンクの挿入 --><a href='<s:url action = "MyPageAction" />'>
									マイページ</a><span>から購入履歴が確認が可能です。</span>


									<p>Homeへ戻る場合は
						<!-- リンクの挿入 --><a href='<s:url action = "GoHomeAction" />'>
									こちら</a></p>						<!--↑ページを要求する。GoHomeActionへ移る -->

							</div>
					</div>

			</div>
			<div id = "footer">
					<div id = "pr">
					</div>

			</div>

</body>
</html>