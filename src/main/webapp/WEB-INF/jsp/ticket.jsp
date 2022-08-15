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
                    <form action="ticket" method="POST" class="row justify-content-center" style="margin: 0">
                        <!-- Form Group -->
                        <div class="form-group col-lg-3">
                            <label for="select1">Điểm Đi</label>
                            <select onChange="handleFromClick(event)" name="from" class="form-control" id="startLocationSelect">
                                <c:forEach items="${locations}" var="location">
                                    <option value="${location.id}"
                                            <c:if test = "${selectedLocationId == location.id}">
                                                selected
                                            </c:if>
                                            >${location.name}</option>
                                    </c:forEach>
                            </select>
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-3">
                            <label for="select2">Điểm Đến</label>
                            <select name="to" class="form-control" id="endLocationSelect">
                                <c:forEach items="${routes}" var="route">
                                    <option value="${route.endLocationIdInt}">${route.endLocationName}</option>
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
                                    <div class="accordions" id="accordion" role="tablist" aria-multiselectable="true">
                                        <!-- single accordian area -->
                                        <div class="panel single-accordion">
                                            <h6>
                                                <a role="button" class="collapsed" aria-expanded="true" aria-controls="collapseTwo" data-parent="#accordion" data-toggle="collapse" href="#collapseTwo">
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
                                            <a role="button" class="collapsed" aria-expanded="true" aria-controls="collapseSeat" data-parent="#accordion" data-toggle="collapse" href="#collapseSeat">
                                                Chọn
                                                <span class="accor-open"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                <span class="accor-close"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                            </a>
                                        </h6>
                                    </div>
                                </div>

                            </div>

                            <!-- collapseTwo Tab-->
                            <div id="collapseTwo" class="accordion-content collapse">
                                <div class="container p-5">
                                    <div class="timeline-comment-box">
                                        <div class="user"><img src="https://bootdey.com/img/Content/avatar/avatar6.png"></div>
                                        <div class="input">
                                            <form action="">
                                                <div class="input-group">
                                                    <input type="text" class="form-control rounded-corner" placeholder="Write a comment...">
                                                    <span class="input-group-btn p-l-10">
                                                        <button class="btn btn-primary f-s-12 rounded-corner" type="button">Comment</button>
                                                    </span>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <ul class="timeline">
                                    <li>
                                        <!-- begin timeline-body -->
                                        <div class="timeline-body">
                                            <div class="timeline-header">
                                                <span class="userimage"><img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt=""></span>
                                                <span class="username"><a href="javascript:;">John Smith</a> <small></small></span>
                                                <!--<span class="pull-right text-muted">18 Views</span>-->
                                            </div>
                                            <div class="timeline-content">
                                                <p>
                                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc faucibus turpis quis tincidunt luctus.
                                                    Nam sagittis dui in nunc consequat, in imperdiet nunc sagittis.
                                                </p>
                                            </div>
                                            <div class="timeline-likes">
                                                <!-- 
                                                <div class="stats-right">
                                                    <span class="stats-text">259 Shares</span>
                                                    <span class="stats-text">21 Comments</span>
                                                </div>
                                                -->
                                                <div class="stats">
                                                    <span class="fa-stack fa-fw stats-icon">
                                                        <i class="fa fa-circle fa-stack-2x text-danger"></i>
                                                        <i class="fa fa-heart fa-stack-1x fa-inverse t-plus-1"></i>
                                                    </span>
                                                    <span class="fa-stack fa-fw stats-icon">
                                                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                                                        <i class="fa fa-thumbs-up fa-stack-1x fa-inverse"></i>
                                                    </span>
                                                    <span class="stats-total">4.3k</span>
                                                </div>
                                            </div>
                                            <div class="timeline-footer">
                                                <a href="javascript:;" class="m-r-15 text-inverse-lighter"><i class="fa fa-thumbs-up fa-fw fa-lg m-r-3"></i> Like</a>
                                                <a href="javascript:;" class="m-r-15 text-inverse-lighter"><i class="fa fa-comments fa-fw fa-lg m-r-3"></i> Comment</a> 
                                                <a href="javascript:;" class="m-r-15 text-inverse-lighter"><i class="fa fa-share fa-fw fa-lg m-r-3"></i> Share</a>
                                            </div>

                                        </div>
                                        <!-- end timeline-body -->
                                    </li>
                                </ul>
                            </div>
                            <!-- End collapseTwo Tab-->


                            <!-- collapseSeat Tab-->
                            <form action="test" method="post" id="collapseSeat" class="accordion-content collapse">
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
