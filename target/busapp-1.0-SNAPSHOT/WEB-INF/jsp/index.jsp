<%-- 
    Document   : index
    Created on : Aug 7, 2022, 2:58:22 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!-- ##### Hero Area Start ##### -->
<section class="hero-area">
    <div class="hero-slides owl-carousel">

        <!-- Single Hero Slide -->
        <div class="single-hero-slide d-flex align-items-center justify-content-center">
            <!-- Slide Img -->
            <div class="slide-img bg-img" style="background-image: url(images/bg-img/bg-1.jpg);"></div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-9">
                        <!-- Slide Content -->
                        <div class="hero-slides-content" data-animation="fadeInUp" data-delay="100ms">
                            <div class="line" data-animation="fadeInUp" data-delay="300ms"></div>
                            <h2 data-animation="fadeInUp" data-delay="500ms">The Vacation Heaven</h2>
                            <p data-animation="fadeInUp" data-delay="700ms">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum. Ut ac ligula sapien. Suspendisse cursus faucibus finibus.</p>
                            <a href="#" class="btn palatin-btn mt-50" data-animation="fadeInUp" data-delay="900ms">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Single Hero Slide -->
        <div class="single-hero-slide d-flex align-items-center justify-content-center">
            <!-- Slide Img -->
            <div class="slide-img bg-img" style="background-image: url(images/bg-img/bg-2.jpg);"></div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-9">
                        <!-- Slide Content -->
                        <div class="hero-slides-content" data-animation="fadeInUp" data-delay="100ms">
                            <div class="line" data-animation="fadeInUp" data-delay="300ms"></div>
                            <h2 data-animation="fadeInUp" data-delay="500ms">A place to remember</h2>
                            <p data-animation="fadeInUp" data-delay="700ms">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum. Ut ac ligula sapien. Suspendisse cursus faucibus finibus.</p>
                            <a href="#" class="btn palatin-btn mt-50" data-animation="fadeInUp" data-delay="900ms">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Single Hero Slide -->
        <div class="single-hero-slide d-flex align-items-center justify-content-center">
            <!-- Slide Img -->
            <div class="slide-img bg-img" style="background-image: url(images/bg-img/bg-3.jpg);"></div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-9">
                        <!-- Slide Content -->
                        <div class="hero-slides-content" data-animation="fadeInUp" data-delay="100ms">
                            <div class="line" data-animation="fadeInUp" data-delay="300ms"></div>
                            <h2 data-animation="fadeInUp" data-delay="500ms">Enjoy your life</h2>
                            <p data-animation="fadeInUp" data-delay="700ms">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum. Ut ac ligula sapien. Suspendisse cursus faucibus finibus.</p>
                            <a href="#" class="btn palatin-btn mt-50" data-animation="fadeInUp" data-delay="900ms">Read More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</section>
<!-- ##### Hero Area End ##### -->

<!-- ##### Book Now Area Start ##### -->
<div class="book-now-area">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-10">
                <div class="book-now-form">
                    <form action="#" class="row">
                        <!-- Form Group -->
                        <div class="form-group col-lg-4">
                            <label for="select1">From</label>
                            <select name="from" class="form-control" id="select1">
                                <option value="Ultrasound Knee Right">Ultrasound Knee Right</option>
                                <option value="Ultrasound Knee Left">Ultrasound Knee Left</option>
                                <option value="MRI Knee Right">MRI Knee Right</option>
                            </select>
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-4">
                            <label for="select2">To</label>
                            <select name="to" class="form-control" id="select2">
                                <option value="MRI Knee Right">MRI Knee Right</option>
                                <option value="Ultrasound Knee Right">Ultrasound Knee Right</option>
                                <option value="Ultrasound Knee Left">Ultrasound Knee Left</option>
                            </select>
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-4">
                            <label for="select3">Date</label>
                            <input style="cursor: pointer;" id="datepicker" name="date" placeholder="Pick Date"
                                   class="date form-control transparent-input">
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-4">
                            <label for="select3">Time</label>
                            <input style="cursor: pointer;" id="timepicker" name="time" placeholder="Pick Time" 
                                   class="date form-control transparent-input"
                                   onclick="forceClickTimePicker(event)">
                        </div>

                        <!-- Form Group -->
                        <div class="form-group col-lg-4">
                            <label for="select4">Seat</label>
                            <select name="seat" class="form-control" id="select4">
                                <option value="1">01</option>
                                <option value="2">02</option>
                                <option value="3">03</option>
                                <option value="4">04</option>
                                <option value="5">05</option>
                            </select>
                        </div>

                        <!-- Button -->
                        <button class="col-lg-4" type="submit">Book Now</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Book Now Area End ##### -->



<!-- ##### Pool Area Start ##### -->
<section class="pool-area section-padding-100 bg-img bg-fixed" style="background-image: url(images/bg-img/4.png);">
    <div class="container">
        <div class="row justify-content-end">
            <div class="col-12 col-lg-7">
                <div class="pool-content text-center wow fadeInUp" data-wow-delay="300ms">
                    <div class="section-heading text-center white">
                        <div class="line-"></div>
                        <h2>Infinity Pool</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum. Ut ac ligula sapien. Suspendisse cursus faucibus finibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum.</p>
                    </div>

                    <div class="row">
                        <div class="col-12 col-sm-4">
                            <div class="pool-feature">
                                <i class="icon-cocktail-1"></i>
                                <p>Pool Beachbar</p>
                            </div>
                        </div>
                        <div class="col-12 col-sm-4">
                            <div class="pool-feature">
                                <i class="icon-swimming-pool"></i>
                                <p>Infinity Pool</p>
                            </div>
                        </div>
                        <div class="col-12 col-sm-4">
                            <div class="pool-feature">
                                <i class="icon-beach"></i>
                                <p>Sunbeds</p>
                            </div>
                        </div>
                    </div>
                    <!-- Button -->
                    <a href="#" class="btn palatin-btn mt-50">Read More</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ##### Pool Area End ##### -->

