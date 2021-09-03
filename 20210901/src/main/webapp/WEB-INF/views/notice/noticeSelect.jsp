<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
	.table {
		 border-collapse: collapse;
		 border: 1px solid ;
	}
	.table tr{
		 border-collapse: collapse;
		 border: 1px solid ;
	}
	.table th {
		background: #e4f6df;
		color: #1d7500;
		border-collapse: collapse;
		border: 1px solid ;
	}
	.table td {
		border-collapse: collapse;
		border: 1px solid ;
	}
	
</style>
<script type="text/javascript">
	function NoticeEdit(str) {
		if(str == 'U') {
			frm.action = "noticeUpdateForm.do";
		}else {
			frm.action = "noticeDelete.do";
		}
		frm.submit();
	}
</script>
</head>
<body>
<div align="center">
	<div><h1>글 상세보기</h1></div>
	<div>
		<table class="table">
			<tr>
				<th width="70" align="center">순번</th>
				<td width="70" align="center">${notice.id }</td>
				<th width="120" align="center">작성자</th>
				<td width="120" align="center">${notice.name }</td>
				<th width="120" align="center">작성일</th>
				<td width="120" align="center">${notice.writeDate }</td>
			</tr>
			<tr>
				<th width="70" align="center">제목</th>
				<td colspan="3">${notice.title }</td>
				<th align="center">조회수</th>
				<td align="center">${notice.hit }</td>
			</tr>
			<tr>
				<th width="70" align="center">내용</th>
				<td colspan="5">
					<textarea rows="8" cols="72" readonly>${notice.contents }</textarea>
				</td>
			</tr>
		</table>	
	</div><br/>
	<div>	
	<c:if test ="${id eq notice.writer }">  <!-- 아이디와 작성자가 같으면 -->
		<button type="button" onclick="NoticeEdit('U')">글 수정</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="NoticeDelete('D')">글 삭제</button>&nbsp;&nbsp;&nbsp;			
	</c:if>
		<button type="button" onclick="location.href='noticeList.do'">목록보기</button>
	</div>	
</div>
	<div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="id" name="id" value="${notice.id }">
		</form>
	</div>
</body>
</html>