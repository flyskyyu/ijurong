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
    <link rel="stylesheet" href="/css/css.css" type="text/css"/>
</head>
<script type="text/javascript" src="/js/lrtk.js"></script>
<!--[if lt IE 8]>
<style type="text/css">
  .pagewrap{display:none;}
  .comp_ie{display:block;}
</style>
<![endif]-->

<body>

<div class="nav-bar">
    <div class="welcome"><div class="wel-text">欢迎进入开发区党建平台！</div></div>
    <!--<hr class="welcom_hr"/>-->
    <div class="header" style="">
        <div class="header-wrap">
            <a href="#" class="logo"><img src="/images/LOGO.png" width="72" height="63" border="0"/></a>

            <div class="nav_top">
                <ul>
                   <a href="index.html"><li class="home_nav_a">党建首页</li></a>
       	      		<a href="newslist.html"><li class="news_nav">党建要闻</li></a>
                    <a href="reportlist.html"><li class="report_nav">党建快报</li></a>
                    <a href="expertlist.html"><li class="expert_nav">优秀党员</li></a>
                    <a href="about us.html"><li class="contact_us_nav">联系我们</li></a>
                    <div class="sreach_icon" active="off" id="navSearch">
                    <img src="/images/sreach.png" width="40"height="34"/>
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

<div class="banner"> 
	<div id="playBox">
    <div class="pre"></div>
    <div class="next"></div>
    <div class="smalltitle">
      <ul>
        <li class="thistitle"></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
    <ul class="oUlplay">
       <li><a href="#" target="_self"><img src="/images/banner.png" width="1200" /></a></li>
       <li><a href="#" target="_self"><img src="/images/2.jpg" width="1200"  /></a></li>
       <li><a href="#" target="_self"><img src="/images/3.jpg" width="1200"  /></a></li>
       <li><a href="#" target="_self"><img src="/images/4.jpg"  width="1200" /></a></li>
       <li><a href="#" target="_self"><img src="/images/5.jpg"  width="1200" /></a></li>
       <li><a href="#" target="_self"><img src="/images/6.jpg"  width="1200" /></a></li>
    </ul>
  </div></div>
<div class="news">
    <div class="news_left">
        <div class="title_list">
            <span class="title_icon"><img src="/images/news_icon.jpg" width="31" height="31"/></span>
            <span class="title_txt">最新发布</span>
        </div>
        <Div class="tuwen">
            <Dl>
                <img src="/images/img01.png" width="170" height="133"/>
                <Dt>秋石：</Dt>
                <dd>谱写全面从严治党新篇章</dd>
                在我国持续30年的经济高速增长阶段
                从农村到城市的劳动力和土地 再配置
                发挥了重要支撑作用。随着工业化城
                镇化的发展，农业劳动边际生产率和农民工工资水平开始上升， 劳
                动力从农村向城市的再配置对提高全社会劳在我国持续 30年的经济
                高速增长阶段 ，从农村到城市的劳动力和土地再配置发续30年的经
                济高速增长阶段......
            </Dl>
        </Div>
    </div>
    <div class="news_right">
        <ul>
            <li><strong>[党建要闻]</strong><a href="#">重建应用研究体系，促进企业创新发展,12月16日，由工业和信息化部、国家发展和改革委员...</a></li>
            <li><a href="#">近日，"民银智库50人论坛成立大会暨中国民生银行改革创新研讨会"在北京举行北京大学...</a></li>
            <li><a href="#">岁末年初的经济点评与展望像是每年定期的必修课，经济学家往往乐此不疲。近两年我每年...</a></li>
            <li><strong>[党建要闻]</strong><a href="#">进入新常态之后，我国人口的空间布局随着经济活动空间布局的调整出现了新的变化趋势...</a></li>
            <li><a href="#">由中国国际经济交流中心和新华社国家高端智库联合主办的"2016－2017中国经济年会"17...</a></li>
            <li><strong>[党建要闻]</strong><a href="#">近日闭幕的中央经济工作会议提出，2017年是实施"十三五"规划的重要一年，是供给侧结...</a></li>
            <li><a href="#">在我国持续30年的经济高速增长阶段，从农村到城市的劳动力和土地再配置发挥了重要支撑...</a></li>
            <li><strong>[党建要闻]</strong><a href="#">重建应用研究体系，促进企业创新发展,12月16日，由工业和信息化部、国家发展和改革委员...</a></li>
            <li><strong>[党建要闻]</strong><a href="#">重建应用研究体系，促进企业创新发展,12月16日，由工业和信息化部、国家发展和改革委员...</a></li>
        </ul>
    </div>
