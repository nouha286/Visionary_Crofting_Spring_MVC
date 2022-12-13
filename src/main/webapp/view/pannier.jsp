<%--
  Created by IntelliJ IDEA.
  User: Nouhaila ELAALAMI
  Date: 11/12/2022
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pannier</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body style="background: rgb(238,174,202);
background: linear-gradient(90deg, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);">
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a href="client" class="navbar-brand" >Visionary Crofting</a>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="row row-cols-1 row-cols-md-2 g-4 container mt-5 " >
    <c:forEach items="${commandItemList}" var="produit">

        <div class="row row-cols-1 row-cols-md-2 g-4">

            <div class="col">
                <div class="card">
                    <img src="https://th.bing.com/th/id/R.a1bca72872ec5ee406a1fde9f421139c?rik=8QuBXxMREbRcsw&pid=ImgRaw&r=0"
                         class="card-img-top" >
                    <div class="card-body">
                        <h5 class="card-title">${produit.name}</h5>
                        <p class="card-text">${produit.category}</p>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>


</div>
</div>

</body>
</html>
