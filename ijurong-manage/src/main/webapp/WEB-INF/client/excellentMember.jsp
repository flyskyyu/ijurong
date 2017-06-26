<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>开发区党建</title>
    <link rel="stylesheet" href="/css/css.css" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <style>
        .division {
            display: none;
        }

        .active {
            display: block;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $(".e_link").click(function () {
                var targetId=$(this).attr("data-target");
                $(".active").removeClass("active");
                $("#"+targetId).addClass("active");
            });
			$("#all").click(function () {
                $(".division").addClass("active");
            });
			    $(".division").addClass("active");

        });


    </script>
</head>
<body>
<div class="nav-bar">
    <div class="welcome">
        <div class="wel-text">欢迎进入开发区党建平台！</div>
    </div>
    <!--<hr class="welcom_hr"/>-->
    <div class="header" style="">
        <div class="header-wrap">
            <a href="#" class="logo"><img src="/images/LOGO.png" width="72" height="63" border="0"/></a>

            <div class="nav_top">
                <ul>
                     <a href="index.html"><li class="home_nav">党建首页</li></a>
       	      		<a href="newslist.html"><li class="news_nav">党建要闻</li></a>
                    <a href="reportlist.html"><li class="report_nav">党建快报</li></a>
                     <a href="excellentMember.html"><li class="expert_nav_a">优秀党员</li></a>
                    <a href="about us.html"><li class="contact_us_nav">联系我们</li></a>
                    <div class="sreach_icon" active="off" id="navSearch">
                        <img src="/images/sreach.png" width="40" height="34"/>
                    </div>
                </ul>

            </div>
        </div>
        <div id="searchWarp" class="search-wrap">

            <button type="submit" class="submit">搜索</button>
            <input type="text" class="fd_sreach"/>
        </div>
    </div>
</div>
<div class="rightsider_expert">
    <div class="rightsider_tl">
        <span class="newslist_icon"><img src="/images/newslisttl.png" width="25" height="25"/></span>
        <span class="newslist_txt">您当前的位置：<a href="#">党建平台</a> > <a href="#">优秀党员</a></span>
    </div>
    <Div class="expert_list">
        <Div class="expert_detail">
            <ul class="E_letter">
                <li class="e_hover" id="all"><a href="#">全部</a></li>
                <c:forEach items="${members}" var="map">
                    <li class="e_link" data-target="${map.key}"><a href="#">${map.key}</a></li>
                </c:forEach>
            </ul>
            <c:forEach items="${members}" var="map">
                <div class="division" id="${map.key}">
                    <span>${map.key}</span>
                    <ul class="clearfix ">
                        <c:forEach items="${map.value}" var="member">
                            <li><a href="member_detail.html?id=${member.id}" target="_self">${member.staffName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
        </Div>

    </Div>
</div>
<div class="footer"><p>2007-2014版权所有</p>

    <p>Tel: 123123123 Email: service@123.comQQ: 123123</p>

    <p>Web: www.123.com</p></div>
<div class="footer_menu">
    <a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#">商务合作</a>|<a href="#">其他</a> Copyright2000-2014
    Co.,Ltd
</div>
<div class="erweima1"></div>
<div class="totop" id="backToTop"><img src="/images/TOTOP.png" width="59" height="59"/></div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>
