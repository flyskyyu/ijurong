<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>融智库</title>
<link rel="stylesheet" href="/css/css.css" type="text/css" />
</head>
<body>
<div class="nav-bar">
    <div class="welcome"><div class="wel-text">欢迎进入融智库咨询平台！</div></div>
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
            <input type="text"  class="fd_sreach" />
        </div>
    </div>
</div>
<div class="content_expert">
    <div class="rightsider_tl">
                <span class="newslist_icon"><img src="/images/newslisttl.png" width="25" height="25" /></span>
                <span class="newslist_txt">您当前的位置：<a href="#">党建平台</a> > <a href="#">优秀党员</a></span>
    </div>
    <div class="leftsider_zj">
          <div class="intr_expert">
            <h1>${member.staffName}</h1>
            <span>${member.title}</span>
            <img src="${member.avatar}" width="220" height="270" />
            </div>
            <div class="ex_partook">

            </div>
            <div class="expert_menu">
         	<ul>

            </ul>
         </div>
         </div>
         <div class="rightsider_zj">
         	${member.meritoriousDeeds}
         </div>
    </div>
    
<div class="footer"><p>2007-2014版权所有</p>

    <p>Tel: 4006751989Email: service@retechcorp.comQQ: 603483407</p>

    <p>Web: www.retechcorp.com</p></div>
<div class="footer_menu">
    <a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#">商务合作</a>|<a href="#">交互电子书</a> Copyright2000-2014Retech Group
    Co.,Ltd
</div>
<div class="erweima1"></div>
<div class="totop" id="backToTop"><img src="/images/TOTOP.png" width="59" height="59"/></div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>
