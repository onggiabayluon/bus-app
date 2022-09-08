<%-- 
    Document   : index
    Created on : Aug 10, 2022, 6:23:33 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h6 class="text-white text-capitalize ps-3">Filter</h6>
          </div>
        </div>
        <div class="card-body px-0 pb-2">

          <form class="p-4" action="" method="get">
            
            <div class="row">
              <div class="col-md-6">
                <div class="input-group input-group-static my-3">
                  <label>From date</label>
                  <input name="fromDate" type="date" class="form-control" value="${fromDate}" />
                </div>
              </div>
              <div class="col-md-6">
                <div class="input-group input-group-static my-3">
                  <label>To date</label>
                  <input name="toDate" type="date" class="form-control" value="${toDate}"/>
                </div>
              </div>
            </div>
            <button type="submit" class="btn btn-info ml-auto">Submit</button>
          </form>

        </div>
      </div>
    </div>
  </div>
  
</div>

<div class="container-fluid py-4">
  <div class="row">
    <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
      <div class="card">
        <div class="card-header p-3 pt-2">
          <div
            class="icon icon-lg icon-shape bg-gradient-dark shadow-dark text-center border-radius-xl mt-n4 position-absolute">
            <i class="material-icons opacity-10">weekend</i>
          </div>
          <div class="text-end pt-1">
            <p class="text-sm mb-0 text-capitalize">Today's Money</p>
            <c:if test="${todayRevenueStats[0] != null}" var="condition">
                <h4 class="mb-0">${todayRevenueStats[0]} VND</h4>
            </c:if>
            <c:if test="${!condition}">
                <h4 class="mb-0">0</h4>
            </c:if>
          </div>
        </div>
        <hr class="dark horizontal my-0">
        <div class="card-footer p-3">
          <!-- <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+??% </span>than last week</p> -->
        </div>
      </div>
    </div>
      
      
      <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
      <div class="card">
        <div class="card-header p-3 pt-2">
          <div
            class="icon icon-lg icon-shape bg-gradient-dark shadow-dark text-center border-radius-xl mt-n4 position-absolute">
            <i class="material-icons opacity-10">weekend</i>
          </div>
          <div class="text-end pt-1">
            <p class="text-sm mb-0 text-capitalize">Total Money</p>
            <c:if test="${totalRevenueStats[0] != null}" var="condition">
                <h4 class="mb-0">${totalRevenueStats[0]} VND</h4>
            </c:if>
            <c:if test="${!condition}">
                <h4 class="mb-0">0</h4>
            </c:if>
          </div>
        </div>
        <hr class="dark horizontal my-0">
        <div class="card-footer p-3">
          <!-- <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+??% </span>than last week</p> -->
        </div>
      </div>
    </div>

    <!-- 
      <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
        <div class="card">
          <div class="card-header p-3 pt-2">
            <div
              class="icon icon-lg icon-shape bg-gradient-primary shadow-primary text-center border-radius-xl mt-n4 position-absolute">
              <i class="material-icons opacity-10">person</i>
            </div>
            <div class="text-end pt-1">
              <p class="text-sm mb-0 text-capitalize">Today's Users</p>
              <h4 class="mb-0">2,300</h4>
            </div>
          </div>
          <hr class="dark horizontal my-0">
          <div class="card-footer p-3">
            <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+3% </span>than last month</p>
          </div>
        </div>
      </div>
      <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
        <div class="card">
          <div class="card-header p-3 pt-2">
            <div
              class="icon icon-lg icon-shape bg-gradient-success shadow-success text-center border-radius-xl mt-n4 position-absolute">
              <i class="material-icons opacity-10">person</i>
            </div>
            <div class="text-end pt-1">
              <p class="text-sm mb-0 text-capitalize">New Clients</p>
              <h4 class="mb-0">3,462</h4>
            </div>
          </div>
          <hr class="dark horizontal my-0">
          <div class="card-footer p-3">
            <p class="mb-0"><span class="text-danger text-sm font-weight-bolder">-2%</span> than yesterday</p>
          </div>
        </div>
      </div>
      <div class="col-xl-3 col-sm-6">
        <div class="card">
          <div class="card-header p-3 pt-2">
            <div
              class="icon icon-lg icon-shape bg-gradient-info shadow-info text-center border-radius-xl mt-n4 position-absolute">
              <i class="material-icons opacity-10">weekend</i>
            </div>
            <div class="text-end pt-1">
              <p class="text-sm mb-0 text-capitalize">Sales</p>
              <h4 class="mb-0">$103,430</h4>
            </div>
          </div>
          <hr class="dark horizontal my-0">
          <div class="card-footer p-3">
            <p class="mb-0"><span class="text-success text-sm font-weight-bolder">+5% </span>than yesterday</p>
          </div>
        </div>
      </div>

     -->

  </div>
  <div class="row mt-4">
    <div class="col-lg-4 col-md-6 mt-4 mb-4">
      <div class="card z-index-2 ">
        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
          <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
            <div class="chart">
              <canvas id="chart-bars" class="chart-canvas" height="170"></canvas>
            </div>
          </div>
        </div>
        <div class="card-body">
          <h6 class="mb-0 ">Month Revenue</h6>
          <p class="text-sm ">Month Campaign Performance</p>
          <hr class="dark horizontal">
          <div class="d-flex ">
            <i class="material-icons text-sm my-auto me-1">schedule</i>
            <p class="mb-0 text-sm"> Now </p>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-6 mt-4 mb-4">
      <div class="card z-index-2  ">
        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
          <div class="bg-gradient-success shadow-success border-radius-lg py-3 pe-1">
            <div class="chart">
              <canvas id="chart-line" class="chart-canvas" height="170"></canvas>
            </div>
          </div>
        </div>
        <div class="card-body">
          <h6 class="mb-0 "> Daily Sales </h6>
          <p class="text-sm "> (<span class="font-weight-bolder">+15%</span>) increase in today sales. </p>
          <hr class="dark horizontal">
          <div class="d-flex ">
            <i class="material-icons text-sm my-auto me-1">schedule</i>
            <p class="mb-0 text-sm"> updated 4 min ago </p>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 mt-4 mb-3">
      <div class="card z-index-2 ">
        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2 bg-transparent">
          <div class="bg-gradient-dark shadow-dark border-radius-lg py-3 pe-1">
            <div class="chart">
              <canvas id="chart-line-tasks" class="chart-canvas" height="170"></canvas>
            </div>
          </div>
        </div>
        <div class="card-body">
          <h6 class="mb-0 ">Completed Tasks</h6>
          <p class="text-sm ">Last Campaign Performance</p>
          <hr class="dark horizontal">
          <div class="d-flex ">
            <i class="material-icons text-sm my-auto me-1">schedule</i>
            <p class="mb-0 text-sm">just updated</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row mb-4">
    <div class="col-lg-8 col-md-6 mb-md-0 mb-4">
      <div class="card">
        <div class="card-header pb-0">
          <div class="row">
            <div class="col-lg-6 col-7">
              <h6>Revenue By Route</h6>
              <p class="text-sm mb-0">
                <i class="fa fa-check text-info" aria-hidden="true"></i>
                <span class="font-weight-bold ms-1">${routeRevenueStats.size() + 1} Routes</span>
                <span class="font-weight-bold ms-1">(${fromDate} -> ${toDate})</span>
              </p>
                
            </div>
            <div class="col-lg-6 col-5 my-auto text-end">
              <div class="dropdown float-lg-end pe-4">
                <a class="cursor-pointer" id="dropdownTable" data-bs-toggle="dropdown" aria-expanded="false">
                  <i class="fa fa-ellipsis-v text-secondary"></i>
                </a>
                <ul class="dropdown-menu px-2 py-3 ms-sm-n4 ms-n5" aria-labelledby="dropdownTable">
                  <li><a class="dropdown-item border-radius-md" href="javascript:;">Action</a></li>
                  <li><a class="dropdown-item border-radius-md" href="javascript:;">Another action</a></li>
                  <li><a class="dropdown-item border-radius-md" href="javascript:;">Something else here</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="card-body px-0 pb-2">
          <div class="table-responsive">
            <table class="table align-items-center mb-0">
              <thead>
                <tr>
                  <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">#</th>
                  <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Start Location</th>
                  <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">End Location
                  </th>
                  <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Total Revenue
                  </th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${routeRevenueStats}" var="routeRevenueStat" varStatus="loop">
                  <tr>

                    <td class="align-middle text-center text-sm">
                      <span class="text-xs font-weight-bold"> ${loop.count} </span>
                    </td>

                    <td class="align-middle text-center text-sm">
                      <span class="text-xs font-weight-bold"> ${routeRevenueStat[0]} </span>
                    </td>
                    
                    <td class="align-middle text-center text-sm">
                      <span class="text-xs font-weight-bold"> ${routeRevenueStat[1]} </span>
                    </td>

                    <td class="align-middle text-center text-sm">
                      <span class="text-xs font-weight-bold"> ${routeRevenueStat[2]} VND </span>
                    </td>
                    
                  </tr>
                </c:forEach>

               
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-6">
      <div class="card h-100">
        <div class="card-header pb-0">
          <h6>Tickets overview</h6>
          <p class="text-sm">
            <i class="fa fa-arrow-up text-success" aria-hidden="true"></i>
            <span class="font-weight-bold">24%</span> this month
          </p>
        </div>
        <div class="card-body p-3">
          <form class="p-4" action="" method="get">
            <div class="row">
              <div class="col-md-6">
                <div class="input-group input-group-static my-3">
                  <label>From date</label>
                  <input name="fromDate" type="date" class="form-control" value="${fromDate}" />
                </div>
              </div>
              <div class="col-md-6">
                <div class="input-group input-group-static my-3">
                  <label>To date</label>
                  <input name="toDate" type="date" class="form-control" value="${toDate}" />
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-lg-8">
                <div class="form-check">
                    <input name="paymentStatus" class="form-check-input" type="checkbox" value="true" id="fcustomCheck1" 
                    <c:if test="${paymentStatus == true}">
                      checked
                    </c:if>
                    >
                    <label class="custom-control-label" for="customCheck1">Đã thanh toán</label>
                  </div>
              </div>
              <div class="col-lg-4">
                <button type="submit" class="btn btn-info btn-sm">Submit</button>
              </div>
            </div>
          </form>
          
          <div class="timeline timeline-one-side">
            <c:forEach items="${tickets}" var="ticket">
              <c:if test="${ticket.paymentStatus == false}" var="condition">
                <div class="timeline-block mb-3">
                  <span class="timeline-step">
                    <i class="material-icons text-warning text-gradient">credit_card</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">New ticket #${ticket.id}</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">${ticket.createdDate}</p>
                  </div>
                </div>
              </c:if>
              <c:if test="${!condition}">
                <div class="timeline-block">
                  <span class="timeline-step">
                    <i class="material-icons text-dark text-gradient">payments</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">Payed Ticket #${ticket.id}</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">${ticket.createdDate}</p>
                  </div>
                </div>
              </c:if>
            </c:forEach>
            
            
          </div>
        </div>
      </div>
    </div>
  </div>
  <footer class="footer py-4  ">
    <div class="container-fluid">
      <div class="row align-items-center justify-content-lg-between">
        <div class="col-lg-6 mb-lg-0 mb-4">
          <div class="copyright text-center text-sm text-muted text-lg-start">
            ©
            <script>
              document.write(new Date().getFullYear())
            </script>,
            made with <i class="fa fa-heart"></i> by
            <a href="https://www.creative-tim.com" class="font-weight-bold" target="_blank">Creative Tim</a>
            for a better web.
          </div>
        </div>
        <div class="col-lg-6">
          <ul class="nav nav-footer justify-content-center justify-content-lg-end">
            <li class="nav-item">
              <a href="https://www.creative-tim.com" class="nav-link text-muted" target="_blank">Creative Tim</a>
            </li>
            <li class="nav-item">
              <a href="https://www.creative-tim.com/presentation" class="nav-link text-muted" target="_blank">About
                Us</a>
            </li>
            <li class="nav-item">
              <a href="https://www.creative-tim.com/blog" class="nav-link text-muted" target="_blank">Blog</a>
            </li>
            <li class="nav-item">
              <a href="https://www.creative-tim.com/license" class="nav-link pe-0 text-muted"
                target="_blank">License</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</div>

  <!-- <script src="<c:url value="/js/plugins/chartjs.min.js" />" async></script> -->
  
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
