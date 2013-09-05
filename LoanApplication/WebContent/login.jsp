<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Login Form</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body bgcolor=#455765>



	<form class="form-container" action="LoginServlet" method="post">
		<div class="form-title">
			<h2>Sign up</h2>
		</div>
		<div class="form-title">Name</div>
		<input class="form-field" name="username" type="textbox" value="" /><br />
		<div class="form-title">Password</div>
		<input class="form-field" type="password" name="password" value="" /><br />
		<div class="submit-container">
			<input class="submit-button" type="submit" value="Login" />
		</div>
	</form>
</body>
</html>



