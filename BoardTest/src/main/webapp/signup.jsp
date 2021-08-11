<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
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
	td{
		width: 250px;}
</style>
<script>
	var idCheck = false;
	
	//회원가입 예외처리 ----------------------------------------
	function signup_check(){
	    if(document.signUpInfo.user_id.value.trim() == ""){
			alert("아이디를 입력하세요.");
			document.signUpInfo.user_id.value="";
			document.signUpInfo.user_id.focus();
				return false;
		}
		
	    if($("input[name ='check_id']").val()== "n"){
	         alert("아이디 중복확인을 해주세요");
	            return false;
	      }
		
		if(document.signUpInfo.user_pw.value.trim() == ""){
			alert("비밀번호를 입력하세요.");
			document.signUpInfo.user_pw.value="";
				return false;
		}
		
		if(document.signUpInfo.user_name.value.trim() == ""){
			alert("이름을 입력하세요.");
			document.signUpInfo.user_name.value="";
			document.signUpInfo.user_name.focus();
				return false;
		}
		
		if(document.signUpInfo.user_phone.value.trim() == ""){
			alert("휴대폰 번호를 입력하세요.");
			document.signUpInfo.user_phone.value="";
			document.signUpInfo.user_phone.focus();
				return false;	
		}
		
		if(document.signUpInfo.user_phone2.value.trim() == ""){
			alert("휴대폰 번호를 입력하세요.");
			document.signUpInfo.user_phone2.value="";
			document.signUpInfo.user_phone2.focus();
				return false;	
		}
		
		if(document.signUpInfo.user_phone3.value.trim() == ""){
			alert("휴대폰 번호를 입력하세요.");
			document.signUpInfo.user_phone3.value="";
			document.signUpInfo.user_phone3.focus();
				return false;	
		}
			document.signUpInfo.submit();
	}

	//아이디 중복확인 ------------------------------------------
	//ajax 통신
	function user_idCheck(){
		if(document.signUpInfo.user_id.value.trim() == ""){
			alert("아이디를 입력하세요.");
			document.signUpInfo.user_id.value="";
			document.signUpInfo.user_id.focus();
				return false;
		}
	   var user_id = user_id
	   
	   $.ajax({
		   type : "POST",
			url : "idCheck.do",
			data: { "user_id" : $('#user_id').val() },
			success : function(data) {
			console.log(data);
			
			if(data == 1){
				idCheck = true;
				alert("이미 사용중인 아이디입니다.");
				document.signUpInfo.user_id.value="";
				document.signUpInfo.user_id.focus();
				
			} else if(data == 0){
				idCheck = false;
				$("#check_id").attr("value","y");
				alert("사용 가능한 아이디입니다.");
			}
		},
				error : function() {
				alert("응답 실패");
			} 
	  }); 
	};
	
	
	 <%-- 비밀번호 예외처리 --%>
      $(document).ready(function() {
         
         $("#user_pw").blur(function() {
            var user_pw = $("#user_pw").val();
            var pw_pattern = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{6,12}$/;
            
            if (!pw_pattern.test(user_pw)) {
               alert("비밀번호는 숫자, 알파벳, 특수문자 포함 6~12자로 입력해주세요");
               $("#password_text1").css("color","red"); */
               document.signUpInfo.user_pw.value = "";
               return false;
            } else {
               $("#password_text1").text("");
            }
         });
      });
    
   <%-- 비밀번호 체크 --%>
      $(document).ready(function(){
         $("#user_pw_check").blur(function(){
            var user_pw = $("#user_pw").val();
            var user_pw_check = $("#user_pw_check").val();
            
            if(user_pw != user_pw_check){
               alert("비밀번호가 일치하지 않습니다.");
               document.signUpInfo.user_pw_check.value = "";
            } else {
               $("#user_pw_check").text("");
            }
         });
      });

</script>
</head>
<body>
<div id="container">
	<form action="signup.do" method="post" name="signUpInfo">
	<p style="margin-left: 175px; margin-bottom: 5px;"><a href="boardList.do">List</a></p>
	<table>
		<tr>
			<th>id</th>
         <td><input type="text" name="user_id" id="user_id">
         <input type="button" name="idcheck" class="id_check" onclick="user_idCheck()" value="중복확인">
         <input type="hidden" name="check_id" id="check_id" value="n">
			</td>
		</tr>
		<tr>
			<th>pw</th>
         <td><input type="password" name="user_pw" id="user_pw">
         <span id="password_text1" class="check_color"></span>

		</tr>
		<tr>
			<th>pw check</th>
         <td><input type="password" name="user_pw_check" id="user_pw_check">
         <span id="password_text2" class="check_color"></span>

		</tr>
		<tr>
			<th>name</th>
			<td><input type="text" name="user_name"></td>
		</tr>
		<tr>
			<th>phone</th>
			<td>
			<select name="user_phone" id="user_phone">
			<c:forEach var="phonelist" items="${phonelist}">
                <option value="${phonelist.codename}">${phonelist.codename}</option>
            </c:forEach>
			</select>
			<input type="text" name="user_phone2" style="width: 41px;"/>-
			<input type="text" name="user_phone3" style="width: 41px;">
			</td>
		</tr>
		<tr>
			<th>postNo</th>
			<td><input type="text" name="user_addr1" id="user_addr1" maxlength='8'></td>	<!-- postNo는 텍스트 길이 안맞아서 '-' 없이 insert -->
		</tr>
		<tr>
			<th>address</th>
			<td><input type="text" name="user_addr2"></td>
		</tr>
		<tr>
			<th>company</th>
			<td><input type="text" name="user_company"></td>
		</tr>
	</table>
	<p style="margin-left: 500px;"><input type="button"value="join" onclick="signup_check(this.form)"></p>
	</form>
</div>
</body>
</html>