<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <link rel="stylesheet" href="../css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="../css/skin_/nav.css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/global.js"></script>
    <title>底部内容页</title>
</head>

<body>
<div id="container">
    <div id="bd">
        <div class="sidebar">
            <div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href="javascript:;"><i class="h2-icon" title="切换到树型结构"></i><span>平台管理</span></a></h2>
            <ul class="nav">
                <li class="nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">党员管理</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" href="news/news.html" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党员信息管理</span></a></li>
                        <li class="subnav-li" href="news/news.html" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">优秀党员管理</span></a></li>
                        <li class="subnav-li" href="news/news.html" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党费收缴管理</span></a></li>
                    </ul>
                </li>
                <li class="nav-li current">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">党员慰问</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">困难及老党员慰问</span></a></li>
                        <li class="subnav-li" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党员回馈</span></a></li>
                    </ul>
                </li>
                <li class="nav-li">
                    <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">党员考核</span></a>
                    <ul class="subnav">
                        <li class="subnav-li" data-id="5"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党员考核</span></a></li>
                        <li class="subnav-li" data-id="5"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党员积分</span></a></li>
                    </ul>
                </li>
            </ul>
            <div class="tree-list outwindow">
                <div class="tree ztree"></div>
            </div>
        </div>
        <div class="main">
            <div class="title">
                <i class="sidebar-show"></i>
                <ul class="tab ue-clear">

                </ul>
                <i class="tab-more"></i>
                <i class="tab-close"></i>
            </div>
            <div class="content">
            </div>
        </div>
    </div>
</div>

<div class="more-bab-list">
    <ul></ul>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-bl"></div>
</div>
</body>
<script type="text/javascript" src="../js/nav.js"></script>
<script type="text/javascript" src="../js/Menu.js"></script>
<script type="text/javascript" src="../js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">

    // 左侧树结构加载
    var setting = {};

    var zNodes =[
        { name:"新闻管理",
            children: [
                { name:"新闻视频管理",icon:'img/skin_/leftlist.png'},
                { name:"新闻频道管理",icon:'img/skin_/leftlist.png'},
                { name:"地方新闻管理",icon:'img/skin_/leftlist.png'}
            ]},
        { name:"用户信息设置", open:true,
            children: [
                { name:"首页", checked:true,icon:'img/skin_/leftlist.png'},
                { name:"表单",icon:'img/skin_/leftlist.png'},
                { name:"表格",icon:'img/skin_/leftlist.png'},
                { name:"自定义设置",icon:'img/skin_/leftlist.png'}
            ]},
        { name:"工作安排",
            children: [
                { name:"工作安排",icon:'img/skin_/leftlist.png'},
                { name:"安排管理",icon:'img/skin_/leftlist.png'},
                { name:"类型选择",icon:'img/skin_/leftlist.png'},
                { name:"自定义设置",icon:'img/skin_/leftlist.png'}
            ]},
        { name:"数据管理",
            children: [
                { name:"工作安排",icon:'img/skin_/leftlist.png'},
                { name:"安排管理",icon:'img/skin_/leftlist.png'},
                { name:"类型选择",icon:'img/skin_/leftlist.png'},
                { name:"自定义设置",icon:'img/skin_/leftlist.png'}
            ]}
    ];

    $.fn.zTree.init($(".tree"), setting, zNodes);


    $('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
        $('.nav').toggleClass('outwindow');
    });

    $(document).click(function(e) {
        if(!$(e.target).is('.tab-more')){
            $('.tab-more').removeClass('active');
            $('.more-bab-list').hide();
        }
    });
</script>
</html>
