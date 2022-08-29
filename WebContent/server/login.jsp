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
		
		DBOperation dbOperation = new DBOperation();
		Member user = (Member) dbOperation.select(username, new Member());
		
		if(user == null){
	%>
			<script>
				alert('존재하지 않는 아이디입니다.');
				history.back();
			</script>
	<%
		}
		else if(!user.getPassword().equals(password)){
	%>
			<script>
				alert('비밀번호가 일치하지 않습니다.');
				history.back();
			</script>
	<%
		}
		else{
			session.setAttribute("username", user.getUsername());
			session.setAttribute("name", user.getName());
	%>
			<script>
				location.href = '../infopage.jsp';
			</script>
	<%
		}
	%>
	</body>
</html>