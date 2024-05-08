<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contract Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">About</a></li>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <input type="search" class="form-control form-control-dark" placeholder="Search..."
                           aria-label="Search">
                </form>

                <div class="text-end">
                    <button type="button" class="btn btn-outline-light me-2">Login</button>
                    <button type="button" class="btn btn-warning">Sign-up</button>
                </div>
            </div>
        </div>
    </header>

    <div class="container">
        <h1 class="text-center mt-5">Contract Management</h1>
        <div class="text-center mb-3">
            <a href="contract?action=create" class="btn btn-primary">Add New Contract</a>
        </div>
        <div class="table-responsive">
            <caption><h2>List of Contracts</h2></caption>
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Boarding House</th>
                    <th>Client</th>
                    <th>Staff</th>
                    <th>Contract Creation Cate</th>
                    <th>Price</th>
                    <th>Deposit Money</th>
                    <th>Condition</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contract" items="${listContract}">
                    <tr>
                        <td><c:out value="${contract.id_hop_dong}"/></td>
                        <td><c:out value="${contract.boardingHouse.getId_nha()}"/></td>
                        <td><c:out value="${contract.client.id_kh}"/></td>
                        <td><c:out value="${contract.staff.id_nv}"/></td>
                        <td><c:out value="${contract.ngay_hd}"/></td>
                        <td><c:out value="${contract.gia_thue}"/></td>
                        <td><c:out value="${contract.tien_dat_coc}"/></td>
                        <td><c:out value="${contract.dieu_khoan}"/></td>
                        <td>
                            <a href="contract?action=edit&id=${contract.id_hop_dong}" class="btn btn-info">Edit</a>
                            <a href="contract?action=delete&id=${contract.id_hop_dong}" class="btn btn-danger">Delete</a>
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



