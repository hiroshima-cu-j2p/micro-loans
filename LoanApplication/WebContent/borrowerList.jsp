<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<%@ page import="dto.UserList,java.util.List,dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">

<title>Insert title here</title>
<link rel="STYLESHEET" href="style.css" type="text/css">
<script language="javascript" type="text/javascript">
	function logout() {
		//document.location.href = 'LogoutServlet';

		document.getElementById("borrowerListform").action = "LogoutServlet";
		document.getElementById("borrowerListform").submit();

	}
</script>
</head>
<body bgcolor="#455765">
	<%
		String userName = (String) session.getAttribute("UserData");
		System.out.println("userName from session" + userName);
		if (userName == null) {
			response.sendRedirect("login.jsp");
			return;
		}
	%>

	<h1>
		<div class="title">
			<big><b>Welcome to</b> </big>
		</div>
	</h1>

	<form id="borrowerListform" action="LoginServlet" method="post">
		<div align="right">
			<input class="button" type="button" value="Logout" onclick="logout()">
		</div>

		<br>
		<hr>


		<table border="3" align="center" width="800" height="20">

			<tr>
				<th align="center" bgcolor="f2e3d2" class="form-title"><b>Name</b>
				</th>
				<th align="center" bgcolor="f2e3d2" class="form-title"><b>Location</b>
				</th>
			</tr>
			<%
          UserList borrowerList = (UserList)
        		session.getAttribute("BorrowerList");
           List borrowerNameList = borrowerList.getUsers();
           User user = null;
           for(int i=0;i< borrowerNameList.size();i++){
        	    user = (User)borrowerNameList.get(i);
        	   
        %>
			<tr>
				<!-- ><td valign="middle" align="center">YamadaA</td> -->

				<th align="center" bgcolor="f2e3d2" class="form-title"><a
					Href="http://localhost:8080/LoanApplication/LoginServlet?borrowerId=<%=user.getId()%>"><%=user.getUser_name() %></a>
				</th>
				<th align="center" bgcolor="f2e3d2" class="form-title"><%=user.getLocation() %></th>
			</tr>
			<%} %>
		</table>
	</form>
</body>
</html>