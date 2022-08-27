<%-- 
    Document   : header
    Created on : Jul 24, 2022, 1:10:04 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<!-- Preloader -->
<div class="preloader d-flex align-items-center justify-content-center">
    <div class="cssload-container">
        <div class="cssload-loading"><i></i><i></i><i></i><i></i></div>
    </div>
</div>

<!-- ##### Header Area Start ##### -->
<header class="header-area">
    <!-- Navbar Area -->
    <div class="palatin-main-menu">
        <div class="classy-nav-container breakpoint-off">
            <div class="container">
                <!-- Menu -->
                <nav class="classy-navbar justify-content-between" id="palatinNav">

                    <!-- Nav brand -->
                    <!--<a href="index.html" class="nav-brand"><img scr="<c:url value="/images/core-img/logo.png" />" alt=""></a>-->

                    <!-- Navbar Toggler -->
                    <div class="classy-navbar-toggler">
                        <span class="navbarToggler"><span></span><span></span><span></span></span>
                    </div>

                    <!-- Menu -->
                    <div class="classy-menu" style="flex: 1;">

                        <!-- close btn -->
                        <div class="classycloseIcon">
                            <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                        </div>

                        <!-- Nav Start -->
                        <div class="classynav">
                            <ul style="flex: 1;">
                                <li class="active"><a href="<c:url value="/"/>">Home</a></li>
                                <li><a href="about-us.html">About Us</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
                                        <li><a href="<c:url value="/"/>">Home</a></li>
                                        <li><a href="about-us.html">About Us</a></li>
                                        <li><a href="services.html">Services</a></li>
                                        <li><a href="rooms.html">Rooms</a></li>
                                        <li><a href="blog.html">News</a></li>
                                        <li><a href="contact.html">Contact</a></li>
                                        <li><a href="elements.html">Elements</a></li>
                                    </ul>
                                </li>
                                <li><a href="services.html">Services</a></li>
                                <li><a href="contact.html">Contact</a></li>

                                <sec:authorize access="hasAuthority('ADMIN')">
                                    <li><a href="#">Admin Page</a>
                                        <ul class="dropdown">
                                            <li><a href="<c:url value="/admin/" />">Admin</a></li>
                                            <li><a href="<c:url value="/admin/list" />">List</a></li>
                                            <li><a href="<c:url value="/admin/add" />">Add</a></li>
                                        </ul>
                                    </li>
                                </sec:authorize>
                                <sec:authorize access="hasAuthority('EMPLOYEE')">
                                    <li><a href="#">Admin Page</a>
                                        <ul class="dropdown">
                                            <li><a href="<c:url value="/admin/add" />">Add</a></li>
                                        </ul>
                                    </li>
                                </sec:authorize>
                                    
                                <style>
                                    @media only screen and (min-width: 1000px) {
                                        .li-avatar {
                                            left: 410px;
                                        }
                                    }
                                </style>
                                <c:choose>
                                    <c:when test="${currentUser == null}">
                                        <li class="li-avatar position-relative"><a href="login">Đăng nhập</a></li>
                                        <li class="li-avatar position-relative"><a href="register">Đăng ký</a></li>
                                        </c:when>
                                        <c:when test="${currentUser != null}">

                                        <li class="li-avatar">
                                            <a href="#" aria-expanded="false">
                                                <c:choose>
                                                    <c:when test="${empty currentUser.avatar}">
                                                        <img src="https://bootdey.com/img/Content/avatar/avatar6.png"height="35" 
                                                             class="rounded-circle"
                                                             width="35">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="${currentUser.avatar}" 
                                                             class="rounded-circle"
                                                             height="35" 
                                                             width="35"
                                                             alt="${currentUser.username}" 
                                                             loading="eager" />
                                                    </c:otherwise>
                                                </c:choose>

                                            </a>
                                            <ul class="dropdown">
                                                <li><a class="text-primary" href="#">${currentUser.username}</a></li>
                                                <li><a href="<c:url value="/carts" />">Giỏ vé</a></li>
                                                <li><a href="<c:url value="/logout" />">Đăng xuất</a></li>
                                            </ul>
                                        </li>   
                                    </c:when>
                                </c:choose>

                            </ul>

                            <!-- Button -->
                            <!--                            <div class="menu-btn">
                                                            <a href="#" class="btn palatin-btn">Make a Reservation</a>
                                                        </div>-->

                        </div>
                        <!-- Nav End -->
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- ##### Header Area End ##### -->