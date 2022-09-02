<%@page import="java.util.ArrayList"%>
<%@page import="com.lib.entities.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    List<Book> books = (ArrayList)request.getAttribute("books");
  
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin View Isssued Books</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href = "css/Mystyle.css" rel = "stylesheet" type  = "text/css" />
</head>
<body>
<%@include file = "Adminnavbar.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script  src ="js/myjs.js" type="text/javascript"></script>

<%
            if(books.size()>0)
            {
        %>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">BookId</th>
      <th scope="col">Book Name</th>
      <th scope="col">Student Name</th>
     
   
    </tr>
  </thead>
  <tbody>
    <tr>
      <%
                for (Book book : books)
                {
            %>    
                <tr>
                <th><%=book.getBook_id() %></th>
                <th><%=book.getBook_name() %></th>
                <th><%=book.getName()%></th>
               
                </tr> 
            <%    
                }
            %>
            
            
    
  </tbody>
</table>
<% } else 
            {
                    out.println("<h2> No Books are available</h2>");
            }%>
</body>
</html>