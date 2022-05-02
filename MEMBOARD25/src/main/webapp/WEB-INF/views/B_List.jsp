<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<table>
		<caption>게시글 목록</caption>
		<tr>
			<th>게시판번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="bor" items="${blist}">
		<tr>
			<td>${bor.bNum}</td>
			<td><a href="bView?bNum=${bor.bNum}">${bor.bTitle}</a></td>
			<td>${bor.bWriter}</td>
			<td>${bor.bDate}</td>
			<td>${bor.bHit}</td>
			
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 처리 -->
	<!-- [이전]페이지로 에 대한 페이징 처리 -->
	<c:if test="${paging.page <= 1}">[이전] </c:if>
	<c:if test="${paging.page > 1}">
		<a href="bList?page=${paging.page-1}&limit=${paging.limit}">[이전] </a>
	</c:if>


	<!-- [페이지번호]에 대한 페이징 처리 -->
	<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}"
		step="1">
		<c:choose>

			<c:when test="${paging.page eq i}"> [${i}] </c:when>

			<c:otherwise>
				<a href="bList?page=${i}&limit=${paging.limit}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>


	<!-- [다음]페이지로 에 대한 페이징 처리 -->
	<c:if test="${paging.page >= paging.maxPage}"> [다음]</c:if>
	<c:if test="${paging.page < paging.maxPage}">
		<a href="bList?page=${paging.page+1}&limit=${paging.limit}"> [다음]</a>
	</c:if>
	
</body>





</html>