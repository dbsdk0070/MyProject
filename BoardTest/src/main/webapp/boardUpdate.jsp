<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
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
function boardupdate(){
	document.boardUpdateInfo.submit();
}
</script>
</head>
<body>
<br>
<br>
<div id="container">
<h3>글 수정</h3>
	<form action="updateBoard.do" method="GET" name="boardUpdateInfo">
		<input type="button" value="수정" onclick="boardupdate(this.form)" style="margin-left: 505px;"/>
		<input type="hidden" name="board_num" value="${boardlistvo.board_num }">
	<table>
		<tr>
			<th width="70">Title</th>
			<td>
				<input type="text" name="board_title" size="30"
					value="${boardlistvo.board_title }">
			</td>
		</tr>
		<tr>
			<th>Comment</th>
			<td>
				<textarea name="board_comment" rows="10" cols="40">${boardlistvo.board_comment }</textarea>
			</td>
		</tr>
		<tr>
			<th width="70">Writer</th>
			<td>
				${boardlistvo.creator }
			</td>
		</tr>
	</table>
	</form>
	<p>
		<a href="getBoardList.do">List</a>
	</p>
</div>
</body>
</html>
