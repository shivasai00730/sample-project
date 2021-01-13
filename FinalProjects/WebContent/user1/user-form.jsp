<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Final Project</title>

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
    <a href="" class="navbar-brand"> Users
     </a>
   </div>

   <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/lists"
     class="nav-link">List of Users </a></li>
   </ul>

   <ul class="navbar-nav navbar-collapse justify-content-end">
    <li><a href="<%=request.getContextPath()%>/logout"
     class="nav-link">Logout</a></li>
   </ul>
  </nav>
 </header>
 <div class="container col-md-5">
  <div class="card">
   <div class="card-body">
    <c:if test="${users2 != null}">                  <!--  users2 is name of table -->
     <form action="update" method="post">
    </c:if>
    <c:if test="${users2 == null}">
     <form action="insert" method="post">
    </c:if>

    <caption>
     <h2>
      <c:if test="${users2 != null}">
               Edit Users
              </c:if>
      <c:if test="${users2 == null}">
               Add Users
              </c:if>
     </h2>
    </caption>

    <c:if test="${users2 != null}">
     <input type="hidden" name="id" value="<c:out value='${users2.id}' />" />
    </c:if>

    <fieldset class="form-group">
     <label>Full Name</label> <input type="text"
      value="<c:out value='${users2.fullname}' />" class="form-control"
      name="fullname" required="required">
    </fieldset>
    
    <fieldset class="form-group">
     <label>User Name</label> <input type="text"
      value="<c:out value='${users2.username}' />" class="form-control"
      name="username" required="required">
    </fieldset>
    
    <fieldset class="form-group">
     <label>Password</label> <input type="password"
      value="<c:out value='${users2.password}' />" class="form-control"
      name="password" required="required">
    </fieldset>
    <fieldset class="form-group">
     <label>Type</label> <input type="utype"
      value="<c:out value='${users2.utype}' />" class="form-control"
      name="utype" required="required">
    </fieldset>
    

    <button type="submit" class="btn btn-success">Save</button>
    </form>
   </div>
  </div>
 </div>

 <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>