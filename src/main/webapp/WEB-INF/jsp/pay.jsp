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
        <h2>Xác nhận thông tin</h2>
    </div>
</section>
<!-- ##### Breadcumb Area End ##### -->


<!-- ##### Elements Area Start ##### -->
<section class="elements-area">
    <div class="container">
        <div class="row">

            <div class="col-10 mx-auto mb-4 mt-4">
                <div class="palatin-buttons-area mb-4">
                    <a href="<c:url value="/bustrip/1"/>" class="btn palatin-btn m-2">Quay lại</a>
                </div>
                <!--Start Card-->
                <div class="card">
                    <div class="card-body">
                        <div class="p-4 pb-0 card-title fs-5">Giá vé: 75000VND</div>
                        <div class="p-4 pt-0 pb-0 card-title fs-5">Chỗ trống: còn 4</div>
                        <!-- Section: Timeline -->
                        <section class="p-4 pb-0">
                            <ul class="timeline-3">
                                <li>
                                    <a href="#!">Bến xe Long Xuyên</a>
                                    <!--<a href="#!" class="float-end">21 March, 2014</a>-->
                                    <p class="mt-2">
                                        Xe tuyến: 191km - 5 tiếng
                                    </p>
                                </li>
                                <li>
                                    <a href="#!">Bến xe Tp.HCM</a>
                                    <!--<a href="#!" class="float-end">4 March, 2014</a>-->
                                </li>
                            </ul>
                        </section>
                        <!-- Section: Timeline -->

                        <div class="p-4 pb-0 card-title fs-5">Ghế chọn: ghế 1, ghế 2</div>

                    </div>
                </div>
                <!-- /End Card-->

            </div>
            <div class="col-10 mx-auto mb-4 mt-4">
                <!--Start Card-->
                <div class="card p-4">
                    <h5 class="card-title">Thông tin khách hàng</h5>
                    <div class="card-body">
                        <form>
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input name="fullName" type="text" class="form-control" />
                                <label class="form-label">Họ tên</label>
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <input name="phone" type="text" class="form-control" />
                                <label class="form-label">Số điện thoại</label>
                            </div>
                            
                            <div class="form-outline mb-4">
                                <input name="email" type="email" class="form-control" />
                                <label class="form-label">Email</label>
                            </div>
                            
                            <div class="form-outline mb-4 ">
                                Tổng tiền: 150000 VND
                            </div>


                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-block">Đặt vé</button>
                        </form>
                    </div>
                </div>
                <!-- /End Card-->
            </div>


        </div>
    </div>
</section>
<!-- ##### Elements Area End ##### -->
