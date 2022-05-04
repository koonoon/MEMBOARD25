<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판 index</title>
</head>
<body>
	<button onclick="location.href='daum1'">다음지도API1</button>
	<button onclick="location.href='daum2'">다음지도API2</button>
	<button onclick="location.href='daum3'">다음지도API3</button>


	<h3>로그인 아이디 : ${login.mId}</h3>
	<img src="resources/profile/${login.mProfileName}" width="200px"/>

	<button onclick="location.href='mJoinForm'">회원가입</button>
	<button onclick="location.href='mList'">회원목록</button>
	<button onclick="location.href='mLoginForm'">로그인</button>
	<button onclick="location.href='mLogout'">로그아웃</button>
	
	<button onclick="login()">게시글 작성</button>
	<button onclick="location.href='bList'">게시글 목록</button>
	
	
</body>
<script>
	function login(){
		var mId = '${login.mId}';
		if(mId==''){
		alert('로그인 먼저 해주세요');
		location.href='mLoginForm';
		} else {
			location.href='bWriteForm';
		}
	}
</script>

</html>