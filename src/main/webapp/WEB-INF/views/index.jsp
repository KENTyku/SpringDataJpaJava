<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: yury--%>
<%--  Date: 06.12.18--%>
<%--  Time: 15:17--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>ProductList</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="menu.jsp"/>--%>
<%--<div>--%>
<%--    <h3>Каталог товаров</h3>--%>
<%--    <a href="editProduct?id=new">Добавить товар</a><br>--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <td><b>id товара:</b></td>--%>
<%--            <td><b>Наименование:</b></td>--%>
<%--            <td><b>Описание:</b></td>--%>
<%--            <td><b>Изображение:</b></td>--%>
<%--            <td><b>Цена:</b></td>--%>
<%--            <td><b>Категория:</b></td>--%>
<%--            <td><b>Производитель:</b></td>--%>
<%--            <td><b>Количество</b></td>--%>
<%--            <td><b>Добавить в корзину</b></td>--%>
<%--        </tr>--%>
<%--        <c:forEach var="product" items="${productList}">--%>
<%--            <form:form method="post" action="addProductToCart">--%>
<%--                <input name="productId" type="hidden" value="${product.id}" id="productId_Products"/>--%>
<%--                <tr>--%>
<%--                    <td>${product.id}</td>--%>
<%--                    <td><a href="editProduct?id=${product.id}">${product.name}</a></td>--%>
<%--                    <td>${product.comment}</td>--%>
<%--                    <td><img src="/resources/${product.imageUrl}" alt="image" width="100"  height="100"></td>--%>
<%--                    <td>${product.price}</td>--%>
<%--                    <td>${product.category.categoryName}</td>--%>
<%--                    <td>${product.country.name}</td>--%>
<%--                    <td><input name="quantity" type="text" id="quantity_Products" value="0"/></td>--%>
<%--                    <td colspan="1"><input type="submit" value="Добавить в корзину"/></td>--%>
<%--                </tr>--%>
<%--            </form:form>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<!--A Design by Yury Tveritin
Author: Yury Tveritin
Author URL: http://kentyku.ru
License: My License
License URL: http://kentyku.ru/licence
-->
<!DOCTYPE html>
<html>
<head>
    <title>My shop</title>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="../../resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="../../resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--theme-style-->
    <link href="../../resources/css/style4.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <script src="../../resources/js/jquery.min.js"></script>
    <!--- start-rate---->
    <script src="../../resources/js/jstarbox.js"></script>
    <link rel="stylesheet" href="../../resources/css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
    <script type="text/javascript">
        jQuery(function() {
            jQuery('.starbox').each(function() {
                var starbox = jQuery(this);
                starbox.starbox({
                    average: starbox.attr('data-start-value'),
                    changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                    ghosting: starbox.hasClass('ghosting'),
                    autoUpdateAverage: starbox.hasClass('autoupdate'),
                    buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                    stars: starbox.attr('data-star-count') || 5
                }).bind('starbox-value-changed', function(event, value) {
                    if(starbox.hasClass('random')) {
                        var val = Math.random();
                        starbox.next().text(' '+val);
                        return val;
                    }
                })
            });
        });
    </script>
    <!---//End-rate---->

