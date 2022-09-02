<%@page import="org.apache.tomcat.jdbc.pool.interceptor.AbstractCreateStatementInterceptor"%>
<%@page import="com.lib.helper.ConnectionProvider"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.lib.entities.BookIssue"%>
<%@page import="com.lib.entities.Student"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
   
    List<BookIssue> books = (ArrayList)request.getAttribute("books");

    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Issued By Student</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href = "css/Mystyle.css" rel = "stylesheet" type  = "text/css" />
</head>
<body>
<%@include file = "StudentNavbar.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script  src ="js/myjs.js" type="text/javascript"></script>

<input style="float: right" type="text" id="myInput" onkeyup="myFunction()" placeholder="Search" >
<%
            if(books.size()>0)
            {
        %>

<table id="myTable" class="table table-striped">
<thead>
    <tr>
      <th scope="col">BookId</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Edition</th>
       <th scope="col">Issue Date</th>
       <th scope="col">Return Date</th>
       <th>Renew Book</th>
       <th>Return Book</th>
    </tr>
     </thead>
     <tbody>
    
     <tr>
    <%
                for (BookIssue book : books)
                {
            %> 
            <tr>
                <th ><%=book.getBook_id() %></th>
                <th><%=book.getBook_name() %></th>
                <th><%=book.getAuthor()%></th>
                <th><%=book.getEdition()%></th>
                <th><%=book.getBook_issue() %></th>
                <th><%=book.getBook_return() %></th>
                 <th>
                <form action="RenewBook" method = "POST">
               
               
  
  <div class="form-group">
  <input type="hidden" name='book_id' value='<%=book.getBook_id() %>'>
  </div>
  
   
  <div class="form-group">
    <input type="hidden" name='book_return' value= '<%=book.getBook_return() %>' >
  </div>
 
  
  <button type="submit" class="btn btn-primary">Renew</button>
                
                </form>
                
                </th>
                
                 <th>
                <form action="ReturnBook" method = "POST">
               
               
  
  <div class="form-group">
  <input type="hidden" name='book_id' value='<%=book.getBook_id() %>'>
  </div>
  
  <button type="submit" class="btn btn-primary">Return Book</button>
                
                </form>
                
                </th>
                
                 <%    
                }
            %>
   </tbody>         
                

                
             




</table>
<% } else 
            {
                    out.println("<h2> No Books are available</h2>");
            }%>


<script type="text/javascript">
function myFunction() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

     var searchColumn=[0,1,3,4]

    for (i = 0; i < tr.length; i++) {

      if($(tr[i]).parent().attr('class')=='head')
        {
            continue;
         }

    var found = false;
      for(var k=0;k<searchColumn.length;k++){

        td = tr[i].getElementsByTagName("td")[searchColumn[k]];

        if (td) {
          if (td.innerHTML.toUpperCase().indexOf(filter) > -1 ) {
            found=true;    
          } 
        }
    }
    if(found==true)  {
        tr[i].style.display = "";
    } 
    else{
        tr[i].style.display = "none";
    }
}
}


</script>
</body>
</html>