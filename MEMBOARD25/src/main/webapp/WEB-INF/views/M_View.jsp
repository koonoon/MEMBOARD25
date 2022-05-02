<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
<style>
	table,tr,td,th{
	 	border : 1px solid;
	 	border-collapse : collapse;
	 	padding : 10px;
	}
</style>
</head>
<body>
	<h3>로그인 아이디 : ${login.mId}</h3>
	<img src="resources/profile/${login.mProfileName}" width="200px"/>
	<table>
	<caption>${view.mId}님 회원정보</caption>
	<tr>
	<th>아이디</th>
	<td>${view.mId}</td>
	</tr>
	
	<tr>
	<th>비밀번호</th>
	<td>${view.mPw}</td>
	</tr>
	
	<tr>
	<th>이름</th>
	<td>${view.mName}</td>
	</tr>
	
	<tr>
	<th>생년월일</th>
	<td>${view.mBirth}</td>
	</tr>
	
	<tr>
	<th>성별</th>
	<td>${view.mGender}</td>
	</tr>
	
	<tr>
	<th>연락처</th>
	<td>${view.mPhone}</td>
	</tr>
	
	<tr>
	<th>주소</th>
	<td>${view.mAddr}</td>
	</tr>
	
	<tr>
	<th>이메일</th>
	<td>${view.mEmail}</td>
	</tr>
			
	<tr>
	<th>프로필사진</th>
	<td><img src="resources/profile/${view.mProfileName}" width="200px"/></td>
	</tr>
		
		
	<!-- 수정,삭제 버튼 -->
	<!-- 요구사항 : 현재 페이지의 회원정보와 로그인한 회원정보가 일치할 경우 수정, 삭제 버튼이 보인다 -->
	<!-- || : OR -->
	<!-- && : AND -->
	
	<c:if test="${view.mId eq login.mId || login.mId eq 'admin'}">	
	<tr>
		<td colspan="2">
		<input type="button" value="수정" onclick="location.href='mModiForm?mId=${view.mId}'"/>
		<input type="button" value="삭제" onclick="location.href='mDelete?mId=${view.mId}'"/> </td>
	</tr>
	</c:if>
	</table>
</body>



</html>