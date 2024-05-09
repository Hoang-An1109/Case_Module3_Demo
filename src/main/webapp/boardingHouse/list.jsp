<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Client Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="70" height="50" role="img" aria-label="Bootstrap">
                        <image xlink:href="image/logo.jpg" alt="Logo" width="70" height="50"></image>
                    </svg>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="boardingHouse" class="nav-link px-2 text-white">Boarding House</a></li>
                    <li><a href="client" class="nav-link px-2 text-white">Client</a></li>
                    <li><a href="contract" class="nav-link px-2 text-white">Contract</a></li>
                    <li><a href="staff" class="nav-link px-2 text-white">Staff</a></li>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <input type="search" class="form-control form-control-dark" placeholder="Search..."
                           aria-label="Search">
                </form>
            </div>
        </div>
    </header>

    <div class="container">
        <h1 class="text-center mt-5">Boarding House Management</h1>
        <div class="text-center mb-3">
            <a href="boardingHouse?action=create" class="btn btn-primary">Add New Boarding</a>
        </div>
        <div class="table-responsive">
            <caption><h2>List of Boarding House</h2></caption>
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Address</th>
                    <th>AREA</th>
                    <th>UNIT PRICE</th>
                    <th>STATUS</th>
                    <th>ACTION</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="boarding_House" items="${listBoardingHouse}">
                    <tr>
                        <td><c:out value="${boarding_House.id_nha}"/></td>
                        <td><c:out value="${boarding_House.dia_chi}"/></td>
                        <td><c:out value="${boarding_House.dien_tich}"/></td>
                        <td><c:out value="${boarding_House.don_gia}"/></td>
                        <td><c:out value="${boarding_House.trang_thai}"/></td>
                        <td>
                            <a href="boardingHouse?action=edit&id=${boarding_House.id_nha}" class="btn btn-info">Edit</a>
                            <a href="boardingHouse?action=delete&id=${boarding_House.id_nha}" class="btn btn-danger">Delete</a>
                            <a href="contract?action=create&id=${boarding_House.id_nha}" class="btn btn-info">Rent</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>