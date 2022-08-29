<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
		<link href="style/style.css" type="text/css" rel="stylesheet">
		<title>
			회원정보
		</title>
	</head>
	<body>
		<div id="container">
			<div id="inner-container">
				<div class="button">
					<%=session.getAttribute("name")%>님
					(<%=session.getAttribute("username")%>) 환영합니다!<br><br>
					<a href="server/logout.jsp">로그아웃</a>
				</div>
			</div>
		</div>
	</body>
</html>