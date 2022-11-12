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
                            <h6 class="text-white text-capitalize ps-3">Add User</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form:form class="p-4" action="add-user" method="post" modelAttribute="user">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">User name</label>
                                        <form:input path="username" type="text" class="form-control" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Password</label>
                                        <form:input path="password" type="text" class="form-control" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select User Role</label>
                                        <form:select path="userRole" class="form-control" id="exampleFormControlSelect1">
                                            <option value="DRIVER">DRIVER</option>
                                            <option value="EMPLOYEE">EMPLOYEE</option>
                                            <option value="USER">USER</option>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

        
        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Seat to Bus</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form:form class="p-4" action="add-seat" method="post" modelAttribute="seat">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Bus</label>
                                        <form:select path="busId" class="form-control">
                                            <c:forEach items="${buses}" var="bus">
                                                <option value="${bus.id}">${bus.id} - ${bus.name}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        

        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Bus</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form:form class="p-4" action="add-bus" method="post" modelAttribute="bus">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Bus name</label>
                                        <form:input path="name" type="text" class="form-control" />
                                    </div>
                                </div>
                                
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
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
                        <form:form class="p-4" action="add-location" method="post" modelAttribute="location">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Location</label>
                                        <form:input path="name" type="text" class="form-control" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Alias</label>
                                        <form:input path="alias" type="text" class="form-control" />
                                    </div>
                                </div>

                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
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
                        <form:form class="p-4" action="add-route" method="post" modelAttribute="route">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Start Location</label>
                                        <form:select path="startLocationId" class="form-control" id="exampleFormControlSelect1">
                                            <c:forEach items="${locations}" var="location">
                                                <option value="${location.id}">${location.name}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select End Location</label>
                                        <form:select path="endLocationId" class="form-control" id="exampleFormControlSelect1">
                                            <c:forEach items="${locations}" var="location">
                                                <option value="${location.id}">${location.name}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
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
                        <form:form  method="post" action="add-bustrip" modelAttribute="bustrip" class="p-4">
                            <div id="time-clone" class="row">
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
                                <button type="button" onclick="addMoreBustrip(event)"  class="btn btn-info ml-auto">Add more</button>
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
                                            <c:forEach items="${drivers}" var="driver">
                                                <option value="${driver.id}">${driver.username}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Bus</label>
                                        <form:select path="busId" class="form-control">
                                            <c:forEach items="${buses}" var="bus">
                                                <option value="${bus.id}">${bus.id} - ${bus.name}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Calendar</label>
                                        <form:select path="calendarId" class="form-control" id="exampleFormControlSelect1">
                                            <c:forEach items="${calendars}" var="calendar">
                                                <option value="${calendar.id}">${calendar.alias} - ${calendar.monday} - ${calendar.tuesday} - ${calendar.wednesday} - ${calendar.thursday} - ${calendar.friday} - ${calendar.saturday} - ${calendar.sunday}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Price</label>
                                        <form:input path="price" type="number" class="form-control" />
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
                    </div

                </div>
            </div>
        </div>




        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Calendar</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form:form class="p-4" action="add-calendar" method="post" modelAttribute="calendar">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Alias</label>
                                        <form:input path="alias" type="text" class="form-control" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="monday"  value="2" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Monday</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="tuesday" value="3" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Tuesday</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="wednesday"  value="4" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Wednesday</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="thursday" value="5" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Thursday</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="friday"  value="6" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Friday</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="saturday" value="7" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Saturday</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-check">
                                        <form:checkbox path="sunday"  value="1" class="form-check-input" checked="" />
                                        <label class="custom-control-label" for="customCheck1">Sunday</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>Start service date</label>
                                        <form:input path="startDate" type="date" class="form-control" />
                                        <form:errors path="startDate" element="div" cssClass="invalid-feedback" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>End service date</label>
                                        <form:input path="endDate" type="date" class="form-control" />
                                        <form:errors path="endDate" element="div" cssClass="invalid-feedback" />
                                    </div>
                                </div>

                            </div>
                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>





        <div class="row">
            <div class="col-12">
                <div class="card my-4">
                    <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                        <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                            <h6 class="text-white text-capitalize ps-3">Add Calendar dates</h6>
                        </div>
                    </div>
                    <div class="card-body px-0 pb-2">
                        <form:form method="post" action="add-calendar-dates" modelAttribute="calendarDates" class="p-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>Select date</label>
                                        <form:input path="date" name="departTime" type="date" class="form-control" />
                                        <form:errors path="date" element="div" cssClass="invalid-feedback" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Type</label>
                                        <select name="exceptionType" class="form-control" id="exampleFormControlSelect1">
                                            <option value="1">Add this date to calendar</option>
                                            <option value="2">Remove this date from calendar</option>
                                            <option value="3">Add this date as holiday for Surcharge</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="input-group input-group-static mb-4">
                                        <label for="exampleFormControlSelect1" class="ms-0">Select Calendar</label>
                                        <form:select path="calendarId" class="form-control">
                                            <c:forEach items="${calendars}" var="calendar">
                                                <option value="${calendar.id}">${calendar.id} - ${calendar.alias}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group input-group-static my-3">
                                        <label>Select Ratio</label>
                                        <form:input path="ratio" type="number" value="1.0" step="0.1" class="form-control" />
                                        <form:errors path="ratio" element="div" cssClass="invalid-feedback" />
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-info ml-auto">Submit</button>
                        </form:form>
                    </div

                </div>
            </div>
        </div




    </div>


    <script>


        const addMoreBustrip = async (e) => {
            e.preventDefault();
            try {
                let timeRoot = document.getElementById("time-clone");
                let clone = timeRoot.cloneNode(true);

                timeRoot.appendChild(clone);


            } catch (error) {
                console.log(error);
            }
        };

        const addMoreSeat = async (e) => {
            e.preventDefault();
            try {
                let seatRoot = document.getElementById("seat-clone");
                let clone = seatRoot.cloneNode(true);

                seatRoot.appendChild(clone);


            } catch (error) {
                console.log(error);
            }
        };
    </script>