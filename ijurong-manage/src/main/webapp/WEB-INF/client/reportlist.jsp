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
                    <a href="reportlist.html"><li class="report_nav_a">党建快报</li></a>
                    <a href="excellentMember.html"><li class="expert_nav">优秀党员</li></a>
                    <a href="about us.html"><li class="contact_us_nav">联系我们</li></a>
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
<div class="content_news">
    <div>
    	<div class="rightsider_tl">
        	<span class="newslist_icon"><img src="images/newslisttl.png" width="25" height="25" /></span>
            <span class="newslist_txt">您当前的位置：<a href="#">党建平台</a> > <a href="#">党建快报</a></span>
        </div>
        <div class="rightsider_cont">
        	<ul>
            	<li><a href="detail.html">李伟主任应邀出席经合组织部长级理事会等会议并发表主旨演讲</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">隆国强副主任出席第21届中法经济研讨会并致辞</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">第34届中日经济知识交流会在西安召开</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">中国转型升级背景下的绿色增长"联合项目在京启动</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">2016年全国政策咨询工作会议在上海召开</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">隆国强副主任出席中国经济专题吹风会</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">李伟主任出席"2015（第三届）中国粮食与食品安全战略峰会"并致辞</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">张来明副主任出席中日执政党交流机制第五次会议</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">全国政策咨询信息交流协作机制2015年度信息联络员工作会议在京召开</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">国务院发展研究中心与印度国家转型委员会对话会暨中印发展圆桌研讨会2015在京召开印度国家转型委...</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">首届国务院发展研究中心―哈佛大学高端国际研讨会召开</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">张来明副主任为黑龙江省作学习贯彻党的十八届五中全会精神宣讲报告</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">国研中心组织学习党的十八届五中全会精神</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">丝路国际论坛2015年会"圆满闭幕，取得丰硕成果</a><span>[ 2016-12-08 ]</span></li>
                <li><a href="#">把握机遇 主动作为 奋力开创政策咨询研究工作新局面</a><span>[ 2016-12-08 ]</span></li>
            </ul>
        </div>
        <div class="page">
        	<ul>
            	<a href="#"><li>尾页</li></a>
            	<a href="#"><li>下一页</li></a>
            	<a href="#"><li>5</li></a>
                <a href="#"><li>4</li></a>
                <a href="#"><li>3</li></a>
                <a href="#"><li>2</li></a>
                <a href="#"><li>1</li></a>
            </ul>
        </div>
  </div>
</div>
<div class="footer"><p>2007-2014版权所有</p>

    <p>Tel: 123123123 Email: service@123.comQQ: 123123</p>

    <p>Web: www.123.com</p></div>
<div class="footer_menu">
    <a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#">商务合作</a>|<a href="#">其他</a> Copyright2000-2014 
    Co.,Ltd
</div>
<div class="erweima1"></div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
