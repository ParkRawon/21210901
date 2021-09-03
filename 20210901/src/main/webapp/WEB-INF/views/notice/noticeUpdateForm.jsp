<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 폼</title>
</head>

<body>
<div align="center">
<div><h1>글 수정</h1></div>
	<form id="frm" name="frm" action="noticeUpdate.do" method="post">
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
					<textarea rows="8" cols="72" id="contents" name="contents">${notice.contents }</textarea>
				</td>
			</tr>
		</table>	
	</div><br/>
			<input type="hidden" id="id" name="id" value="${notice.id }">
			<input type="submit" value="수정하기">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">	&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='noticeList.do'">목록가기</button>
		</form>
</div>
</body>
</html>