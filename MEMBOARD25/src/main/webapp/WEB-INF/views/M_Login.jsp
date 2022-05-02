<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="mLogin" method="POST">
	<table>
		<caption>로그인</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mId"/></td>		
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mPw"/></td>		
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인"/>
			</td>		
		</tr>
	</table>
	</form>
</body>
</html>