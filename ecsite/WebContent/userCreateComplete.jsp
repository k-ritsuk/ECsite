<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<div id = "header">
		<div id = "pr">
			</div>

	</div>
	<div id = "main">
		<div id = "top">

			<p>userCreateComplete</p>

		</div>
		<div>

			<h3>ユーザー登録が完了致しました。</h3>

		</div>
		<div>

			<a href='<s:url action="HomeAction" />'>ログインへ</a>

		</div>
	</div>

	<div id ="footer">
		<div id = "pr">
		</div>

	</div>

</body>
</html>