<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Management Application</title>
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
        <center>
            <h1>Client Management</h1>
            <h2>
                <a href="staff?action=staff" class="btn btn-primary">List All Staff</a>
            </h2>
        </center>
        <div align="center">
            <form method="post">
                <caption><h2>Edit Staff</h2></caption>
                <table class="table table-bordered">
                    <c:if test="${staff != null}">
                        <input type="hidden" name="id_nv" value="<c:out value='${staff.id_nv}' />"/>
                    </c:if>
                    <tr>
                        <th>Staff Name:</th>
                        <td><input type="text" name="ten_nv" size="45" value="<c:out value='${staff.ten_nv}' />"
                                   class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Staff Role:</th>
                        <td><input type="text" name="vai_tro" size="45" value="<c:out value='${staff.vai_tro}' />"
                                   class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Staff CMND:</th>
                        <td><input type="text" name="cmt_nv" size="45"
                                   value="<c:out value='${staff.cmt_nv}' />" class="form-control"/></td>
                    </tr>
                    <tr>
                        <th>Staff Phone Number:</th>
                        <td><input type="text" name="dien_thoai_nv" size="45"
                                   value="<c:out value='${staff.dien_thoai_nv}' />" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">SAVE</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
