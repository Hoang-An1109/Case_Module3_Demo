<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boarding House Management Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
                    <li><a href="#" class="nav-link px-2 text-white">About</a></li>
                </ul>
            </div>
        </div>
    </header>

    <div class="container">
        <center>
            <h1>Boarding House Management</h1>
            <h2>
                <a href="boardingHouse?action=boardingHouse" class="btn btn-primary">List All Boarding House</a>
            </h2>
        </center>
        <div align="center">
            <form method="post">
                <caption><h2>Edit Boarding House</h2></caption>
                <table class="table table-bordered">
                    <c:if test="${boardingHouse != null}">
                        <input type="hidden" name="id_nha" value="<c:out value='${boardingHouse.id_nha}' />"/>
                    </c:if>
                    <tr>
                        <th>BOARDING HOUSE ADDRESS:</th>
                        <td>
                            <input type="text" name="dia_chi" size="45" class="form-control"
                                   value="<c:out value='${boardingHouse.dia_chi}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>BOARDING HOUSE AREA:</th>
                        <td>
                            <input type="text" name="dien_tich" size="45" class="form-control"
                                   value="<c:out value='${boardingHouse.dien_tich}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>BOARDING HOUSE UNIT PRICE:</th>
                        <td>
                            <input type="text" name="don_gia" size="45" class="form-control"
                                   value="<c:out value='${boardingHouse.don_gia}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>BOARDING HOUSE STATUS:</th>
                        <td>
                            <input type="text" name="trang_thai" size="45" class="form-control"
                                   value="<c:out value='${boardingHouse.trang_thai}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="SAVE" class="btn btn-primary"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>