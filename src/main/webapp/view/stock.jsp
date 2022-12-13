<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>stock page</title>
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
<div class="text-center">

    <h1 style="color: aliceblue">Welcome to Home page!</h1>
    <form class="shadow-lg p-3  bg-body rounded container mt-5" style="max-width: 500px;" method="POST" modelAttribute="product">

        <div class="mb-3">
            <label  class="form-label">Name </label>
            <input name="name" type="text" class="form-control"  >
        </div>

        <div class="mb-3">
            <label  class="form-label">Categorie </label>
            <input name="category" type="text" class="form-control">
        </div>

        <div class="mb-3">
            <label  class="form-label">Description </label>
            <input name="description" type="text" class="form-control" >
        </div>

        <div class="mb-3">
            <label  class="form-label">Prix unitaire </label>
            <input name="unitaryPrice" type="text" class="form-control" >
        </div>
        <div class="mb-3">
            <label  class="form-label">quantité </label>
            <input name="quantity" type="number" class="form-control" >
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<h1>${success}</h1>

</body>
</html>
