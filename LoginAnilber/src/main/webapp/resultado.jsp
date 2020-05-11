<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
HttpSession sesion= (HttpSession) request.getSession();
String Uvariablesesion = (String) sesion.getAttribute("usuarioo");

if(Uvariablesesion==null){
	
	response.sendRedirect("index.jsp");
	
}

%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Servelet" method="post">

<input type="submit" value="CERRAR" name="btncerrar">

</form>
<big><h1>BIENBENIDO</h1></big>
</body>
</html>