<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
											<!-- 商品購入機能の作成 -->
											<!-- 購入手続き完了画面 -->
<%@ taglib prefix = "s" uri="/struts-tags" %><!-- ←↓jspどれもここの文を入力 -->
<!DOCTYPE html>
<html>
<head>
					<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

					<meta http-equiv="Content-Style-Type" content="text/css" />

					<meta http-equiv="Content-Script-Type" content="text/javascript" />

					<meta http-equiv="imagetoolbar" content="no" />

					<meta name="description" content="" />

					<meta name="keywords" content="" />

					<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
					<title>BuyItemConfirm画面</title>

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

					<script type="text/javascript">
					function submitAction(url){
						//↓formに設定して送信
						$('form').attr('action',url);
						$('form').submit();
						//↑最終的に次に行く場所が２か所あるからJavaSriptを使ってやる。

					}

					</script>



</head>
<body>
			<div id = "header">
					<div id = "pr">
					</div>
			</div>
			<div id = "main">
					<div id="pr">
							<p>BuyItem</p>

					</div>
					<div>
							<!-- ↓上のformはここのことを言っている。 -->
							<s:form>
						<tr>
								<td>商品名</td>
								<td><s:property value="session.buyItem_name"/></td>
						</tr>
						<tr>													<!-- ↓BuyItemActionで表示しているtotal_price -->
								<td>値段</td>									<!-- ↓買った数の合計値段 -->
								<td><s:property value="session.total_price"/><span>円</span></td>
						</tr>
						<tr>

								<td>購入個数</td>
								<td><s:property value="session.buyItem_price"/><span>個</span></td>


						</tr>
						<tr>
								<td>支払い方法</td>
								<td><s:property value="session.pay"/></td>
						</tr>
						<tr>

								<td><br></td>
						</tr>
							<tr>
								<td>														<!-- ↓ここが上の(url) -->
									<input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>

								<td>
									<input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
							</tr>



							</s:form>
					</div>
					<div>
															<!--↓ページを要求する。GoHomeActionへ移る -->
							<p>前画面に戻るには<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
							<p>マイページは<a href='<s:url action = "MyPageAction"/>'>こちら</a></p>
					 									<!--↑ページを要求する。MyPageActionへ移る -->
					 						<!-- ↑リンクの挿入をしている HTMLのリンクの挿入の所-->

					</div>


			</div>
			<div id = "footer"></div>
				<div id = "pr">

				</div>



</body>
</html>