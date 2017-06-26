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
<link rel="stylesheet" href="css/css.css" type="text/css" />
</head>
<body>
<div class="nav-bar">
    <div class="welcome"><div class="wel-text">欢迎进入融智库咨询平台！</div></div>
    <!--<hr class="welcom_hr"/>-->
    <div class="header" style="">
        <div class="header-wrap">
            <a href="#" class="logo"><img src="images/LOGO.png" width="72" height="63" border="0"/></a>

            <div class="nav_top">
                <ul>
                   <a href="index.html"><li class="home_nav">智库首页</li></a>
                  <a href="newslist.html"><li class="news_nav">智库要闻</li></a>
                  <a href="#"><li class="report_nav">智库报告</li></a>
                    <a href="expertlist.html"><li class="expert_nav_a">专家库</li></a>
                    <a href="literary.html"><li class="experttxt_nav">专家文章</li></a>
                    <a href="microclass_home.html"><li class="learn_nav">智库微课</li></a>
                    <a href="about us.html"><li class="contact_us_nav">关于我们</li></a>
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
<div class="content_expert">
    <div class="rightsider_tl">
                <span class="newslist_icon"><img src="images/newslisttl.png" width="25" height="25" /></span>
                <span class="newslist_txt">您当前的位置：<a href="#">智库要闻</a> > <a href="#">专家库</a></span>
    </div>
    <div class="leftsider_zj">
          <div class="intr_expert">
            <h1>安同良</h1>
            <span>经济学院副院长   教授</span>
            <img src="images/photo_expert.jpg" width="220" height="270" />
            </div>
            <div class="ex_partook">
                分享到：
                <a href="#"><img src="images/qq.png" width="24" height="24" /></a>
                <a href="#"><img src="images/weixin.png" width="24" height="24" /></a>
                <a href="#"><img src="images/weibo.png" width="24" height="24" /></a>
            </div>
            <div class="expert_menu">
         	<ul>
            	<li><a href="#">个人简历</a></li>
                <li><a href="#">研究领域</a></li>
                <li><a href="#">教育背景</a></li>
                <li><a href="#">学术兼职</a></li>
                <li><a href="#">社会荣誉</a></li>
                <li><a href="#">研究成果</a></li>
                <li><a href="#">他的微课</a></li>
                <li><a href="#">联系方式</a></li>
            </ul>
         </div>
         </div>
         <div class="rightsider_zj">
         	<dl>
            	<dt>所属机构</dt>
                <dd>南京大学</dd>
            </dl>
            <Dl>
            	<dt>个人简历</dt>
                <dd>教授，博士生导师，中国生产力学会理事。</dd>
                <dd>长期为政府与企业提供咨询，成功地主持咨询项目近30项。</dd>
            </Dl>
           <dl>
           		<Dt>研究领域</Dt>
                <dd>产业经济学、演化经济学、行为经济学、公司战略经济学、证券投资</dd>
           </dl>
           <dl>
           		<dt>学术兼职</dt>
                <dd>中国生产力学会理事</dd>
                <dd>《经济研究》匿名审稿人</dd>
                <dd>江苏舜天股份有限公司外部监事</dd>
                <dd>南京栖霞建设股份有限公司独立董事</dd>
           </dl>
           <dl>
           		<dt>社会荣誉</dt>
                <dd>2005年 教育部"新世纪优秀人才支持计划"获得者</dd>
                <dd>2013年 江苏省第四期"333高层次人才培养工程"第二层次培养对象</dd>
                <dd>2014年 教育部长江学者特聘教授</dd>
                <dd>2014年 享受政府特殊津贴人员</dd>
           </dl>
           <Dl>
           		<dt>研究成果</dt>
                <dd>论文：</dd>
           </Dl>
           <ol type="1">
           		<li> 安同良、千慧雄, 2014年, 《中国居民收入差距变化对企业产品创新的影响机制研究》,      《经济研究》 第9期	</li>
                <li>沈于、安同良, 2012年, 《再集成：一种"模块化陷阱"》, 《中国工业经济》 第2期 </li>
                <li>刘瑞祥、安同良, 2012年, 《资源环境约束下中国经济增长绩效变化趋势与因素分析》, 
        <<经济研究>> 第11期 </li>
        		<li> Liu Ruixiang and An Tongliang, 2012, The Transition of Growth Drivers and
        Derivative Effects of Final Demand on China's Economic Expansion, China 
        Economist Volume 7,Number1 </li>
        		<li> 安同良、刘伟伟、田莉娜, 2011年, 《中国长江三角洲地区技术转移的渠道分析》, 
       《南京大学学报》 第4期 被人大复印资料《创新政策与管理》2011年第11期全文转载 </li>
                <li>刘瑞翔、安同良, 2011年, 《中国经济增长的动力来源与转换展望》, 《经济研究》 第7期</li>
                <li>安同良、周绍东、皮建才, 2009年, 《R&D补贴对中国企业自主创新的激励效应》, 
       《经济研究》 第10期 被人大复印资料<<创新政策与管理>>2010年第1期全文转载 </li>
                <li>Ludovico Alcorta Branka Urem An Tongliang, 2008, Do Manufacturing Firms in 
        China Innovate?, Journal of Contemporary Asia 4 issue SSCI </li>
                <li>安同良、卞加振、陆国庆, 2007年7月, 《中国工业反哺农业的机制与模式：微观行为
        主体的视角》, 《经济研究》 </li>
                <li> 安同良、施浩 Ludovico Alcorta, 2006年2月, 《中国制造业企业R&D行为模式的观
          测与实证》, 《经济研究》 </li>
                <li> LI KE AN TONGLIANG, 2004.9, CHINESE INDUSTRIAL POLICY AND THE REDU
          CTION OF STATE_OWNED SHARES, Pacific Economic Review SSCI </li>
                <li>安同良, 2003年7月, 《中国企业的技术选择》, 《经济研究》 </li>
                <li>  安同良、杨羽云, 2002年6月, 《易发生价格竞争的产业特征及其企业策略》, 《经济
          研究》 </li>
                <li> 安同良、张金华, 2002年3月, 《中国上市公司国有股减持的行业次序》, 《经济社会
          体制比较》 </li>
                <li>安同良、郑江淮, 2002年3月, 《后现代企业理论的兴起》, 《经济理论与经济管理》 </li>
                <li> Ludovico Alcorta Mark Tomlinson An Tong Liang, , Knowledge Generation 
          and Innovation in Manufacturing Firms in China, Industry and Innovation 
          (SSCI) Vol.16, Nos.4-5,435-461,2009</li>
          </ol>
          		<dl>
                <Dd>著作：</Dd>
                </dl>
                <ol type="1">
                <li>  安同良、葛扬、皮建才主编, 2011年5月, 《国家经济学基础人才培养基地2010年学生
        优秀论文集》, 南京大学出版社</li>
                <li> 安同良、王磊、田莉娜、刘伟伟, 2011年11月, <<长三角地区研发的行为模式与技术
        转移问题研究>>, 经济科学出版社 </li>
                <li> 李晓蓉、李群、安同良, 2010年, 《中国产业经济学前沿》, 南京大学出版社 </li>
                <li>刘志彪、安同良等, 2009年6月, 《现代产业经济分析》（第三版）, 南京大学出版社 </li>
                <li> 安同良, 2004年, 《企业技术能力发展论》, 人民出版社 </li>
                <li> 刘志彪、安同良、王国生, 2001年, 现代产业经济分析, 南京大学出版社</li>
           </ol>
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
<div class="totop" id="backToTop"><img src="images/TOTOP.png" width="59" height="59"/></div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
