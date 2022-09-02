<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lib.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.lib.dao.BookDao"%>
<%@page import="com.lib.entities.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

List<Book> books = (ArrayList)request.getAttribute("books");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book Quantity</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href = "css/Mystyle.css" rel = "stylesheet" type  = "text/css" />
</head>
<body>
<%@include file = "Adminnavbar.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script  src ="js/myjs.js" type="text/javascript"></script>

<main class = "d-flex align-items-center" style = "height: 90vh ">
	<div class = "container">
	<div class = "row">
	<div class = "col-md-8 offset-md-2">
		<div class ="card">
			<div class = "card-header">
			<p>Update Books Here</p>
			</div>
		<div class = "card-body">
		
		
			<form action = "AddQuantity" method = "POST">
			
			<div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Book Name </label>
   <div class="dropdown">

  
  <%
            if(books.size()>0)
            {
        %>
  <select name="book_id"  class="dropdown">
  <%
                for (Book book : books)
                {
            %>   
    <option value = <%=book.getBook_id()%> class="dropdown-item"  ><%=book.getBook_name() %></option>
   
    <%
                }
    %>
    
    
  </select>
  <% } else 
            {
                    out.println("<h2> No Books are available</h2>");
            }%>
</div>

  </div>


  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Quantity </label>
    <div class="col-sm-10">
      <input name ="book_quantity" type="author_name"  class="form-control" placeholder="Quantity">
    </div>
  </div>
  
  
  <div class="form-group row">
    <div class="col-sm-10">
    
   
      <button type="submit" class="btn btn-primary" >Add</button>
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