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

                <form action="contract" method="get" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <div style="display: inline-block;">
                        <input type="hidden" name="action" value="findValueDTO">
                        <input type="text" name="value" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
                    </div>
                    <button type="submit" class="btn btn-success">Search</button>
                </form>

            </div>
        </div>
    </header>

    <div>
        <h1 class="text-center mt-5">Contract Management</h1>
        <div class="table-responsive">
            <h2 style="float: left;">List of Contract Detail</h2>
            <p style="float: right;">
                Sort By:
                <button onclick="window.location.href='contract?action=contractDTOOderById'">Contract ID</button>
                <button onclick="window.location.href='contract?action=contractDTOOderByDate'">Contract Creation Date</button>
                <button onclick="window.location.href='contract?action=contractDTOOderByPrice'">Price</button>
                <button onclick="window.location.href='contract?action=contractDTOOderByMoney'">Deposit Money</button>
            </p>

            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>Contract ID</th>
                    <th>Clien Name</th>
                    <th>Client Phone Number</th>
                    <th>Staff Name</th>
                    <th>Role</th>
                    <th>Staff Phone Number</th>
                    <th>Contract Creation Date</th>
                    <th>Price</th>
                    <th>Deposit Money</th>
                    <th>Condition</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="contract" items="${listContractDTO}">
                    <tr>
                        <td><c:out value="${contract.id_hop_dong}"/></td>
                        <td><c:out value="${contract.ten_kh}"/></td>
                        <td><c:out value="${contract.dien_thoai_kh}"/></td>
                        <td><c:out value="${contract.ten_nv}"/></td>
                        <td><c:out value="${contract.vai_tro}"/></td>
                        <td><c:out value="${contract.dien_thoai_nv}"/></td>
                        <td><c:out value="${contract.ngay_hd}"/></td>
                        <td><c:out value="${contract.gia_thue}"/></td>
                        <td><c:out value="${contract.tien_dat_coc}"/></td>
                        <td><c:out value="${contract.dieu_khoan}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
