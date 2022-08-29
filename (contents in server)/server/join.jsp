<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<%@ page import="database.DBOperation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		DBOperation dbOperation = new DBOperation();
		boolean result = dbOperation.insert(new Member(username, password, name));
		
		if(result){
	%>
			<script>
				alert('정상적으로 가입 되었습니다!');
				location.href = '../loginpage.html';
			</script>
	<%
		}
		else{
	%>
			<script>
				alert('회원가입에 실패하였습니다...');
				history.back();
			</script>
	<%
		}
	%>
	</body>
</html>