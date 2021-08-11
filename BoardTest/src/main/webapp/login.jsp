<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#container { width: 700px; margin: 0 auto; }
	h1 { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border : 1px solid black;
		margin : 0 auto;
	}
	th{
		width: 100px;
	}
</style>
<script>
	function loginCheck(){
		console.log("진입");
		
		if(document.loginInfo.user_id.value == ""){
			alert("아이디를 입력하세요");
			document.loginInfo.user_id.value = "";
			document.loginInfo.user_id.focus();
			return false;
		}
		if(document.loginInfo.user_pw.value == ""){
			alert("비밀번호를 입력하세요");
			document.loginInfo.user_id.value = "";
			document.loginInfo.user_pw.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<br>
<div id="container">
	<form action="login.do" method="POST" name="loginInfo" onsubmit="return loginCheck()">
	<table>
		<tr>
			<th>id</th>
			<td><input type="text" name="user_id"></td>
		</tr>
		<tr>
			<th style="width: 100px;">pw</th>
			<td><input type="text" name="user_pw"></td>
		</tr>
	</table>
	<p style="margin-left: 450px;"><input type="submit" value="로그인"></p>
	</form>
</div>


</body>
</html>