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
	.commWrite{
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
	
	<div class="commWrite">
		<textarea rows=5 cols=50 id=cContents></textarea>
		<button id="commBtn">댓글 입력</button>
	</div>
	
	<div id="commentArea"></div>
	
	<input type="hidden" name="bNum" id="bNum" value="${view.bNum}"/>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>

<script>

	// 페이지가 로딩 될 때 실행되는 함수
	$(document).ready(function(){
		// 댓글 목록을 불러오는 ajax
		var cbNum = $('#bNum').val();
		
		console.log('hidden으로 보낸 bNum : ' + cbNum)
		
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
	
	// 댓글 입력 ajax
	var loginId = '${login.mId}';
	
	// 버튼을 클릭 했을 경우 함수 실행
	$('#commBtn').click(function(){
		if(!loginId){
			alert('로그인 이후 사용해주세요!');
			location.href="mLoginForm";
		} else {
			var cWriter = loginId;
			
			// var cContents = document.getElementById("cContents").value; =
			var cContents = $('#cContents').val();
			var cbNum = $('#bNum').val();
			
			$.ajax({
				type : "POST",
				url : "comment/cWrite",
				data : {"cWriter" : cWriter,
						"cbNum" : cbNum,
						"cContents" : cContents
						},
				dataType : "json",
				success : function(list){
					commentList(list);
					$('#cContents').val("");
				},
				error : function(){
					alert('댓글 입력 실패!');
				}
			});
		}
	});
	
	
	
	
	// 댓글 목록 조회 함수
	function commentList(list){
		
		var cWrite11 = '${login.mId}';
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
			if(list[i].cWriter == cWrite11){
			output += "<td><button onclick='commentModify("+ list[i].cNum +", "+ list[i].cbNum +")'>수정</button></td>";
			}
			if(list[i].cWriter == cWrite11){
			output += "<td><button onclick='commentDelete("+ list[i].cNum +", "+ list[i].cbNum +")'>삭제</button></td>";}
			output += "</tr>";
		}
		output += "</table>";
		
		// div 영역 commentArea 선언
		var commentArea = document.getElementById('commentArea');

		// commentArea에 output 내용 넣기!
		commentArea.innerHTML = output;
	}
	
	
	
	
	function commentDelete(cNum, cbNum){
		
		var check = confirm('댓글을 삭제하시겠습니까?');
		
		
		
		console.log('check : ' + check);
		
		
		if(check){
			$.ajax({
				type : "POST",
				url : "comment/cDelete",
				data : {"cNum" : cNum, "cbNum" : cbNum},
				dataType : "json",
				success : function(list){
					commentList(list);			
				},
				error : function(){
					alert('댓글 삭제 실패');
				}
				});
		}
	} 
	function commentModify(cNum, cbNum){
	var check = confirm('댓글을 수정하시겠습니까?');
		
	var cContents = $('#cContents').val();
	
		if(check){
			$.ajax({
				type : "POST",
				url : "comment/cModify",
				data : {"cNum" : cNum, "cbNum" : cbNum, "cContents" : cContents},
				dataType : "json",
				success : function(list){
					commentList(list);			
				},
				error : function(){
					alert('댓글 수정 실패');
				}
				});
		}
		
	}
	
</script>


</html>