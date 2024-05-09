<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contract Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"></head>
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
        <center>
            <h1>Contract Management</h1>
            <h2><a href="contract?action=contract" class="btn btn-primary">List All Contract</a></h2>
        </center>
        <div align="center">
            <form method="post">
                <caption><h2>Delete Contract</h2></caption>
                <table class="table table-bordered">
                    <c:if test="${contract != null}">
                        <input type="hidden" name="id_hop_dong" value="<c:out value='${contract.id_hop_dong}' />"/>
                    </c:if>
                    <tr>
                        <th>CONTRACT ID:</th>
                        <td>
                            <div>${contract.id_hop_dong}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>BOARDING HOUSE ID:</th>
                        <td>
                            <div>${contract.boardingHouse.getId_nha()}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>CLIENT ID:</th>
                        <td>
                            <div>${contract.client.id_kh}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>STAFF ID:</th>
                        <td>
                            <div>${contract.staff.id_nv}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>CONTRACT CREATE DATE:</th>
                        <td>
                            <div>${contract.ngay_hd}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>PRICE:</th>
                        <td>
                            <div>${contract.gia_thue}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>DEPOSIT MONEY:</th>
                        <td>
                            <div>${contract.tien_dat_coc}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>CONDITION:</th>
                        <td>
                            <div>${contract.dieu_khoan}</div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-danger">DELETE</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
