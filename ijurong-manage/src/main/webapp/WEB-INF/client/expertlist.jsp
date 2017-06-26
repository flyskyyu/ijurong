<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="css/css.css" type="text/css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
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
            <a href="#" class="logo"><img src="images/LOGO.png" width="72" height="63" border="0"/></a>

            <div class="nav_top">
                <ul>
                     <a href="index.html"><li class="home_nav">党建首页</li></a>
       	      		<a href="newslist.html"><li class="news_nav">党建要闻</li></a>
                    <a href="reportlist.html"><li class="report_nav">党建快报</li></a>
                     <a href="expertlist.html"><li class="expert_nav_a">优秀党员</li></a>
                    <a href="about us.html"><li class="contact_us_nav">联系我们</li></a>
                    <div class="sreach_icon" active="off" id="navSearch">
                        <img src="images/sreach.png" width="40" height="34"/>
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
        <span class="newslist_icon"><img src="images/newslisttl.png" width="25" height="25"/></span>
        <span class="newslist_txt">您当前的位置：<a href="#">党建平台</a> > <a href="#">优秀党员</a></span>
    </div>
    <Div class="expert_list">
        <Div class="expert_detail">
            <ul class="E_letter">
                <li class="e_hover" id="all"><a href="#">全部</a></li>
                <li class="e_link" data-target="search1"><a href="#">A</a></li>
                <li class="e_link" data-target="search2"><a href="#">B</a></li>
                <li class="e_link"><a href="#">C</a></li>
                <li class="e_link"><a href="#">D</a></li>
                <li class="e_link"><a href="#">E</a></li>
                <li class="e_link"><a href="#">F</a></li>
                <li class="e_link"><a href="#">G</a></li>
                <li class="e_link"><a href="#">H</a></li>
                <li class="e_link"><a href="#">I</a></li>
                <li class="e_link"><a href="#">J</a></li>
                <li class="e_link"><a href="#">K</a></li>
                <li class="e_link"><a href="#">L</a></li>
                <li class="e_link"><a href="#">M</a></li>
                <li class="e_link"><a href="#">N</a></li>
                <li class="e_link"><a href="#">O</a></li>
                <li class="e_link"><a href="#">P</a></li>
                <li class="e_link"><a href="#">Q</a></li>
                <li class="e_link"><a href="#">R</a></li>
                <li class="e_link"><a href="#">S</a></li>
                <li class="e_link"><a href="#">T</a></li>
                <li class="e_link"><a href="#">U</a></li>
                <li class="e_link"><a href="#">V</a></li>
                <li class="e_link"><a href="#">W</a></li>
                <li class="e_link"><a href="#">X</a></li>
                <li class="e_link"><a href="#">Y</a></li>
                <li class="e_link"><a href="#">Z</a></li>
            </ul>
            <div class="division" id="search1">
                <span>A</span>
                <ul class="clearfix ">
                    <li><a href="expert_detail.html" target="_self">安同良</a></li>
                    <li><a href="#" target="_self">安实</a></li>
                    <li><a href="#" target="_self">艾四林</a></li>
                    <li><a href="#" target="_self">艾春荣</a></li>
                </ul>
            </div>
            <div class="division" id="search2">
                <span>B</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>C</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">崔传义</a></li>
                    <li><a href="#" target="_self">崔保山 </a></li>
                    <li><a href="#" target="_self">崔建远</a></li>
                    <li><a href="#" target="_self">崔玉凤</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹凤刚</a></li>
                    <li><a href="#" target="_self">曹凤岐</a></li>
                    <li><a href="#" target="_self">曹小奇</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹普</a></li>
                    <li><a href="#" target="_self">曹淑敏</a></li>
                    <li><a href="#" target="_self">曹顺庆</a></li>

                    <li><a href="#" target="_self">柴发合</a></li>
                    <li><a href="#" target="_self">柴瑜 </a></li>
                    <li><a href="#" target="_self">程会强</a></li>
                    <li><a href="#" target="_self">程卫东</a></li>
                    <li><a href="#" target="_self">程国强</a></li>
                    <li><a href="#" target="_self">程天权</a></li>
                    <li><a href="#" target="_self">程恩富</a></li>
                    <li><a href="#" target="_self">程秀生</a></li>
                    <li><a href="#" target="_self">蔡学军</a></li>
                    <li><a href="#" target="_self">蔡?P</a></li>
                    <li><a href="#" target="_self">蔡洪滨</a></li>
                    <li><a href="#" target="_self">蔡莉</a></li>

                    <li><a href="#" target="_self">迟福林</a></li>
                    <li><a href="#" target="_self">陈传明 </a></li>
                    <li><a href="#" target="_self">陈信元</a></li>
                    <li><a href="#" target="_self">陈光金</a></li>
                    <li><a href="#" target="_self">陈共</a></li>
                    <li><a href="#" target="_self">陈兴良</a></li>
                    <li><a href="#" target="_self">陈利权</a></li>
                    <li><a href="#" target="_self">陈功</a></li>
                    <li><a href="#" target="_self">陈劲</a></li>
                    <li><a href="#" target="_self">陈卫东</a></li>
                    <li><a href="#" target="_self">陈发虎</a></li>
                    <li><a href="#" target="_self">崔传义</a></li>

                    <li><a href="#" target="_self">崔保山</a></li>
                    <li><a href="#" target="_self">崔建远 </a></li>
                    <li><a href="#" target="_self">崔玉凤</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹凤刚</a></li>
                    <li><a href="#" target="_self">曹凤岐</a></li>
                    <li><a href="#" target="_self">曹小奇</a></li>
                    <li><a href="#" target="_self">曹普</a></li>
                    <li><a href="#" target="_self">曹淑敏</a></li>
                    <li><a href="#" target="_self">曹顺庆</a></li>
                    <li><a href="#" target="_self">柴瑜</a></li>
                    <li><a href="#" target="_self">程会强</a></li>
                </ul>
            </div>
            <div class="division">
                <span>D</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">丁元竹</a></li>
                    <li><a href="#" target="_self">丁宁宁 </a></li>
                    <li><a href="#" target="_self">丁建定</a></li>
                    <li><a href="#" target="_self">丁金宏 </a></li>
                    <li><a href="#" target="_self">戴建军 </a></li>
                    <li><a href="#" target="_self"> 戴松若 </a></li>
                    <li><a href="#" target="_self">戴焰军</a></li>
                    <li><a href="#" target="_self">戴玉忠</a></li>
                    <li><a href="#" target="_self">杜厚文 </a></li>
                    <li><a href="#" target="_self">杜志雄 </a></li>
                    <li><a href="#" target="_self"> 段炳德 </a></li>
                    <li><a href="#" target="_self">董伟俊</a></li>
                    <li><a href="#" target="_self">董克用</a></li>
                </ul>
            </div>
            <div class="division">
                <span>E</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>F</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">崔传义</a></li>
                    <li><a href="#" target="_self">崔保山 </a></li>
                    <li><a href="#" target="_self">崔建远</a></li>
                    <li><a href="#" target="_self">崔玉凤</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹凤刚</a></li>
                    <li><a href="#" target="_self">曹凤岐</a></li>
                    <li><a href="#" target="_self">曹小奇</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹普</a></li>
                    <li><a href="#" target="_self">曹淑敏</a></li>
                    <li><a href="#" target="_self">曹顺庆</a></li>

                    <li><a href="#" target="_self">柴发合</a></li>
                    <li><a href="#" target="_self">柴瑜 </a></li>
                    <li><a href="#" target="_self">程会强</a></li>
                    <li><a href="#" target="_self">程卫东</a></li>
                    <li><a href="#" target="_self">程国强</a></li>
                    <li><a href="#" target="_self">程天权</a></li>
                    <li><a href="#" target="_self">程恩富</a></li>
                    <li><a href="#" target="_self">程秀生</a></li>
                    <li><a href="#" target="_self">蔡学军</a></li>
                    <li><a href="#" target="_self">蔡?P</a></li>
                    <li><a href="#" target="_self">蔡洪滨</a></li>
                    <li><a href="#" target="_self">蔡莉</a></li>

                    <li><a href="#" target="_self">迟福林</a></li>
                    <li><a href="#" target="_self">陈传明 </a></li>
                    <li><a href="#" target="_self">陈信元</a></li>
                    <li><a href="#" target="_self">陈光金</a></li>
                    <li><a href="#" target="_self">陈共</a></li>
                    <li><a href="#" target="_self">陈兴良</a></li>
                    <li><a href="#" target="_self">陈利权</a></li>
                    <li><a href="#" target="_self">陈功</a></li>
                    <li><a href="#" target="_self">陈劲</a></li>
                    <li><a href="#" target="_self">陈卫东</a></li>
                    <li><a href="#" target="_self">陈发虎</a></li>
                    <li><a href="#" target="_self">崔传义</a></li>
                </ul>
            </div>
            <div class="division">
                <span>G</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">崔传义</a></li>
                    <li><a href="#" target="_self">崔保山 </a></li>
                    <li><a href="#" target="_self">崔建远</a></li>
                    <li><a href="#" target="_self">崔玉凤</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹凤刚</a></li>
                    <li><a href="#" target="_self">曹凤岐</a></li>
                    <li><a href="#" target="_self">曹小奇</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹普</a></li>
                    <li><a href="#" target="_self">曹淑敏</a></li>
                    <li><a href="#" target="_self">曹顺庆</a></li>

                    <li><a href="#" target="_self">柴发合</a></li>
                    <li><a href="#" target="_self">柴瑜 </a></li>
                    <li><a href="#" target="_self">程会强</a></li>
                    <li><a href="#" target="_self">程卫东</a></li>
                    <li><a href="#" target="_self">程国强</a></li>
                    <li><a href="#" target="_self">程天权</a></li>
                    <li><a href="#" target="_self">程恩富</a></li>
                    <li><a href="#" target="_self">程秀生</a></li>
                    <li><a href="#" target="_self">蔡学军</a></li>
                    <li><a href="#" target="_self">蔡?P</a></li>
                    <li><a href="#" target="_self">蔡洪滨</a></li>
                    <li><a href="#" target="_self">蔡莉</a></li>

                    <li><a href="#" target="_self">迟福林</a></li>
                    <li><a href="#" target="_self">陈传明 </a></li>
                    <li><a href="#" target="_self">陈信元</a></li>
                    <li><a href="#" target="_self">陈光金</a></li>
                    <li><a href="#" target="_self">陈共</a></li>
                    <li><a href="#" target="_self">陈兴良</a></li>
                    <li><a href="#" target="_self">陈利权</a></li>
                    <li><a href="#" target="_self">陈功</a></li>
                    <li><a href="#" target="_self">陈劲</a></li>
                    <li><a href="#" target="_self">陈卫东</a></li>
                    <li><a href="#" target="_self">陈发虎</a></li>
                    <li><a href="#" target="_self">崔传义</a></li>

                    <li><a href="#" target="_self">崔保山</a></li>
                    <li><a href="#" target="_self">崔建远 </a></li>
                    <li><a href="#" target="_self">崔玉凤</a></li>
                    <li><a href="#" target="_self">常纪文</a></li>
                    <li><a href="#" target="_self">曹凤刚</a></li>
                    <li><a href="#" target="_self">曹凤岐</a></li>
                    <li><a href="#" target="_self">曹小奇</a></li>
                    <li><a href="#" target="_self">曹普</a></li>
                    <li><a href="#" target="_self">曹淑敏</a></li>
                    <li><a href="#" target="_self">曹顺庆</a></li>
                    <li><a href="#" target="_self">柴瑜</a></li>
                    <li><a href="#" target="_self">程会强</a></li>
                </ul>
            </div>
            <div class="division">
                <span>H</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>I</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>G</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>K</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>L</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>M</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>N</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>O</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>P</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>Q</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>R</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>S</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>T</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>U</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>V</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>W</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>X</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>Y</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
            <div class="division">
                <span>Z</span>
                <ul class="clearfix ">
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">包思勤</a></li>
                    <li><a href="#" target="_self">卞建林 </a></li>
                    <li><a href="#" target="_self">巴曙松</a></li>
                    <li><a href="#" target="_self">柏良泽</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                    <li><a href="#" target="_self">吉耀 </a></li>
                    <li><a href="#" target="_self">白涛 </a></li>
                    <li><a href="#" target="_self">白重恩</a></li>
                    <li><a href="#" target="_self">薄贵利</a></li>
                </ul>
            </div>
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
<div class="totop" id="backToTop"><img src="images/TOTOP.png" width="59" height="59"/></div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
