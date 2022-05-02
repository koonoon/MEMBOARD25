<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성 페이지</title>
</head>

<c:if test="${login.mId eq null}">
	<script>
		alert('로그인 이후 이용해주세요.');
		location.href="mLoginForm";
	</script>
</c:if>

<body>
	<form action="bWrite" method="POST" enctype="multipart/form-data">
	
		<table>
			<caption>게시글 등록</caption>
			
			<tr>
				<th>제목</th>
				<td><input type = "text" name="bTitle"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="40" name="bContent"></textarea></td>
			</tr>

			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="bFile"/></td>
			</tr>
			
			<c:if test="${login.mId ne null}">
			<tr>
				<td colspan="2">
				<input type="submit" value="등록"/> 
				<input type="reset" value="다시작성"/></td>
			</tr>
			</c:if>
		</table>
		<input type = "hidden" name="bWriter" value="${login.mId}">
	</form>
</body>
</html>