</head>
<body>
<!--header-->
<div class="header">
    <div class="container">
        <div class="head">
            <div class=" logo">
                <a href="home"><img src="../../resources/images/logo.png" alt=""></a>
            </div>
        </div>
    </div>
    <div class="header-top">
        <div class="container">
            <div class="col-sm-5 col-md-offset-2  header-login">
                <ul >
                    <li><a href="login">Login</a></li>
                    <li><a href="registration">Register</a></li>
                    <li><a href="../../resources/checkout.html">Checkout</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </div>

            <div class="col-sm-5 header-social">
                <ul >
                    <li><a href="#"><i></i></a></li>
                    <li><a href="#"><i class="ic1"></i></a></li>
                    <li><a href="#"><i class="ic2"></i></a></li>
                    <li><a href="#"><i class="ic3"></i></a></li>
                    <li><a href="#"><i class="ic4"></i></a></li>
                </ul>

            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

    <div class="container">

        <div class="head-top">

            <div class="col-sm-8 col-md-offset-2 h_menu4">
                <nav class="navbar nav_bottom" role="navigation">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                        <ul class="nav navbar-nav nav_1">
                            <li><a class="color" href="products">Catalog</a></li>
                            <li class="dropdown mega-dropdown active">
                                <a class="color1" href="#" class="dropdown-toggle" data-toggle="dropdown">Women<span class="caret"></span></a>
                                <div class="dropdown-menu ">
                                    <div class="menu-top">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu1</h4>
                                                <ul>
                                                    <li><a href="product">Accessories</a></li>
                                                    <li><a href="product">Bags</a></li>
                                                    <li><a href="product">Caps & Hats</a></li>
                                                    <li><a href="product">Hoodies & Sweatshirts</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu2</h4>
                                                <ul>
                                                    <li><a href="product">Jackets & Coats</a></li>
                                                    <li><a href="product">Jeans</a></li>
                                                    <li><a href="product">Jewellery</a></li>
                                                    <li><a href="product">Jumpers & Cardigans</a></li>
                                                    <li><a href="product">Leather Jackets</a></li>
                                                    <li><a href="product">Long Sleeve T-Shirts</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu3</h4>
                                                <ul>
                                                    <li><a href="product">Shirts</a></li>
                                                    <li><a href="product">Shoes, Boots & Trainers</a></li>
                                                    <li><a href="product">Sunglasses</a></li>
                                                    <li><a href="product">Sweatpants</a></li>
                                                    <li><a href="product">Swimwear</a></li>
                                                    <li><a href="product">Trousers & Chinos</a></li>

                                                </ul>

                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu4</h4>
                                                <ul>
                                                    <li><a href="product">T-Shirts</a></li>
                                                    <li><a href="product">Underwear & Socks</a></li>
                                                    <li><a href="product">Vests</a></li>
                                                    <li><a href="product">Jackets & Coats</a></li>
                                                    <li><a href="product">Jeans</a></li>
                                                    <li><a href="product">Jewellery</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1 col5">
                                            <img src="../../resources/images/me.png" class="img-responsive" alt="">
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown mega-dropdown active">
                                <a class="color2" href="#" class="dropdown-toggle" data-toggle="dropdown">Men<span class="caret"></span></a>
                                <div class="dropdown-menu mega-dropdown-menu">
                                    <div class="menu-top">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu1</h4>
                                                <ul>
                                                    <li><a href="product">Accessories</a></li>
                                                    <li><a href="product">Bags</a></li>
                                                    <li><a href="product">Caps & Hats</a></li>
                                                    <li><a href="product">Hoodies & Sweatshirts</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu2</h4>
                                                <ul>
                                                    <li><a href="product">Jackets & Coats</a></li>
                                                    <li><a href="product">Jeans</a></li>
                                                    <li><a href="product">Jewellery</a></li>
                                                    <li><a href="product">Jumpers & Cardigans</a></li>
                                                    <li><a href="product">Leather Jackets</a></li>
                                                    <li><a href="product">Long Sleeve T-Shirts</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu3</h4>

                                                <ul>
                                                    <li><a href="product">Shirts</a></li>
                                                    <li><a href="product">Shoes, Boots & Trainers</a></li>
                                                    <li><a href="product">Sunglasses</a></li>
                                                    <li><a href="product">Sweatpants</a></li>
                                                    <li><a href="product">Swimwear</a></li>
                                                    <li><a href="product">Trousers & Chinos</a></li>

                                                </ul>

                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Submenu4</h4>
                                                <ul>
                                                    <li><a href="product">T-Shirts</a></li>
                                                    <li><a href="product">Underwear & Socks</a></li>
                                                    <li><a href="product">Vests</a></li>
                                                    <li><a href="product">Jackets & Coats</a></li>
                                                    <li><a href="product">Jeans</a></li>
                                                    <li><a href="product">Jewellery</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1 col5">
                                            <img src="../../resources/images/me1.png" class="img-responsive" alt="">
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </li>
                            <li><a class="color3" href="clients">Sale</a></li>
                            <li><a class="color4" href="../../resources/404.html">About</a></li>
                            <li><a class="color5" href="../../resources/typo.html">Short Codes</a></li>
                            <li ><a class="color6" href="../../resources/contact.html">Contact</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
            <div class="col-sm-2 search-right">
                <ul class="heart">
                    <li>
                        <a href="../../resources/wishlist.html" >
                            <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                        </a></li>
                    <li><a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i class="glyphicon glyphicon-search"> </i></a></li>
                </ul>
                <div class="cart box_1">
                    <a href="cart">
                        <h3> <div class="total">
                            <span class="simpleCart_total"></span></div>
                            <img src="../../resources/images/cart.png" alt=""/></h3>
                    </a>
                    <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

                </div>
                <div class="clearfix"> </div>

                <!----->

                <!---pop-up-box---->
                <link href="../../resources/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
                <script src="../../resources/js/jquery.magnific-popup.js" type="text/javascript"></script>
                <!---//pop-up-box---->
                <div id="small-dialog" class="mfp-hide">
                    <div class="search-top">
                        <div class="login-search">
                            <input type="submit" value="">
                            <input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}">
                        </div>
                        <p>Shopin</p>
                    </div>
                </div>
                <script>
                    $(document).ready(function() {
                        $('.popup-with-zoom-anim').magnificPopup({
                            type: 'inline',
                            fixedContentPos: false,
                            fixedBgPos: true,
                            overflowY: 'auto',
                            closeBtnInside: true,
                            preloader: false,
                            midClick: true,
                            removalDelay: 300,
                            mainClass: 'my-mfp-zoom-in'
                        });

                    });
                </script>
                <!----->
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--banner-->
<div class="banner">
    <div class="container">
        <section class="rw-wrapper">
            <h1 class="rw-sentence">
                <span>Fashion &amp; Beauty</span>
                <div class="rw-words rw-words-1">
                    <span>Beautiful Designs</span>
                    <span>Sed ut perspiciatis</span>
                    <span> Totam rem aperiam</span>
                    <span>Nemo enim ipsam</span>
                    <span>Temporibus autem</span>
                    <span>intelligent systems</span>
                </div>
                <div class="rw-words rw-words-2">
                    <span>We denounce with right</span>
                    <span>But in certain circum</span>
                    <span>Sed ut perspiciatis unde</span>
                    <span>There are many variation</span>
                    <span>The generated Lorem Ipsum</span>
                    <span>Excepteur sint occaecat</span>
                </div>
            </h1>
        </section>
    </div>
