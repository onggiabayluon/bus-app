<%-- 
    Document   : index
    Created on : Aug 7, 2022, 2:58:22 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- ##### Breadcumb Area Start ##### -->
<section class="breadcumb-area bg-img d-flex align-items-center justify-content-center" style="background-image: url(/busapp/images/bg-img/bg-9.jpg);">
    <div class="bradcumbContent">
        <h2>Giỏ vé</h2>
    </div>
</section>
<!-- ##### Breadcumb Area End ##### -->


<!-- ##### Elements Area Start ##### -->
<section class="elements-area">
    <div class="container">
        <div class="row">

            <div class="col-10 mx-auto mb-4 mt-4">
                <div class="palatin-buttons-area mb-4">
                    <a href="<c:url value="${referer}"/>" class="btn palatin-btn m-2">Quay lại</a>
                </div>
                <c:if test="${errMsg != null}">
                    <div class="alert alert-danger">
                        ${errMsg}
                    </div>
                </c:if>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Mã Vé</th>
                            <th scope="col">Giá vé</th>
                            <th scope="col">Ngày đi</th>
                            <th scope="col">Giờ khởi hành</th>
                            <th scope="col">Mã ghế</th>
                            <th scope="col">Chuyến xe</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col"></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${tickets}" var="ticket" varStatus="loop">
                        <form action="pay-momo" method="post">
                            <input type="hidden" name="ticketId" value="${ticket.id}"/>

                            <tr>
                                <th scope="row">${loop.count}</th>
                                <td>${ticket.id}</td>
                                <td>${ticket.price}</td>
                                <td>${ticket.bookedDate}</td>
                                <td>${ticket.bustripId.departTime}</td>
                                <td>${ticket.seatId.id}</td>
                                <td>${ticket.bustripId.routeId.startLocationId.name} -> ${ticket.bustripId.routeId.endLocationId.name}</td>
                                <c:if test="${ticket.paymentStatus == true}" var="condition">
                                    <td class="table-success">
                                        Đã thanh toán
                                    </td>
                                </c:if>
                                <c:if test="${!condition}">
                                    <td class="table-danger">
                                        Chưa thanh toán
                                    </td>
                                    <td>
                                        <button 
                                            type="submit" 
                                            class="btn btn-primary btn-block"
                                            onclick="this.form.action = 'pay-momo';"
                                            >
                                            Thanh toán qua momo
                                        </button>
                                    </td>
                                </c:if>

                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>

            </div>



        </div>
    </div>
</section>
<!-- ##### Elements Area End ##### -->
