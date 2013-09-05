<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<%@ page import="dto.UserList,java.util.List,dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>investMoney</title>
<link rel="STYLESHEET" href="style.css" type="text/css">
<script language="javascript" type="text/javascript">
	function logout() {
		//document.location.href = 'LogoutServlet';

		document.getElementById("investMoneyform").action = "LogoutServlet";
		document.getElementById("investMoneyform").submit();

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
			<b><big>Welcome to </big>
			</b>
		</div>
	</h1>
	<form id="investMoneyform" action="LoginServlet?param=invest"
		method="post">
		<div align="right">
			<input class="button" type="button" value="Logout"
				onclick="logout(); return false;">
		</div>
		<hr>
		<br>





		<table border="3" align="center" width="800" height="20">


			<tr>
				<td bgcolor="f2e3d2" class="investMoney"></td>
				<td bgcolor="f2e3d2" class="investMoney"></td>
				<td bgcolor="f2e3d2" class="investMoney"></td>
				<td bgcolor="f2e3d2" class="investMoney"></td>
				<td bgcolor="f2e3d2" class="investMoney"></td>
				<td align="center" bgcolor="f2e3d2" class="investMoney">
					<h3>Total Money invested</h3> <INPUT type="text" size="30"
					name="Total Money" readonly>
			</tr>


			<tr>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Name</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Location</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Amount</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Lending</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Check</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Date</b>
				</td>
			</tr>
			<%
          UserList borrowerData = (UserList)
        		session.getAttribute("BorrowerData");
           List borrowerNameList = borrowerData.getUsers();
           User user = null;
           for(int i=0;i< borrowerNameList.size();i++){
        	    user = (User)borrowerNameList.get(i);
        	   
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
				<td align="center" bgcolor="f2e3d2"  class="investMoney" ><%=user.getLocation() %></td>
				<td align="center" bgcolor="f2e3d2"  class="investMoney" ><%=user.getReq_amount()%></td>
				<td align="center" bgcolor="f2e3d2"  class="investMoney"><input name="Lending" type="textbox" value=""></td>
				<td align="center" bgcolor="f2e3d2"  class="investMoney" ><input name="Check" type="checkbox" value=""></td>
				</tr>	
						

			<%} %>			
			<tr valign="bottom">
				<td height="40" colspan="6" align="right"><input
					class="button" type="submit" value="Invest" /></td>

			</tr>
		</table>
</body>
</html>


