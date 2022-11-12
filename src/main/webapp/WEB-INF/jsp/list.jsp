<%-- 
    Document   : index
    Created on : Aug 10, 2022, 6:23:33 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
=========================================================
* Material Dashboard 2 - v3.0.4
=========================================================

* Product Page: https://www.creative-tim.com/product/material-dashboard
* Copyright 2022 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->






<div class="container-fluid py-4">
    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white text-capitalize ps-3">User table</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">ID</th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Name</th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Role</th>
                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${users}" var="user">
                                    <form:form method="post" action="update-user" modelAttribute="user" class="p-4">
                                        <form:input type="hidden" path="id" value="${user.id}" />
                                        <tr>
                                            <td class="align-middle text-center">
                                                <div class="d-flex px-2 py-1">
                                                    ${user.id}
                                                </div>
                                            </td>
                                            <td>
                                                <span class="text-secondary text-xs font-weight-bold">${user.username}</span>
                                            </td>
                                            <!--Role Options--> 
                                            <td class="align-middle text-center">
                                                <div class="input-group input-group-static mb-4">
                                                    <form:select path="userRole" class="form-control">
                                                        <option value="${user.userRole}" selected>${user.userRole}</option>
                                                        <option value="USER">USER</option>
                                                        <option value="ADMIN">ADMIN</option>
                                                        <option value="DRIVER">DRIVER</option>
                                                        <option value="EMPLOYEE">EMPLOYEE</option>
                                                    </form:select>
                                                </div>
                                            </td>
                                            <td class="align-middle">
                                                <button type="submit" class="btn btn-sm btn-info">Submit</button>
                                            </td>
                                        </tr>
                                    </form:form>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white text-capitalize ps-3">Location table</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">ID</th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Alias</th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Name</th>
                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${locations}" var="location">
                                    <form:form method="post" action="update-location" modelAttribute="location" class="p-4">
                                        <form:input type="hidden" path="id" value="${location.id}" />
                                        <tr>
                                            <td class="align-middle text-center">
                                                <div class="d-flex px-2 py-1">
                                                    ${location.id}
                                                </div>
                                            </td>
                                            <td>
                                                <form:input path="alias" type="text" class="text-secondary text-xs font-weight-bold" value="${location.alias}" />
                                            </td>
                                            <td class="align-middle text-center">
                                                <form:input path="name" type="text" class="text-secondary text-xs font-weight-bold" value="${location.name}" />
                                            </td>
                                            <td class="align-middle">
                                                <button type="submit" class="btn btn-sm btn-info">Submit</button>
                                            </td>
                                        </tr>
                                    </form:form>


                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white text-capitalize ps-3">Route table</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">ID</th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Alias</th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Name</th>
                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${routes}" var="route">
                                    <tr>
                                        <td>
                                            <div class="d-flex px-2 py-1">
                                                ${route.id}
                                            </div>
                                        </td>
                                        <td >
                                            <span class="text-secondary text-xs font-weight-bold">${route.startLocationId.name}</span>
                                        </td>
                                        <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${route.endLocationId.name}</span>
                                        </td>
                                        <td class="align-middle">
                                            <a href="javascript:;" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                                                Edit
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div


    <div class="row">
        <div class="col-12">
            <div class="card my-4">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                        <h6 class="text-white text-capitalize ps-3">Bustrip table</h6>
                    </div>
                </div>
                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">ID</th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Depart Time</th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">End Time</th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Route</th>
                                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Driver Name</th>
                                    <th class="text-secondary opacity-7"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${bustrips}" var="bustrip">
                                    <form:form method="post" action="update-bustrip" modelAttribute="bustrip" class="p-4">
                                        <form:input type="hidden" path="id" value="${bustrip.id}" />
                                        <tr>
                                            <td>
                                                <div class="d-flex px-2 py-1">
                                                    ${bustrip.id}
                                                </div>
                                            </td>
                                            <td >
                                                <span class="text-secondary text-xs font-weight-bold">${bustrip.departTime}</span>
                                            </td>
                                            <td class="align-middle text-center">
                                                <span class="text-secondary text-xs font-weight-bold">${bustrip.endTime}</span>
                                            </td>
                                            <td class="align-middle text-center">
                                                <span class="text-secondary text-xs font-weight-bold">${bustrip.routeId.startLocationId.getName()} -> ${bustrip.routeId.endLocationId.getName()}</span>
                                            </td>
                                            <td class="align-middle text-center">
                                                <div class="input-group input-group-static mb-4">
                                                    <form:select path="driverId" class="form-control" id="exampleFormControlSelect1">
                                                        <option value="${bustrip.driverId.id}" selected>${bustrip.driverId.username}</option>
                                                        <c:forEach items="${users}" var="user">
                                                            <option value="${user.id}">${user.username}</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                            </td>
                                            <td class="align-middle">
                                                <button type="submit" class="btn btn-sm btn-info">Submit</button>
                                            </td>
                                        </tr>
                                    </form:form>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


