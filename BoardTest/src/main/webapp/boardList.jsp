<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면 출력 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>게시판 목록</title>
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
<script>

$(document).ready(function(){
	    //최상단 체크박스 클릭
	    $("#total").click(function(){
	        //클릭되었으면
	        if($("#total").prop("checked")){
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=searchKey]").prop("checked",true);
	            //클릭이 안되있으면
	        }else{
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=searchKey]").prop("checked",false);
	        }
	    });
	});
	
$('input[name="searchKey"]').on('click', function(){   // 해당 name속성을 가진 checkbox에 클릭 이벤트 부여
	if ($('input[name="searchKey"]:checked').length == 4) { // 선택된 개수가 4개일 때
		$('#total').prop('checked', true);  // id가 total인 checkbox 선택
	} else {
		$('#total').prop('checked', false); // id가 total인 checkbox 선택해제
	}	
});

</script>
</head>
<body>
<br>
<br>
<h3>게시판 목록</h3>
<div style="margin-left: 540px;">
<a href="login.do">login </a>
<a href="signup.do">join</a>
<a href="logout.jsp">logout</a><span style="margin-left: 250px;">total : ${paging.total }</span>
</div>
<div id="container">
	<!-- 데이터 표시영역 -->
	<table>
		<tr>
			<th width="80">Type</th>
			<th width="50">No</th>
			<th width="300">Title</th>
		</tr>
		<c:forEach var="list" items="${viewAll }">
		<tr>
		<%-- 	<td class="center">${boardList.board_type }</td> --%>
			<%-- <td>
				<a href="getBoard.do?board_title=${boardList.board_title }">${boardList.board_title }</a>
			</td> --%>
			<td>${list.code_name }</td>
			<td>${list.board_num }</td>
			<%-- <td><a href='boardDetail.do?board_num=${board_num }'>${list.board_title }</a></td> --%>
			<td><a href='boardlistDetail.do?board_num=${list.board_num }'>${list.board_title }</a></td>
		</tr>	
		</c:forEach>
	</table>
		<!-- 페이징 -->
	<div class="center">
	<div class="pagination">
		<c:if test="${paging.startPage != 1 }">
			<a href="/getBoardList.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<a class="now" style="margin-left: 130px;">${p }</a>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/getBoardList.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/getBoardList.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}" >&gt;</a>
		</c:if>
			<a href="insertBoard.do" style="margin-left: 360px;">글쓰기</a>
	</div>
	</div>
<br>
<form id="selectbox" class="selectbox" method="GET" action="etBoardList.do" style="margin-left: 130px;">
<input type="checkbox" id="total" name="searchKey"/>
<label for="total">전체</label>
<input type="checkbox" value="a01" id="a01" name="searchKey"/>
<label for="a01">일반</label>
<input type="checkbox" value="a02" id="a02" name="searchKey"/>
<label for="a02">Q&A</label>
<input type="checkbox" value="a03" id="a03" name="searchKey"/>
<label for="a03">익명</label>
<input type="checkbox" value="a04" id="a04" name="searchKey"/>
<label for="a04">자유</label>
<input type="button" id="searchbutton" value="조회">
</form>
</div>
</body>
</html>