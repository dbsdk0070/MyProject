<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	#container { width: 700px; margin: 0 auto; }
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border : 1px solid black;
		margin : 0 auto;
	}
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
<script>
function boardList(){
	document.boardListInfo.submit();
}
</script>
</head>
<body>
<div id="container">
	<h3>글등록</h3>
	<form action="boardinsert.do" method="POST" name="boardListInfo">
	<input type="button" value="작성" onclick="boardList(this.form)" style="margin-left: 525px;"/>
	<table>
		<tr>
			<th width="120">Type</th>
			<td>
			<select name="board_type" >
            <c:forEach var="list" items="${list}">
                <option value="${list.codeid}">${list.codename}</option>
            </c:forEach>
        	</select>
			</td>
		</tr>
		<tr>
			<th width="120">Title</th>
			<td>
				<input type="text" name="board_title">
			</td>
		</tr>
		<tr>
			<th width="120">Comment</th>
			<td>
				<textarea name="board_comment" rows="10" cols="40"></textarea>
			</td>
		</tr>
		<tr>
			<th width="120">Writer</th>
			<td>
				<input type="text" name="creator" readonly="readonly" value="<%=session.getAttribute("user_id")%>">
				<%-- <input type="hidden" name="creator" value="<%=session.getAttribute("user_id")%>"/> --%>
			</td>
		</tr>
	</table>
	</form>
	
	<p><a href="getBoardList.do">List</a></p>
	
</div>

</body>
</html>