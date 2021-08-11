<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면 출력 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<style>
	#container { width: 700px; margin: 0 auto; }
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border : 1px solid black;
		margin : 0 auto;
	}
	span{
		margin-left: 130px;
	}
	p{
		margin-left: 400px;
	}
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>
<br>
<span>
<a href="login.do">login</a>
<a href="signup.do">join</a>
<a href="logout.jsp">logout</a>
</span>
<p><a href="getBoardList.do">게시글 목록</a></p>

<%-- 
<div id="container">
	<!-- 데이터 표시영역 -->
	<table>
		<tr>
			<th width="80">Type</th>
			<th width="50">No</th>
			<th width="300">Title</th>
		</tr>
	<c:if test="">
		<c:forEach var="board" items="">
		<tr>
			<td class="center"></td>
			<td>
				<a href="getBoard.do?seq="></a>
			</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>	
		</c:forEach>
	</c:if>
	<c:if test="">
		<tr>
			<td colspan="5" class="center">데이터가 없습니다</td>
		</tr>
	</c:if>
		
	</table>
	<p><a href="insertBoard.do">글 목록</a></p>
</div>

 --%>

</body>
</html>