</div>
<Div class="expert">
    <ul>
        <li class="expert_tl">
            <h3><strong>Excellent</strong></h3>

            <h3>优秀党员</h3>
            <span class="expert_more"><a href="#">优秀共产党员 ></a></span>
        </li>
        <li class="expert_cont"><img src="/images/photo4.png" width="220" height="270"/>

            <Div class="mask">
                <dl>
                    <dt>习近平</dt>
                    <dd>国家主席</dd>
                </dl>
            </Div>
        </li>
        <li class="expert_cont"><img src="/images/photo3.png" width="220" height="270"/>

            <Div class="mask">
                <dl>
                     <dt>习近平</dt>
                    <dd>国家主席</dd>
                </dl>
            </Div>
        </li>
        <li class="expert_cont"><img src="/images/photo2.png" width="220" height="270"/>

            <Div class="mask">
                <dl>
                     <dt>习近平</dt>
                    <dd>国家主席</dd>
                </dl>
            </Div>
        </li>
        <li class="expert_cont"><img src="/images/photo1.png" width="220" height="270"/>

            <Div class="mask">
                <dl>
                     <dt>习近平</dt>
                    <dd>国家主席</dd>
                </dl>
            </Div>
        </li>
    </ul>
</Div>
<div class="Micro_Learn_tl">
    <span>党建快报</span>
