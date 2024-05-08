<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"></head>
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
            <h1>Staff Management</h1>
            <h2><a href="staff?action=staff" class="btn btn-primary">List All Staff</a></h2>
        </center>
        <div align="center">
            <form method="post">
                <caption><h2>Delete Staff</h2></caption>
                <table class="table table-bordered">
                    <c:if test="${staff != null}">
                        <input type="hidden" name="id_nv" value="<c:out value='${staff.id_nv}' />"/>
                    </c:if>
                    <tr>
                        <th>STAFF ID:</th>
                        <td>
                            <div>${staff.id_nv}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>STAFF NAME:</th>
                        <td>
                            <div>${staff.ten_nv}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>STAFF ROLE:</th>
                        <td>
                            <div>${staff.vai_tro}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>STAFF CMND:</th>
                        <td>
                            <div>${staff.cmt_nv}</div>
                        </td>
                    </tr>
                    <tr>
                        <th>STAFF PHONE NUMBER:</th>
                        <td>
                            <div>${staff.dien_thoai_nv}</div>
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
