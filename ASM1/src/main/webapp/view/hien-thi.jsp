<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 17/11/24
  Time: 08:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container-fluid">
<h1 align="center">Quản Lý Bạn Bè</h1>
<form action="/ban/update" method="post">
    <div class="row mt-3">
        <input type="hidden" name="id" value="${ban.id}">
        <div class="col-6">
            <label class="form-label">
                Mã:
            </label>
            <input type="text" name="ma" value="${ban.ma}" class="form-control">
            <h3 >${message}</h3>
        </div>

        <div class="col-6">
            <label class="form-label">
                Tên:
            </label>
            <input type="text" name="ten" value="${ban.ten}" class="form-control">
            <h3>${message1}</h3>
        </div>
    </div>

    <div class="row mt-3">
        <div class="col-6">
            <label class="form-label">
                Sở thích:
            </label>
            <input type="text" name="soThich" value="${ban.soThich}" class="form-control">
            <h3>${message2}</h3>
        </div>
        <div class="col-6 mt-3">
            <label class="form-label">
                Giới tính:
            </label>
            <input type="radio" name="gioiTinh" ${ban.gioiTinh == 0 ?"Checked":""} value="0" checked
                   class="form-check-input">
            <label class="form-check-label">
                Nam
            </label>
            <input type="radio" name="gioiTinh" ${ban.gioiTinh == 1 ?"Checked":""} value="1"
                   class="form-check-input">
            <label class="form-check-label">
                Nữ
            </label>
        </div>
    </div>
    <div class="mt-4 mb-3 justify-content-center d-flex gap-2">
        <button type="submit" class="btn btn-info col-1" onclick="ConfirmAndAlert1()">Add</button>
        <button type="submit" class="btn btn-success col-1" onclick="ConfirmAndAlert2()">Update</button>
    </div>
</form>
<table class="table table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã bạn</th>
        <th>Tên bạn</th>
        <th>Sở thích</th>
        <th>Giới tính</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listFriend}" var="b" varStatus="i">
        <tr>
            <td>
                ${i.index + 1}
            </td>
            <td>
                ${b.ma}
            </td>
            <td>
             ${b.ten}
            </td>
            <td>
               ${b.soThich}
            </td>
            <td>
               
                   class="link-dark text-decoration-none">${b.gioiTinh == 0 ? "Nam" : "Nữ"}
            </td>
            <td>
                <button class="btn btn-danger">
                    <a href="/ban/remove?id=${b.id}" class="link-light text-decoration-none"
                       onclick="ConfirmAndAlert()">Remove</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    function ConfirmAndAlert() {
        if (confirm('Bạn có muốn xoá không?')) {
            alert('Xoá thành công');
        } else {
            event.preventDefault();
            return false;
        }
    }
    function ConfirmAndAlert1() {
        if (confirm('Bạn có muốn add không?')) {
            alert('Add thành công');
        } else {
            event.preventDefault();
            return false;
        }
    }
    function ConfirmAndAlert2() {
        if (confirm('Bạn có muốn update không?')) {
            alert('Update thành công');
        } else {
            event.preventDefault();
            return false;
        }
    }
</script>
</body>
</html>
