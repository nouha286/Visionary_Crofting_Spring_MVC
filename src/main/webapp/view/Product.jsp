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
    <title>Product</title>
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
<c:forEach items="${ListProduit}" var="produit">

        <div class="col  "  style="max-width: 300px;">
            <div class="shadow-lg p-3 mb-5 bg-body rounded">
            <div class="card">
                <img src="https://cdn.notonthehighstreet.com/system/product_images/images/001/330/799/original_birthday-cookie-gift-box.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h4 class="card-title" style="color: palevioletred">${produit.name}</h4>
                    <p class="card-text"> ${produit.description}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">${produit.unitaryPrice} DHs</li>
                    <li class="list-group-item">${produit.category}</li>
                </ul>

                <form class="d-flex m-2 " style="min-width: 150px;" method="POST" modelAttribute="passerCommande">
                    <input class="form-control me-2" type="number"  name="quantity" min="1" max="${produit.quantity}" placeholder="quantitée" >
                    <input type="hidden"  name="ref" value="${produit.productReference}">
                    <button type="submit" class="btn btn-outline-primary" >acheter</button>
                </form>
            </div>

            </div>
        </div>

</c:forEach>
   <h1>${success}</h1>

</div>
</div>

</body>
</html>
