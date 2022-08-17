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
        <h2>Đặt vé</h2>
    </div>
</section>
<!-- ##### Breadcumb Area End ##### -->

<!-- ##### Book Now Area Start ##### -->
<div class="book-now-area">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-10">
                <div class="book-now-form">
                    <form action="ticket" method="get" class="row justify-content-center" style="margin: 0">
                        <!-- Form Group -->
                        <div class="form-group col-lg-3">
                            <label for="select1">Điểm Đi</label>
                            <select onChange="handleFromClick(event)" name="from" class="form-control" id="startLocationSelect">
                                <c:forEach items="${locations}" var="location">
                                    <option value="${location.id}"
                                            <c:if test = "${selectedLocationId == location.id}">
                                                selected
                                            </c:if>
                                            >${location.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-3">
                            <label for="select2">Điểm Đến</label>
                            <select name="to" class="form-control" id="endLocationSelect">
                                <c:forEach items="${routes}" var="route">
                                    <option value="${route.endLocationIdInt}"
                                            <c:if test = "${selectedEndId == route.endLocationIdInt}">
                                                selected
                                            </c:if>
                                            >${route.endLocationName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-3">
                            <label for="select3">Ngày đi</label>
                            <input value="${departDate}" style="cursor: pointer;" id="datepicker" name="date" placeholder="Chọn ngày"
                                   class="date form-control transparent-input">
                        </div>


                        <!-- Button -->
                        <button class="col-lg-3" type="submit">Tìm Vé</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Book Now Area End ##### -->

<!-- ##### Elements Area Start ##### -->
<section class="elements-area">
    <div class="container">
        <div class="row">
            <c:if test="${tickets.size() == 0}">
                <p><em>Không có chuyến tại thời điểm hiện tại!!!</em></p>
                <p><em>Vui lòng chọn chyến khác</em></p>
            </c:if>
            <c:forEach items="${tickets}" var="ticket">
                <div class="col-10 mx-auto mb-4">

                    <!--Start Card-->
                    <div class="card">
                        <h5 class="card-header">${ticket.bustripId.getDepartTime()} -> ${ticket.bustripId.getEndTime()}</h5>
                        <div class="card-body">
                            <div class="p-4 pb-0 card-title fs-5">Giá vé: ${ticket.price}VNĐ</div>
                            <div class="p-4 pt-0 pb-0 card-title fs-5">Chỗ trống: còn 4</div>
                            <!-- Section: Timeline -->
                            <section class="p-4 pb-0">

                                <ul class="timeline-3">
                                    <li>
                                        <a href="#!">Bến xe ${ticket.routeId.startLocationId.getName()}</a>
                                        <!--<a href="#!" class="float-end">21 March, 2014</a>-->
                                        <p class="mt-2">
                                            Xe tuyến: 191km - 5 tiếng
                                        </p>
                                    </li>
                                    <li>
                                        <a href="#!">Bến xe ${ticket.routeId.endLocationId.getName()}</a>
                                        <!--<a href="#!" class="float-end">4 March, 2014</a>-->
                                    </li>
                                </ul>
                            </section>
                            <!-- Section: Timeline -->

                            <div class="row justify-content-end">
                                <div class="col-lg-9 col-sm-12 flex">
                                    <!-- Section: Accordians-->
                                    <div class="accordions" id="accordion-${ticket.bustripId.getId()}" role="tablist" aria-multiselectable="true">
                                        <!-- single accordian area -->
                                        <div class="panel single-accordion">
                                            <h6>
                                                <a role="button" class="collapsed" aria-expanded="true" aria-controls="collapseTwo-${ticket.bustripId.getId()}" data-parent="#accordion-${ticket.bustripId.getId()}" data-toggle="collapse" href="#collapseTwo-${ticket.bustripId.getId()}">
                                                    Nhận xét
                                                    <span class="accor-open"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                    <span class="accor-close"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                                </a>
                                            </h6>
                                        </div>

                                    </div>
                                    <!-- Section: Accordians -->
                                </div>

                                <div class="col-lg-3 col-sm-12">
                                    <!-- single accordian area -->
                                    <div class="panel single-accordion">
                                        <h6>
                                            <a role="button" class="collapsed" aria-expanded="true" aria-controls="collapseSeat-${ticket.bustripId.getId()}" data-parent="#accordion-${ticket.bustripId.getId()}" data-toggle="collapse" href="#collapseSeat-${ticket.bustripId.getId()}">
                                                Chọn
                                                <span class="accor-open"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                <span class="accor-close"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                            </a>
                                        </h6>
                                    </div>
                                </div>

                            </div>

                            <!-- collapseTwo Tab-->
                            <div id="collapseTwo-${ticket.bustripId.getId()}" class="accordion-content collapse">
                                <div class="container p-5">
                                    <!--User is logged In-->
                                    <c:if test="${currentUser != null}">
                                        <div class="timeline-comment-box">
                                            <div class="user">
                                                <c:choose>
                                                    <c:when test="${empty currentUser.avatar}">
                                                        <img src="https://bootdey.com/img/Content/avatar/avatar6.png">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="${currentUser.avatar}">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="input">
                                                <form onsubmit="return addComment(event)">
                                                    <div class="input-group">
                                                        <input name="bustripId" value="${ticket.bustripId.getId()}" type="hidden">
                                                        <input name="content" type="text" class="form-control rounded-corner" placeholder="Write a comment...">
                                                        <button class="btn btn-primary f-s-12 rounded-corner" type="submit">Comment</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </c:if>

                                    <!--User not logged In-->
                                    <c:if test="${currentUser == null}">
                                        <div class="shadow p-3 mb-5 bg-white rounded">
                                            <span>Bạn chưa đăng nhập, vui lòng đăng nhập để bình luận</span>
                                            <a href="<c:url value="/login" />" class="btn palatin-btn">Đăng nhập</a>
                                            <a href="<c:url value="/register" />" class="btn palatin-btn">Đăng ký</a>
                                        </div>

                                    </c:if>

                                </div>
                                <ul class="timeline" id="commentBox-${ticket.bustripId.getId()}">
                                    <c:forEach items="${ticket.bustripId.commentSet}" var="comment">
                                        <li>
                                            <!-- begin timeline-body -->
                                            <div class="timeline-body">
                                                <div class="timeline-header">
                                                    <span class="userimage">
                                                        <c:choose>
                                                            <c:when test="${empty comment.userId.avatar}">
                                                                <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">

                                                            </c:when>
                                                            <c:otherwise>
                                                                <img src="${comment.userId.avatar}">
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </span>
                                                    <span class="username"><a href="javascript:;">${comment.userId.username}</a> <small></small></span>
                                                    <!--<span class="pull-right text-muted">18 Views</span>-->
                                                </div>
                                                <div class="timeline-content">
                                                    <p>
                                                        ${comment.content}
                                                    </p>
                                                </div>
                                                <!-- end timeline-body -->
                                                <div/>
                                        </li>
                                    </c:forEach>

                                </ul>
                            </div>
                            <!-- End collapseTwo Tab-->


                            <!-- collapseSeat Tab-->
                            <form action="test" method="post" id="collapseSeat-${ticket.bustripId.getId()}" class="accordion-content collapse">
                                <div class="row p-4">
                                    <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                        <input type="checkbox" name="seatId" value=1 class="btn-check" id="btncheck1" autocomplete="off">
                                        <label class="btn btn-outline-primary" for="btncheck1">Ghế 1</label>

                                        <input type="checkbox" name="seatId" value=2 class="btn-check" id="btncheck2" autocomplete="off">
                                        <label class="btn btn-outline-primary" for="btncheck2">Ghế 2</label>

                                        <input type="checkbox" name="seatId" value=3 class="btn-check" id="btncheck3" autocomplete="off">
                                        <label class="btn btn-outline-primary" for="btncheck3">Ghế 3</label>
                                    </div>
                                </div>
                                <div class="row p-4">
                                    <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                                        <input type="checkbox" name="seatId" value=4 class="btn-check" id="btncheck4" autocomplete="off">
                                        <label class="btn btn-outline-primary" for="btncheck4">Ghế 4</label>

                                        <input type="checkbox" name="seatId" value=5 class="btn-check" id="btncheck5" autocomplete="off">
                                        <label class="btn btn-outline-primary" for="btncheck5">Ghế 5</label>

                                        <input type="checkbox" name="seatId" value=6 class="btn-check" id="btncheck6" autocomplete="off">
                                        <label class="btn btn-outline-primary" for="btncheck6">Ghế 6</label>
                                    </div>
                                </div>
                                <input class="btn palatin-btn btn-3 m-2" type="submit" value="Submit">

                            </form>
                            <!--End collapseSeat Tab-->




                        </div>
                    </div>
                    <!-- /End Card-->
                </div>
            </c:forEach>


        </div>
    </div>
</section>
<!-- ##### Elements Area End ##### -->
