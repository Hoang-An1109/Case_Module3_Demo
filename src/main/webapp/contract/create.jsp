<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <use xlink:href="#bootstrap"/>
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
        <center>
            <h1>Contract Management</h1>
            <h2>
                <a href="contract?action=contract" class="btn btn-primary">List All Contract</a>
            </h2>
        </center>
        <div align="center">
            <form method="post">
                <caption><h2>Add New Contract</h2></caption>
                <table class="table table-bordered">
                    <tr>
                        <th>Contract ID:</th>
                        <td><input type="text" name="id_hop_dong" id="id_hop_dong" size="45" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Boarding House ID:</th>
                        <td><input type="text" name="id_nha" id="id_nha" disabled value="${boardingHouse.getId_nha}" size="45" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Client ID:</th>
                        <td><input type="text" name="id_kh" id="id_kh" size="45" disabled value="${client.getId_kh}" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Staff ID:</th>
                        <td><input type="text" name="id_nv" id="id_nv" size="45" disabled value="${staff.getId_nv}" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Contract Creation Cate:</th>
                        <td><input type="text" name="ngay_hd" id="ngay_hd" size="45" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Price:</th>
                        <td><input type="text" name="gia_thue" id="gia_thue" size="45" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Deposit Mone:</th>
                        <td><input type="text" name="tien_dat_coc" id="tien_dat_coc" size="45" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Condition:</th>
                        <td><input type="text" name="dieu_khoan" id="dieu_khoan" size="45" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">CREATE</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
