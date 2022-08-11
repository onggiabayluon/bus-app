<%-- 
    Document   : base
    Created on : Jul 24, 2022, 1:05:52 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="<c:url value="/css/style.css" />">
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="<c:url value="/css/classy-nav.css" />">
        <link rel="stylesheet" href="<c:url value="/css/owl.carousel.min.css" />">
        <link rel="stylesheet" href="<c:url value="/css/animate.css" />">
        <link rel="stylesheet" href="<c:url value="/css/magnific-popup.css" />">
        <link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css" />">
        <link rel="stylesheet" href="<c:url value="/css/nice-select.css" />">
        <link rel="stylesheet" href="<c:url value="/css/travel-icon.css" />">
        <link rel="stylesheet" href="<c:url value="/css/mycss.css" />">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <div>
            <tiles:insertAttribute name="content" />
        </div>
        <tiles:insertAttribute name="footer" />
        
        <!-- ##### All Javascript Script ##### -->
        
        
        
        <!-- jQuery-2.2.4 js -->
        <script src="<c:url value="/js/jquery/jquery-2.2.4.min.js" />"></script>
        <!-- Popper js -->
        <script src="<c:url value="/js/bootstrap/popper.min.js" />"></script>
        <!-- Bootstrap js -->
        <script src="<c:url value="/js/bootstrap/bootstrap.min.js" />"></script>
        <!-- All Plugins js -->
        <script src="<c:url value="/js/plugins/plugins.js" />"></script>
        <!-- Active js -->
        <script src="<c:url value="/js/active.js" />"></script>
    </body>
</html>
