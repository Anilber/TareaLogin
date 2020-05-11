<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<form action="Servelet" method="post" >
	<title>Form Login</title>
	<link rel="stylesheet" type="text/css" href="css/master.css">
</head>
<body>
<div class="login-box"> 
<img class="avatar"  src="img/usuarioImg.jpg" alt="logo de fazt">
<h1>Login Here</h1>


<!-- 	user name -->
<label for="username">Username</label>
<input type="text" placeholder="Enter Username" name="usuario">

<!-- 	password -->
<label for="password">Password</label>
<input type="password" placeholder="Enter Password" name="contrasenia">

<input type="submit" value="Log In">



<a href="#">Lost your password</a> <br>
<a href="crearUsuario.jsp">Don't have an account?</a>


</form>
</div>
</body>
</html>