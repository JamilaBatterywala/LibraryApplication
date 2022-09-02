<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href = "css/Mystyle.css" rel = "stylesheet" type  = "text/css" />
</head>
<body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script  src ="js/myjs.js" type="text/javascript"></script>

<main class = "d-flex align-items-center" style = "height: 100vh ">
	<div class = "container">
	<div class = "row">
	<div class = "col-md-8 offset-md-2">
		<div class ="card">
			<div class = "card-header">
			<p>Login Here</p>
			</div>
		<div class = "card-body">
			<form action = "LoginServlet" method = "POST">
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Membership ID</label>
    <div class="col-sm-10">
      <input name = "id" type="id" class="form-control" id="inputEmail3" placeholder="ID">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input name = "password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
 
 
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary" >Sign in</button>
    </div>
   
    <div class="col-sm-60">
      <a href="Register_student.jsp" type="submit" class="btn btn-primary">Sign Up 	</a>
    </div>
  </div>
</form>
			</div>
		
		
		
		</div>
	
	
	
	 </div>
	</div>
	
	
	
	</div>




</main>


</body>
</html>