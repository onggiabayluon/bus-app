<%-- 
    Document   : add
    Created on : Aug 10, 2022, 8:07:53 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring"
           uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ##### Breadcumb Area Start ##### -->
<section class="breadcumb-area bg-img d-flex align-items-center justify-content-center" style="background-image: url(/busapp/images/bg-img/bg-9.jpg);">
    <div class="bradcumbContent">
        <h2>Đăng nhập</h2>
    </div>
</section>
<!-- ##### Breadcumb Area End ##### -->

<div class="book-now-area p-4">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-10">
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        Đã có lỗi xảy ra
                    </div>
                </c:if>
                <c:if test="${param.accessDenied != null}">
                    <div class="alert alert-danger">
                        Bạn không có quyền truy cập
                    </div>
                </c:if>

                <form action="login" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Username</label>
                        <input name="username" type="text" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                    </div>

                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</div>

