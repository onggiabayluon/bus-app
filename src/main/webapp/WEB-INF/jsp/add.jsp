<%-- 
    Document   : add
    Created on : Aug 10, 2022, 8:07:53 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<div style="position: fixed;
     top: 3rem;
     z-index: 10000;
     left: 50%;"
     class="spinner-border d-none" role="status"></div>

<div class="toast-container position-fixed top-0 start-50 translate-middle-x p-3">
    <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <svg class="bd-placeholder-img rounded me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect class="icon" width="100%" height="100%" fill="#007aff"></rect></svg>
            <strong class="me-auto">Notification</strong>
            <small>11 mins ago</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            Hello, world! This is a toast message.
        </div>
    </div>
</div>


<div class="container-fluid py-4">
    <div class="row">
        <div/>
        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Bus</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form class="p-4" action="add-bus" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select BustripId</label>
                                        <select name="endLocationId" class="form-control" id="exampleFormControlSelect1">
                                            <c:forEach items="${bustrips}" var="bustrip">
                                                <option value="${bustrip.id}">${bustrip.id}</option>
                                            </c:forEach>
                                            <option value="1">1</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Location</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form class="p-4" onsubmit="addLocation(event)" action="location" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Location</label>
                                        <input name="name" type="text" class="form-control">
                                    </div>
                                </div>

                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Routes</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form onsubmit="addRoute(event)" class="p-4" action="route" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Start Location</label>
                                        <select name="startLocationId" class="form-control" id="exampleFormControlSelect1">
                                            <c:forEach items="${locations}" var="location">
                                                <option value="${location.id}">${location.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select End Location</label>
                                        <select name="endLocationId" class="form-control" id="exampleFormControlSelect1">
                                            <c:forEach items="${locations}" var="location">
                                                <option value="${location.id}">${location.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add BusTrip</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <!--                        <form method="post" onSubmit="addBustrip(event)" class="p-4">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="input-group input-group-static my-3">
                                                                <label>Depart Time</label>
                                                                <input name="departTime" name="departTime" type="time" class="form-control" />
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="input-group input-group-static my-3">
                                                                <label>Arrived Time</label>
                                                                <input name="endTime" name="endTime" type="time" class="form-control" />
                                                            </div>
                                                        </div>
                        
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="input-group input-group-static mb-4">
                                                                <label for="exampleFormControlSelect1" class="ms-0">Select Route</label>
                                                                <select name="routeId" class="form-control">
                        <c:forEach items="${routes}" var="route">
                            <option value="${route.id}">${route.startLocationName} -> ${route.endLocationName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group input-group-static mb-4">
                    <label for="exampleFormControlSelect1" class="ms-0">Select Driver</label>
                    <select name="driverId" class="form-control" id="exampleFormControlSelect1">
                        <option value="1">QuáiXế</option>
                        <option value="1">TàiXếDămBông</option>
                        <option value="1">Dono</option>
                    </select>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-info ml-auto">Submit</button>
    </form>-->
                        <form:form method="post" action="add-bustrip" modelAttribute="bustrip" class="p-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>Depart Time</label>
                                        <form:input path="departTime" name="departTime" type="time" class="form-control" />
                                        <form:errors path="departTime" element="div" cssClass="invalid-feedback" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>Arrived Time</label>
                                        <form:input path="endTime" name="endTime" type="time" class="form-control" />
                                        <form:errors path="endTime" element="div" cssClass="invalid-feedback" />
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Route</label>
                                        <form:select path="routeId" class="form-control">
                                            <c:forEach items="${routes}" var="route">
                                                <option value="${route.id}">${route.startLocationName} -> ${route.endLocationName}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Driver</label>
                                        <form:select path="driverId" class="form-control" id="exampleFormControlSelect1">
                                            <option value="1">QuáiXế</option>
                                            <option value="1">TàiXếDămBông</option>
                                            <option value="1">Dono</option>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
                    </div

                </div>
            </div>
        </div


        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Ticket</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form class="p-4" action="ticket" method="post">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Price</label>
                                        <input name="price" type="number" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>Depart Date</label>
                                        <input name="depart_date" type="date" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Route</label>
                                        <select name="route_id" class="form-control">
                                            <option value="1">Mỹ Tho -> Sài Gòn</option>
                                            <option value="1">Cujut -> Sài Gòn</option>
                                            <option value="1">Doremon -> Cà Mau</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Bustrip</label>
                                        <select name="bustrip_id" class="form-control" id="exampleFormControlSelect1">
                                            <option value="1">1</option>
                                            <option value="1">2</option>
                                            <option value="1">3</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Seat</label>
                                        <select name="seat" class="form-control" id="exampleFormControlSelect1">
                                            <option value="1">Seat 1</option>
                                            <option value="1">Seat 2</option>
                                            <option value="1">Seat 3</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form>
                    </div

                </div>
            </div>
        </div>



    </div>


