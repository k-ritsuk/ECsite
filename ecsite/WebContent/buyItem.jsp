<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix = "s" uri = "/struts-tags" %><!-- ←↓jspどれもここの文を入力 -->
<!DOCTYPE html>      <!-- 商品名・値段・購入個数・購入方法を選択画面 -->
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<meta http-equiv="Content-Style-Type" content="text/css" />

	<meta http-equiv="Content-Script-Type" content="text/javascript"/>

	<meta http-equiv="imagetoolbar" content="no" />

	<meta name="description" content="" />

	<meta name="keywords" content="" />

	<title>BuyItem画面</title>

	<style type="text/css" >
		<!-- ここまで -->

		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;

		}

		table{
			text-align:center;
			margin:0 auto;
		}

		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#hesder{
			width:100%;
			height:80x;
			background-color:black;
		}

		#main{
			width:100%;
			height:500px;
			text-align:center;
		}

		#footer{
			width:100%;
			height: 80px;
			background-color:black;
			clean:both;
		}
	</style>
</head>
<body>

		<div id ="header">
				<div id = "pr">
				</div>

		</div>

		<div id = "main">
				<div id ="top">
						<p>BuyItem</p>
				</div>

		<div>				<!--↓ページを要求する。BuyItemActionへ移る -->
						<s:form action="BuyItemAciton">

						<table>
								<tr>

									<td>
										<span>商品名</span>
									</td>
									<td><!-- propertyとはキーと値がついになったデータを保存しているファイル -->
										<s:property value="session.buyItem_name"/><br>
									</td>
								</tr>

								<tr>

									<td>
										<span>値段</span>
									</td>
									<td><!-- propertyとはキーと値がついになったデータを保存しているファイル -->
										<s:property value="session.buyItem_price"/><span>円</span>
									</td>		<!-- ↑ボタン上に表示されるテキストのこと
												なので円の前に、送られてきた商品の値段が表示される -->

								</tr>
								<tr>
									<td>
										<span>購入個数</span>
									</td>
									<td><!-- ↓select name=""で""の中にフォ－ムを識別するための名前を指定
												今回は名前をcountとする-->
										<select name="count">
										<!-- プルダウンメニューの作成 ・ HTMLのformの所-->
												<option value="1" selected ="selected">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
											<!-- select要素内は option要素を使用する-->
										</select>
									</td>
								</tr>
								<tr>
									<td>
										<span>支払い方法</span>

									</td>
									<td>
									<!-- 購入方法を作成している -->
										<!--input type ラジオボタンを使用(選択肢から一つ選択するときに使う)  HTMLのformの所-->
										<input type="radio" name="pay" value="1" checked="checked">現金払い
																	<!--↑部品の初期値  -->	<!--↑選択されている状態  -->
															<!--↑name=""で指定した名前と同名のActionクラスのフィールドに
																	情報を渡す。 -->


										<input type="radio" name="pay" value="2" >クレジットカード
									</td>				<!--↑name=""で指定した名前と同名のActionクラスのフィールドに
																	情報を渡す。 -->

								</tr>
								<tr>

									<td><!-- 購入というボタンを作成。
														そしてBuyItemActionへ移動する。  -->
											<s:submit value="購入"/>
									</td>
								</tr>

						</table>
					</s:form>
						<div>

													<!-- リンクの挿入をしている HTMLのリンクの挿入の所-->
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
													<!--↑ページを要求する。GoHomeActionへ移る -->

													<!-- リンクの挿入をしている HTMLのリンクの挿入の所-->
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
												<!--↑ページを要求する。MyPageActionへ移る -->

						</div>

				</div>
		</div>

		<div id = "footer">
				<div id = "pr">
				</div>
		</div>

</body>
</html>