</div>
<!--content-->
<div class="content">
    <div class="container">
        <div class="content-top">
            <div class="col-md-6 col-md">
                <div class="col-1">
                    <a href="../../resources/single.html" class="b-link-stroke b-animate-go  thickbox">
                        <img src="../../resources/images/pi.jpg" class="img-responsive" alt=""/><div class="b-wrapper1 long-img"><p class="b-animate b-from-right    b-delay03 ">Lorem ipsum</p><label class="b-animate b-from-right    b-delay03 "></label><h3 class="b-animate b-from-left    b-delay03 ">Trendy</h3></div></a>

                    <!---<a href="single.html"><img src="../../resources/images/pi.jpg" class="img-responsive" alt=""></a>-->
                </div>
                <div class="col-2">
                    <span>Hot Deal</span>
                    <h2><a href="../../resources/single.html">Luxurious &amp; Trendy</a></h2>
                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years</p>
                    <a href="../../resources/single.html" class="buy-now">Buy Now</a>
                </div>
            </div>
            <div class="col-md-6 col-md1">
                <div class="col-3">
                    <a href="../../resources/single.html"><img src="../../resources/images/pi1.jpg" class="img-responsive" alt="">
                        <div class="col-pic">
                            <p>Lorem Ipsum</p>
                            <label></label>
                            <h5>For Men</h5>
                        </div></a>
                </div>
                <div class="col-3">
                    <a href="../../resources/single.html"><img src="../../resources/images/pi2.jpg" class="img-responsive" alt="">
                        <div class="col-pic">
                            <p>Lorem Ipsum</p>
                            <label></label>
                            <h5>For Kids</h5>
                        </div></a>
                </div>
                <div class="col-3">
                    <a href="../../resources/single.html"><img src="../../resources/images/pi3.jpg" class="img-responsive" alt="">
                        <div class="col-pic">
                            <p>Lorem Ipsum</p>
                            <label></label>
                            <h5>For Women</h5>
                        </div></a>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!--products-->
        <div class="content-mid">
            <h3>Trending Items</h3>
            <label class="line"></label>
            <div class="mid-popular">
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="../../resources/single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc1.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc1.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="../../resources/single.html">At vero eos</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc2.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc2.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="../../resources/single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc3.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc3.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="../../resources/single.html">On the other</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="mid-popular">
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc4.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc4.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="../../resources/single.html">On the other</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc5.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc5.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="../../resources/single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc6.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc6.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="../../resources/single.html">At vero eos</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../resources/images/pc7.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc7.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="../../resources/single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="../../resources/single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../resources/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--//products-->
        <!--brand-->
        <div class="brand">
            <div class="col-md-3 brand-grid">
                <img src="../../resources/images/ic.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="../../resources/images/ic1.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="../../resources/images/ic2.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="../../resources/images/ic3.png" class="img-responsive" alt="">
            </div>
            <div class="clearfix"></div>
        </div>
        <!--//brand-->
    </div>

