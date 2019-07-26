<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
									<!-- ユーザーの登録機能の作成 -->

									<!-- 登録内容の確認画面 -->
<%@ taglib prefix = "s"  uri = "/struts-tags"%><!-- ←↓jspどれもここの文を入力 -->
<!DOCTYPE html>
<html>
<head>

				<meta http-equiv="Content-Type" content="text/html; charset=urf-8"/>

				<meta http-equiv="Content-Style-Type" content="text/css" />

				<meta http-equiv="Content-Script-Type" content="text/javascript" />

				<meta http-equiv="imagetoolbar" content="no" />

				<meta name="description" content="" />

				<meta name="keywords" content="" />

				<title>UserCreateConfirm画面</title>

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
					margin:0px auto;
				}

				#top{
					width:780px;
					margin:30px auto;
					border:1px solid #333;
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
					clean: both;
				}

				</style>
</head>
<body>

		<div id = "header">
				<div id ="pr">
				</div>

		</div>

		<div id = "main">
				<div id = "top">
						<p>UserCreateConfirm</p>

				</div>
						<h3>登録内容は以下でよろしいですか。</h3>
						<table>
									<!--↓ページを要求する。UserCreateCompleteActionへ移る -->
									<s:form action="UserCreateCompleteAction">
									<!--s:formで囲まれたタグに入力された情報が、action＝""で指定したActionクラスへ渡される。-->

										<tr id="box">
											<td>
													<label>ログインID:</label>
											</td>
											<td>	<!-- 前画面で入力されたloginuserIdがここに入力される -->
													<s:property value="lognUserId" escape="false" />
											</td>
										</tr>
										<tr id="box">

											<td>
													<label>ログインPASS:</label>

											</td>

											<td>	<!-- 前画面で入力されたloginPasswordがここに入力される -->
													<s:property value="loginPassword" escape="false" />

											</td>
										</tr>
										<tr id = "box">

											<td>
													<label>ユーザー名:</label>
											</td>
											<td>	<!-- 前画面で入力されたuserNameがここに入力される -->
													<s:property value="userName" escape="false" />
											</td>
										</tr>


									</s:form>

						</table>
				<div>

				</div>
		</div>
		<div id ="footer">
				<div id="pr">
				</div>

		</div>








</body>
</html>