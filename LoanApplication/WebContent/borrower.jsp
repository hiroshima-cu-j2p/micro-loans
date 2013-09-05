<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<%@ page import="dto.UserList,dto.User,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Borrower List</title>
<link rel="STYLESHEET" href="style.css" type="text/css">
<script language="javascript" type="text/javascript">
	function logout() {
		//document.location.href = 'LogoutServlet';

		document.getElementById("borrowerform").action = "LogoutServlet";
		document.getElementById("borrowerform").submit();

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
	<%
         UserList investorBorrowerData = (UserList)
       		session.getAttribute("InvesterBorrowerData");
	     User borrower = (User)(investorBorrowerData.getUsers().get(0));
       	   
       %>
	<h1>
		<b><big>Borrower : <%=borrower.getUser_name()%></big> </b>
	</h1>
	<form id="borrowerform" action="LoginServlet" method="post">
		<div align="right">
			<input class="button" type="button" value="Logout"
				onclick="logout();return false;">
		</div>

		<hr>
		<br>

		<table border="3" align="center" width="800" height="20">





			<tr>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Name</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Location</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Amount
						Borrowing</b>
				</td>
				<td align="center" bgcolor="f2e3d2" class="form-title"><b>Amount
						Repayment</b>
				</td>
			</tr>

			<%
 		
			    List borrowerNameList = investorBorrowerData.getUsers();
			    User user = null;
			    for(int i=0;i< borrowerNameList.size();i++){
			 	    user = (User)borrowerNameList.get(i);
				%>
			<tr>
				<td bgcolor="f2e3d2" class="investMoney"><%=user.getInv_name()%>
				</td>
				<td bgcolor="f2e3d2" class="investMoney"><%=user.getLocation()%>
				</td>
				<td bgcolor="f2e3d2" class="investMoney"><%=user.getAmount_invested()%>
				</td>
				<td bgcolor="f2e3d2" class="investMoney"><input name="username"
					type="textbox" value="<%=user.getAmount_repaid()%>"></td>

			</tr>
			<%} %>

			<tr valign="bottom">
				<td height="40" colspan="6" align="right"><input class="button"
					type="submit" value="Invest" />
				</td>

			</tr>

		</table>

	</form>
</body>
</html>