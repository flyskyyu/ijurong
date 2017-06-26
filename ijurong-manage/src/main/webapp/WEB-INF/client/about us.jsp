<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<title>开发区党建</title>
<link rel="stylesheet" href="css/css.css" type="text/css" />
</head>
<body>
<div class="nav-bar">
    <div class="welcome"><div class="wel-text">欢迎进入开发区党建平台！</div></div>
    <!--<hr class="welcom_hr"/>-->
    <div class="header" style="">
  <div class="header-wrap">
            <a href="#" class="logo"><img src="images/LOGO.png" width="72" height="63" border="0"/></a>

            <div class="nav_top">
                <ul>
                    <a href="index.html"><li class="home_nav">党建首页</li></a>
       	      		<a href="newslist.html"><li class="news_nav">党建要闻</li></a>
                    <a href="reportlist.html"><li class="report_nav">党建快报</li></a>
                     <a href="expertlist.html"><li class="expert_nav">优秀党员</li></a>
                    <a href="about us.html"><li class="contact_us_nav_a">联系我们</li></a>
                    <div class="sreach_icon" active="off" id="navSearch">
                    <img src="images/sreach.png" width="40"height="34"/>
                    </div>
                </ul>

            </div>
        </div>
  <div id="searchWarp" class="search-wrap">
			
            <button type="submit" class="submit">搜索</button>
            <input type="text"  class="fd_sreach" />
        </div>
    </div>
</div>
<div class="aboutus_bg">
	<dl>
    	<dt><span>开发区党建平台</span></dt>
        <dd>在这里，每一个人都可以获得最新最快的党内信息。</dd>
    </dl>
</div>
<Div class="aboutus_menu">
	<ul>
    	<li><a href="#">公司介绍</a></li>
        <li><a href="#">联系我们</a></li>
<!--        <li><a href="#">意见建议</a></li>
-->    </ul>
</Div>
<div class="aboutus_txt">
	<ul>
    <li>Tel: 123123</li>
<li>QQ: 123123</li>
<li>Email: service@123.com</li>
<li>Web: www.123123.com</li>
</ul>
</div>
<div class="footer"><p>2007-2014版权所有</p>

    <p>Tel: 123123123 Email: service@123.comQQ: 123123</p>

    <p>Web: www.123.com</p></div>
<div class="footer_menu">
    <a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#">商务合作</a>|<a href="#">其他</a> Copyright2000-2014 
    Co.,Ltd
</div>
<div class="erweima1"></div>
<div class="totop" id="backToTop"><img src="images/TOTOP.png" width="59" height="59"/></div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</body>
</html>
