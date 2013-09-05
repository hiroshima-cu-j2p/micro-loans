<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
    <%@ page import="dto.UserList,java.util.List,dto.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>investHistory</title>
<link rel="STYLESHEET" href="style.css" type="text/css">
<script language="javascript" type="text/javascript">
	function logout() {
		//document.location.href = 'LogoutServlet';

		document.getElementById("investHistoryform").action = "LogoutServlet";
		document.getElementById("investHistoryform").submit();

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
		<b><div class="title">
				<big>Welcome to </big>
			</div> </b>
	</h1>
	<form id="investHistoryform" action="LoginServlet" method="post">
		<div align="right">
			<div class="submit-container">
				<input type="button" value="Logout" onclick="logout();return false;">
			</div>
		</div>
		<hr>
		<br>





		<table border="3" align="center" width="800" height="20">



			<tr>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Name</b>
				</tb>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Location</b>
				</tb>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Amount Repaid</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Last invest date</b>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Last repaid date</b>
				</td>
			</tr>
				
		<%
          UserList investorHistoryData = (UserList)
        		session.getAttribute("investorHistoryData");
           List investorNameList = investorHistoryData.getUsers();
           User user = null;
           for(int i=0;i< investorNameList.size();i++){
        	    user = (User)investorNameList.get(i);
        	   
        %>
			<tr>
				<td align="center" bgcolor="f2e3d2"  class="investMoney" >
					<% if(user.getFirst_name()!=null){%>
						<%= user.getFirst_name()%>
					<% } %>
					<% if(user.getMiddle_name()!=null){%>
						<%= user.getMiddle_name()%>
					<% } %>
					<% if(user.getFamily_name()!=null){%>
						<%= user.getFamily_name()%>
					<% } %>
				</td>
				<td align="center" bgcolor="f2e3d2"  class="investHistory" ><%=user.getLocation() %></td>
				<td align="center" bgcolor="f2e3d2"  class="investHistory" ><%=user.getAmount_invested() %></td>
				<td align="center" bgcolor="f2e3d2"  class="investHistory" ><%=user.getAmount_repaid() %></td>
				<td align="center" bgcolor="f2e3d2"  class="investHistory" ><%=user.getInvest_date() %></td>
				<td align="center" bgcolor="f2e3d2"  class="investHistory" ><%=user.getRepaid_date() %></td>
				</tr>	
						

			<%} %>			

			


		</table>



	</form>
</body>
</html>