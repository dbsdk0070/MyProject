<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
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
</head>
<body>
<br>
<br>
<div id="container">
<h3>글 상세</h3>
	<form action="updateBoard.do" method="post">
		<input type="hidden" name="seq" value="${boardlistvo.board_num }">
	<table>
		<tr>
			<th width="70">Title</th>
			<td>
				<input type="text" name="title" size="30" readonly="readonly"
					value="${boardlistvo.board_title }">
			</td>
		</tr>
		<tr>
			<th>Comment</th>
			<td>
				<textarea readonly="readonly" name="content" rows="10" cols="40">${boardlistvo.board_comment }</textarea>
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
		<a href="boardlistUpdate.do?board_num=${boardlistvo.board_num }">Update</a>
	</p>
</div>
</body>
</html>
