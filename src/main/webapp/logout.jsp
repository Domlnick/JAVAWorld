<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 성공</title>
</head>

<body>
	<script type="text/javascript">
	
		sessionStorage.clear();
		
		alert(`${msg}`);
		location.href="http://localhost/javaWorld/login.html";
	</script>
</body>
</html>