</div>
<Div class="Micro_Learn">
    <ul>
        <li>
        	<figure class="thumbnail">
            <A href="microclass_home.html"><img src="/images/img_learn.png" width="352" height="227"/></A>
          </figure>
            <dl>
                <dt><a href="microclass_home.html">C语言程序设计精髓</a></dt>
                <Dd>黄群慧</Dd>
                <p>学习程序设计是一件充满挑战、更充满乐趣的事情，然而学习之初，它之所以给你枯燥乏味的感觉，那是因为没有发掘出它的趣味来
                    本课程力图用最简明的语言、最典型的实例及最通俗的解释将这种趣味性挖掘出来，带给你全新的学习体验，和你一起欣赏C 语言之
                    美，领悟C语言之妙，体会学习C语言之无穷乐趣。对于这个地球上大多数人来说，真正的数字化革命还没有开始。在接下来的1年里
                    变化将无处不在，让我们一起来给这个世界编码吧！
                </p>
                <span class="time">4个小时</span><span class="key">关键词： C语言  程序  </span>
            </dl>
        </li>
        <li>
        	<figure class="thumbnail">
            <A href="#"><img src="/images/img_learn2.png" width="352" height="227"/></A>
            </figure>
            <dl>
                <dt><a href="#">预防医学（一）</a></dt>
                <Dd>黄群慧</Dd>
                <p>学习程序设计是一件充满挑战、更充满乐趣的事情，然而学习之初，它之所以给你枯燥乏味的感觉，那是因为没有发掘出它的趣味来
                    本课程力图用最简明的语言、最典型的实例及最通俗的解释将这种趣味性挖掘出来，带给你全新的学习体验，和你一起欣赏C 语言之
                    美，领悟C语言之妙，体会学习C语言之无穷乐趣。对于这个地球上大多数人来说，真正的数字化革命还没有开始。在接下来的1年里
                    变化将无处不在，让我们一起来给这个世界编码吧！
                </p>
                <span class="time">4个小时</span><span class="key">关键词： C语言  程序  </span>
            </dl>
        </li>
        <li>
        	<figure class="thumbnail">
            <A href="#"><img src="/images/img_learn3.png" width="352" height="227"/></A>
            </figure>
            <dl>
                <dt><a href="#">手把手教你心理咨询：谈话的艺术</a></dt>
                <Dd>黄群慧</Dd>
                <p>学习程序设计是一件充满挑战、更充满乐趣的事情，然而学习之初，它之所以给你枯燥乏味的感觉，那是因为没有发掘出它的趣味来
                    本课程力图用最简明的语言、最典型的实例及最通俗的解释将这种趣味性挖掘出来，带给你全新的学习体验，和你一起欣赏C 语言之
                    美，领悟C语言之妙，体会学习C语言之无穷乐趣。对于这个地球上大多数人来说，真正的数字化革命还没有开始。在接下来的1年里
                    变化将无处不在，让我们一起来给这个世界编码吧！
                </p>
                <span class="time">4个小时</span><span class="key">关键词： C语言  程序  </span>
            </dl>
        </li>
        <li>
        	<figure class="thumbnail">
            <A href="#"><img src="/images/img_learn4.png" width="352" height="227"/></A>
            </figure>
            <dl>
                <dt><a href="#">概率论与数理统计</a></dt>
                <Dd>黄群慧</Dd>
                <p>学习程序设计是一件充满挑战、更充满乐趣的事情，然而学习之初，它之所以给你枯燥乏味的感觉，那是因为没有发掘出它的趣味来
                    本课程力图用最简明的语言、最典型的实例及最通俗的解释将这种趣味性挖掘出来，带给你全新的学习体验，和你一起欣赏C 语言之
                    美，领悟C语言之妙，体会学习C语言之无穷乐趣。对于这个地球上大多数人来说，真正的数字化革命还没有开始。在接下来的1年里
                    变化将无处不在，让我们一起来给这个世界编码吧！
                </p>
                <span class="time">4个小时</span><span class="key">关键词： C语言  程序  </span>
            </dl>
        </li>
        <li>
        	<figure class="thumbnail">
            <A href="#"><img src="/images/img_learn5.png" width="352" height="227"/></A>
            </figure>
            <dl>
                <dt><a href="#">民族声乐进阶密码――石春轩子教学示范课堂</a></dt>
                <Dd>黄群慧</Dd>
                <p>学习程序设计是一件充满挑战、更充满乐趣的事情，然而学习之初，它之所以给你枯燥乏味的感觉，那是因为没有发掘出它的趣味来
                    本课程力图用最简明的语言、最典型的实例及最通俗的解释将这种趣味性挖掘出来，带给你全新的学习体验，和你一起欣赏C 语言之
                    美，领悟C语言之妙，体会学习C语言之无穷乐趣。对于这个地球上大多数人来说，真正的数字化革命还没有开始。在接下来的1年里
                    变化将无处不在，让我们一起来给这个世界编码吧！
                </p>
                <span class="time">4个小时</span><span class="key">关键词： C语言  程序  </span>
            </dl>
        </li>

    </ul>
</Div>
<div class="learn_more">
    <a href="class_list.html">更多党建快报 ></a></div>
<div class="footer"><p>2007-2014版权所有</p>

    <p>Tel: 123123123 Email: service@123.comQQ: 123123</p>

    <p>Web: www.123.com</p></div>
<div class="footer_menu">
    <a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#">商务合作</a>|<a href="#">其他</a> Copyright2000-2014 
    Co.,Ltd
</div>
<div class="erweima1"></div>
<!--<div class="erweima"><img src="/images/erweima.png" width="164" height="208"/></div>
--><div class="totop" id="backToTop"><img src="/images/TOTOP.png" width="59" height="59"/></div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>
