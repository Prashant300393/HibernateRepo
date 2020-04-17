<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H2>WELCOME TO STUDENT REGISTER PAGE!</H2>
	<form action="register" method="POST">
		<pre>
ID   : <input type="text" name="sid" />
NAME : <input type="text" name="sname" />
FEE  : <input type="text" name="sfee" />
 <input type="submit" value="Register" />
</pre>
	</form>
	${msg}
</body>
</html>