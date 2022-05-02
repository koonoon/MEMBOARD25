<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
	table,tr,td,th{
	 	border : 1px solid;
	 	border-collapse : collapse;
	 	padding : 10px;
	}
</style>
</head>
<body>
<table>
	<caption>${view.bNum}번 게시글정보</caption>
	
	<tr>
	<th>작성자</th>
	<td>${view.bWriter}</td>
	</tr>
	
	<tr>
	<th>제목</th>
	<td>${view.bTitle}</td>
	</tr>
	
	<tr>
	<th>내용</th>
	<td>${view.bContent}</td>
	</tr>
	
	<tr>
	<th>조회수</th>
	<td>${view.bHit}</td>
	</tr>
	
	<tr>
	<th>첨부파일</th>
	<td><img src="resources/fileUpload/${view.bFileName}" width="200px">
	</td>
	</tr>
	
	<tr>
		<td colspan="2">
		<input type="button" value="수정" onclick="location.href='bModiForm?bNum=${view.bNum}'"/>
		<input type="button" value="삭제" onclick="location.href='bDelete?bNum=${view.bNum}'"/> </td>
	</tr>
	</table>
	
	<div id="commentArea"></div>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>

<script>

	// 페이지가 로딩 될 때 실행되는 함수
	$(document).ready(function(){
		var cbNum = ${view.bNum};
		
		$.ajax({
			type : "POST",
			url : "comment/cList",
			data : { "cbNum": cbNum },
			dataType : "json",
			success : function(list){
				// 실행되는 내용
				commentList(list);
			},
			error : function(){
				alert('댓글 리스트 불러오기 실패!');
			}
		});
		
		
	});
	
	
	// 댓글 목록 조회 함수
	function commentList(list){
		
		var output = "";
		
		// output변수에 계속 추가하겠다. ( += )
		output += "<table>";
		
		output += "<tr>";
		output += "<th>작성자</th>";
		output += "<th>내용</th>";
		output += "<th>작성일></th>";
		output += "<th>수정</th>";
		output += "<th>삭제</th>";
		output += "</tr>";
		
		// 댓글(list)의 갯수만큼 반복문 실행
		for(var i in list){
			output += "<tr>";
			output += "<td>" + list[i].cWriter + "</td>";
			output += "<td>" + list[i].cContents + "</td>";
			output += "<td>" + list[i].cDate + "</td>";
			output += "<td><button>수정</button></td>";
			output += "<td><button>삭제</button></td>";
			output += "</tr>";
		}
		output += "</table>";
		
		// div 영역 commentArea 선언
		var commentArea = document.getElementById('commentArea');

		// commentArea에 output 내용 넣기!
		commentArea.innerHTML = output;
	}
	
	
</script>


</html>