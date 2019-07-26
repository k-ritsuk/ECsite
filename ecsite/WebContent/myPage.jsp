<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 購入履歴機能の作成 -->
<!-- 購入した商品の確認画面 -->

<%@taglib prefix="s" uri="/struts-tags" %><!-- ←↓jspどれもここの文を入力 -->
<!DOCTYPE html >
<html>
<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

				<meta http-equiv="Content-Style-Type"  content="text/css" />

				<meta http-equiv="Content-Script-Type" content="text/javaScript" />

				<meta http-equiv="imagetoolbar" content="no" />

				<meta name="description" content="" />

				<meta name="keywords" content="" />



				<style type="text/css" >
				<!-- ここまで -->
				body{

								margin:0;
								padding : 0;
								line-height : 1.6;
								letter-spacing : 1px;
								font_family:Verdana,Helvetica,sans-serif;
								font-size:12px;
								color:#333;
								background:#fff;

							}


							table{
								text-align:780px;
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

							#text-right{

								display: inline-block;
								text-align: right;

							}





				</style>
</head>
<body>
		<div id = "header">
				<div id = "pr">
				</div>
		</div>

		<div id = "main">
				<div id = "top">
						<p>MyPage</p>
				</div>
				<div>	<!-- ↓MyPageActionに購入履歴を格納しているmyPageListを使用する。 -->
						<s:if test="myPageList == null">

						<h3>ご購入はありません。</h3>

						</s:if>
						<s:elseif test="messagge == null">

						<h3>ご購入は以下になります。</h3>

						<table border="1">
						<tr>
								<th>商品名</th>
								<th>値段</th>
								<th>購入個数</th>
								<th>支払い方法</th>
								<th>購入日</th>

						</tr>

						<!-- ↓iteratorとは、ListやMapなどのコレクション要素を順番に処理する場合に使用。  -->
						<s:iterator value="myPageList">

								<tr><!-- この場合、itemNameから順番に処理していく -->
										<td><s:property value="itemName"/></td>
										<td><s:property value="totalPrice"/></td>
										<td><s:property value="totalCount"/></td>
										<td><s:property value="payment"/></td>
										<td><s:property value="insert_date"/></td>

								</tr>


						</s:iterator>
						</table>

								<!--↓ページを要求する。MyPageActionへ移る -->
						<s:form action="myPageAction">
							<input type="hidden" name="deleteFlg" value="1">
							<s:submit value="削除"/>

						</s:form>
					</s:elseif>
					<s:if test="message != null">

						<h3><s:property value="message"/> </h3>

					</s:if>
					<div id ="test-right">

						<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
						<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>

					</div>

				</div>
		</div>
		<div id = "footer">
				<div id ="pr">
				</div>

		</div>

</body>
</html>