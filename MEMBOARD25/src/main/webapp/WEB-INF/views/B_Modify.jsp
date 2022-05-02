<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 페이지</title>
</head>
<body>
<form action="bModify" method="post" enctype="multipart/form-data">
	<table>
	<caption>${modi.bNum}번 게시글 수정</caption>
		<tr>
			<th>작성자</th>
			<td><input type="hidden" name="bWriter" size="38" value="${modi.bWriter}"/></td>
		</tr>
			
		<tr>
			<th>제목</th>
			<td><input type="text" name="bTitle" size="38" placeholder="${modi.bTitle}"/></td>
		</tr>
			
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="40" name="bContent">${modi.bContent}</textarea></td>
		</tr>
		
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="bFile"></td>
		</tr>
		
			<tr>
				<td colspan="2">
					<input type="hidden" name="bNum" value="${modi.bNum}">
					<input type="submit" value="수정"/>
				</td>
			</tr>
	</table>
	</form>
</body>
</html>