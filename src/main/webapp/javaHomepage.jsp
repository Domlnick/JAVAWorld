<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% String url = application.getContextPath() + "/"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="friendList">
	${sessionScope.sessionUserId}
	<h3>친구 리스트</h3>
	<table>
	<thead>
		<tr>
			<th>친구 아이디</th><th>친구 닉네임</th>
		</tr>
	</thead>
		<c:forEach var = "userFriends" items = "${jsonUserFId}" varStatus = "status">
			<tr>
				<td>${userFriends}</td>
				<td>${friendsId[status.index]}</td>
			</tr>
		</c:forEach>
	</table>
	
</div>

<div id="indexs">
<br><br>
<hr>
	<button type="submit" onclick="func_confirm()">로그아웃</button>
</div>
	
	<script type="text/javascript">
		sessionStorage.sessionUserId = "${sessionScope.sessionUserId}"
		
		
		function func_confirm () {
    		var result = confirm("로그아웃 하시겠습니까?");
    		if(result){
    			
    			alert("로그아웃 되셨습니다.\n로그인 페이지로 이동합니다.");
    			//sessionStorage.removeItem(sessionStorage.sessionUserId);
    			sessionStorage.clear();
    			location.href="http://localhost/javaWorld/login.html";
    			
    		} else {
    			
    		}

			
    	} 
		
		
	</script>
</body>
</html>


