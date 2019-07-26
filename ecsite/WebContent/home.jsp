<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <!-- ログイン機能作成 -->
    <!-- 最初の画面 -->

<%@taglib prefix = "s" uri="/struts-tags" %><!-- ←↓jspどれもここの文を入力 -->
<!DOCTYPE html>
<html>							<!-- ログイン機能の作成 -->
<head>

						<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

						<meta http-equiv="Content-Style-Type" content="text/css" />

						<meta http-equiv="Content-Script-Type" content="text/javascript"/>

						<meta http-equiv="imagetoolbar" content="no" />

						<meta name="description" content="" />

						<meta name="keywords" content="" />

						<title>home画面</title>

					<style type="text/css">
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

			#header{
			width:100%;
			height: 80px;
			background-color:black;

			}

			#main{
			width:100%;
			height:500px;
			text-align:center;

			}

			#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;

			}

			#text-center{
			display: inline-block;
			text-align: center;


			}

</style>

</head>
<body>


	<div id = "header">
			<div id ="pr">
			</div>

	</div>
	<div id = "main">
			<div id ="top">
					<p>Home</p>
			</div>
				<!-- ↓中央に寄せる -->
			<div id="text-center"><!-- ↓ページ要求するHomeActionに移る -->
					<s:form action="HomeAction">

						<s:submit value="商品購入"/>

				</s:form>

					<!-- ↓サーバー(Tomcat)からとってくる -->
					<s:if test = "#session.login_user_id !=null">

								<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
					</s:if>										<!-- ↑ページ要求する-->

		<div id = "footer">
				<div id = "pr">
				</div>

		</div>

		</div>
</div>




</body>
</html>