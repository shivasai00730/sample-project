<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Final Project </title>

<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>

</head>
<body>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark"
   style="background-color: tomato">
   <div>
    <a href="" class="navbar-brand"> User</a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/lists"
     class="nav-link">List Users</a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>

 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h3 class="text-center">List of Users</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Add Users</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Full Name</th>
      <th>User Name</th>
      <th>Password</th>
      <th>Type</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (User1 user1: users) {  -->
     <c:forEach var="user1" items="${listsUser1}">

      <tr>
       <td><c:out value="${user1.fullname}" /></td>
       <td><c:out value="${user1.username}" /></td>
       <td><c:out value="${user1.password}" /></td>
        <td><c:out value="${user1.utype}" /></td>

       <td><button> <a href="edit?id=<c:out value='${user1.id}' />">Edit</a></button>
        &nbsp;&nbsp;&nbsp;&nbsp;
         <button><a href="delete?id=<c:out value='${user1.id}' />">Delete</a></button></td> 

        <!--   <td><button (click)="updateUser1(user1.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteUser1(user1.id)" class="btn btn-warning">Delete</button></td> -->
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>