</div>
<!--//content-->
<!--//footer-->
<div class="footer">
    <div class="footer-middle">
        <div class="container">
            <div class="col-md-3 footer-middle-in">
                <a href="home"><img src="../../resources/images/log.png" alt=""></a>
                <p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
            </div>

            <div class="col-md-3 footer-middle-in">
                <h6>Information</h6>
                <ul class=" in">
                    <li><a href="404.html">About</a></li>
                    <li><a href="../../resources/contact.html">Contact Us</a></li>
                    <li><a href="#">Returns</a></li>
                    <li><a href="../../resources/contact.html">Site Map</a></li>
                </ul>
                <ul class="in in1">
                    <li><a href="#">Order History</a></li>
                    <li><a href="../../resources/wishlist.html">Wish List</a></li>
                    <li><a href="login.html">Login</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Tags</h6>
                <ul class="tag-in">
                    <li><a href="#">Lorem</a></li>
                    <li><a href="#">Sed</a></li>
                    <li><a href="#">Ipsum</a></li>
                    <li><a href="#">Contrary</a></li>
                    <li><a href="#">Chunk</a></li>
                    <li><a href="#">Amet</a></li>
                    <li><a href="#">Omnis</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Newsletter</h6>
                <span>Sign up for News Letter</span>
                <form>
                    <input type="text" value="Enter your E-mail" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
                    <input type="submit" value="Subscribe">
                </form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <ul class="footer-bottom-top">
                <li><a href="#"><img src="../../resources/images/f1.png" class="img-responsive" alt=""></a></li>
                <li><a href="#"><img src="../../resources/images/f2.png" class="img-responsive" alt=""></a></li>
                <li><a href="#"><img src="../../resources/images/f3.png" class="img-responsive" alt=""></a></li>
            </ul>
            <p class="footer-class">&copy; 2016 Shopin. All Rights Reserved | Design by  <a href="http://kentyku.ru/" target="_blank">kentyku</a> </p>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//footer-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../resources/js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="../../resources/js/bootstrap.min.js"></script>
<!--light-box-files -->
<script src="../../resources/js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="../../resources/css/chocolat.css" type="text/css" media="screen" charset="utf-8">
<!--light-box-files -->
<script type="text/javascript" charset="utf-8">
    $(function() {
        $('a.picture').Chocolat();
    });
</script>


</body>
</html>