

<%@page import="com.lib.entities.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lib.entities.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<Book> books = (ArrayList)request.getAttribute("books");
    Student student = (Student)session.getAttribute("currentAdmin");
    
    String name = student.getName();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Issue</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href = "css/Mystyle.css" rel = "stylesheet" type  = "text/css" />
</head>
<body>
<%@include file = "StudentNavbar.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script src=
"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>

<div >
		<h3 > <%=name%>,you can issue books here..  </h3>
		<h3></h3>
		</div>
		
	
		
		

<%
            if(books.size()>0)
            {
        %>

<table class="table table-striped">

 <input type="text" name="search" id="search" class="form-control" onkeyup=""/>  
  <thead>
    <tr>
      <th scope="col">BookId</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Edition</th>
       <th scope="col">Quantity</th>
       <th scope="col">Click to Book</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <%
                for (Book book : books)
                {
            %>    
                <tr>
                <th ><%=book.getBook_id() %></th>
                <th><%=book.getBook_name() %></th>
                <th><%=book.getAuthor()%></th>
                <th><%=book.getEdition()%></th>
                <th > <%=book.getQuantity()%></th>
                <th>
                <form action="IssueBook" method = "POST">
               
               
  
  <div class="form-group">
  <input type="hidden" name='sid' value='<%=student.getSid()%>'>
  </div>
  <!-- 
  <label for="exampleInputPassword1">Enter your sid</label>
    <input name = "sid" type="id" class="form-control" id="exampleInputPassword1" placeholder="Student id">
  <label for="exampleInputPassword1">Enter book id</label>
    <input name = "book_id" type="id" class="form-control" id="exampleInputPassword1" placeholder="Enter Book Id">
  
  
   -->  
  
  
  <div class="form-group">
    <input type="hidden" name='book_id' value= <%=book.getBook_id() %>>
  </div>
  <div class="form-group">
    <input type="hidden" name='quantity' value= <%= book.getQuantity() %>>
  </div>
  
  <button type="submit" class="btn btn-primary">Book</button>
                
                </form>
                
                </th>
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
            
    <script>  
      $(document).ready(function(){  
           $('#search').keyup(function(){  
                search_table($(this).val());  
           });  
           function search_table(value){  
                $('#employee_table tr').each(function(){  
                     var found = 'false';  
                     $(this).each(function(){  
                          if($(this).text().toLowerCase().indexOf(value.toLowerCase()) >= 0)  
                          {  
                               found = 'true';  
                          }  
                     });  
                     if(found == 'true')  
                     {  
                          $(this).show();  
                     }  
                     else  
                     {  
                          $(this).hide();  
                     }  
                });  
           }  
      });  
 </script>  


</body>


</html>