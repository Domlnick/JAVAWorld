<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaWorld</title>
</head>
<body>
	<h2>로그인 창</h2> <br><br>
	<form action="{userId}" method="post">
	<input type="text" name="userId" placeholder="아이디를 입력해주세요." required><br>
	<input type="password" name="userPw" placeholder="비밀번호를 입력해주세요." required><br>
	<button type="submit" formmethod="post">로그인</button>
	</form>
	<br>아이디가 없으신가요?<button onclick="location.href='signUp.html'">회원가입</button>
	
</body>
</html>