<!-- ##### Rooms Area Start ##### -->
<section class="rooms-area section-padding-100-0">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-6">
                <div class="section-heading text-center">
                    <div class="line-"></div>
                    <h2>Choose a room</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum. Ut ac ligula sapien.</p>
                </div>
            </div>
        </div>

        <div class="row justify-content-center">

            <!-- Single Rooms Area -->
            <div class="col-12 col-md-6 col-lg-4">
                <div class="single-rooms-area wow fadeInUp" data-wow-delay="100ms">
                    <!-- Thumbnail -->
                    <div class="bg-thumbnail bg-img" style="background-image: url(images/bg-img/1.jpg);"></div>
                    <!-- Price -->
                    <p class="price-from">From $150/night</p>
                    <!-- Rooms Text -->
                    <div class="rooms-text">
                        <div class="line"></div>
                        <h4>Deluxe Room</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque.</p>
                    </div>
                    <!-- Book Room -->
                    <a href="#" class="book-room-btn btn palatin-btn">Book Room</a>
                </div>
            </div>

            <!-- Single Rooms Area -->
            <div class="col-12 col-md-6 col-lg-4">
                <div class="single-rooms-area wow fadeInUp" data-wow-delay="300ms">
                    <!-- Thumbnail -->
                    <div class="bg-thumbnail bg-img" style="background-image: url(images/bg-img/8.jpg);"></div>
                    <!-- Price -->
                    <p class="price-from">From $150/night</p>
                    <!-- Rooms Text -->
                    <div class="rooms-text">
                        <div class="line"></div>
                        <h4>Double Suite</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque.</p>
                    </div>
                    <!-- Book Room -->
                    <a href="#" class="book-room-btn btn palatin-btn">Book Room</a>
                </div>
            </div>

            <!-- Single Rooms Area -->
            <div class="col-12 col-md-6 col-lg-4">
                <div class="single-rooms-area wow fadeInUp" data-wow-delay="500ms">
                    <!-- Thumbnail -->
                    <div class="bg-thumbnail bg-img" style="background-image: url(images/bg-img/9.jpg);"></div>
                    <!-- Price -->
                    <p class="price-from">From $100/night</p>
                    <!-- Rooms Text -->
                    <div class="rooms-text">
                        <div class="line"></div>
                        <h4>Single Room</h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque.</p>
                    </div>
                    <!-- Book Room -->
                    <a href="#" class="book-room-btn btn palatin-btn">Book Room</a>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- ##### Rooms Area End ##### -->

<!-- ##### Contact Area Start ##### -->
<section class="contact-area d-flex flex-wrap align-items-center">
    <div class="home-map-area">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22236.40558254599!2d-118.25292394686001!3d34.057682914027104!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2c75ddc27da13%3A0xe22fdf6f254608f4!2z4Kay4Ka4IOCmj-CmnuCnjeCmnOCnh-CmsuCnh-CmuCwg4KaV4KeN4Kav4Ka-4Kay4Ka_4Kar4KeL4Kaw4KeN4Kao4Ka_4Kav4Ka84Ka-LCDgpq7gpr7gprDgp43gppXgpr_gpqgg4Kav4KeB4KaV4KeN4Kak4Kaw4Ka-4Ka34KeN4Kaf4KeN4Kaw!5e0!3m2!1sbn!2sbd!4v1532328708137" allowfullscreen></iframe>
    </div>
    <!-- Contact Info -->
    <div class="contact-info">
        <div class="section-heading wow fadeInUp" data-wow-delay="100ms">
            <div class="line-"></div>
            <h2>Contact Info</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris sceleri sque, at rutrum nulla dictum. Ut ac ligula sapien. Suspendisse cursus faucibus finibus. Lorem ipsum dolor sit amet, consectetur adipiscing.</p>
        </div>
        <h4 class="wow fadeInUp" data-wow-delay="300ms">Los Angeles 1481 Creekside Lane Avila Beach, CA 931</h4>
        <h5 class="wow fadeInUp" data-wow-delay="400ms">+53 345 7953 32453</h5>
        <h5 class="wow fadeInUp" data-wow-delay="500ms">yourmail@gmail.com</h5>
        <!-- Social Info -->
        <div class="social-info mt-50 wow fadeInUp" data-wow-delay="600ms">
            <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
        </div>
    </div>
</section>
<!-- ##### Contact Area End ##### -->





<script src="<c:url value="https://unpkg.com/gijgo@1.9.13//js/gijgo.min.js" />" type="text/javascript"></script>


<script>
                                $('#datepicker').datepicker({
                                    uiLibrary: 'bootstrap',
                                    format: 'dd-mm-yyyy'

                                });
                                $('#timepicker').timepicker();
                                function forceClickTimePicker(e) {
                                    e.target.nextSibling.click()
                                }
</script>