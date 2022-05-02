<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록(페이징)</title>
</head>
<body>

	<table>
		<caption>회원목록(페이징)</caption>
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>생년월일</th>
			<th>성별</th>
		</tr>
		
		<c:forEach var="mem" items="${mlist}">
		<tr>
			<td>${mem.mName}</td>
			<td><a href="mView?mId=${mem.mId}">${mem.mId}</a></td>
			<td>${mem.mBirth}</td>
			<td>${mem.mGender}</td>
			
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 처리 -->
	<!-- [이전]페이지로 에 대한 페이징 처리 -->
	<c:if test="${paging.page <= 1}">[이전] </c:if>
	<c:if test="${paging.page > 1}">
		<a href="mList?page=${paging.page-1}&limit=${paging.limit}">[이전] </a>
	</c:if>


	<!-- [페이지번호]에 대한 페이징 처리 -->
	<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}"
		step="1">
		<c:choose>

			<c:when test="${paging.page eq i}"> [${i}] </c:when>

			<c:otherwise>
				<a href="mList?page=${i}&limit=${paging.limit}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>


	<!-- [다음]페이지로 에 대한 페이징 처리 -->
	<c:if test="${paging.page >= paging.maxPage}"> [다음]</c:if>
	<c:if test="${paging.page < paging.maxPage}">
		<a href="mList?page=${paging.page+1}&limit=${paging.limit}"> [다음]</a>
	</c:if>
</body>
</html>