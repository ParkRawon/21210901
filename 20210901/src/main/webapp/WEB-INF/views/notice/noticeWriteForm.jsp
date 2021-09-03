<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>글 쓰 기</h1></div>
	<div>
		<form id="frm" name="frm" action="noticeWrite.do" method="post">
			<div>
				<table border="1">
					<tr>
						<td align="center" width="70">제목</td>
						<td width="250">
							<input type="text" id="title" name="title" size="37">
						</td>
						<td align="center" width="100">작성일</td>
						<td width="100">
							<input type="date" id="writeDate" name="writeDate" size="30">
						</td>
					<tr>
						<td align="center" width="70">내용</td>
						<td colspan="3">
							<textarea rows="10" cols="80" id="contents" name="contents"></textarea>
						</td>
					</tr>
				</table>
			</div><br/>
			<div>
				<input type="submit" value="저장">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;
				<input type="button" onclick="location.href = 'noticeList.do'" value="목록가기">
			</div>
			<input type="hidden" id="writer" name="writer" value="${id }">
		</form>
	</div>
</div>
</body>
</html>