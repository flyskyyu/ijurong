<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skin_/nav.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/global.js"></script>
<title>底部内容页</title>
</head>

<body>
<div id="container">
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
            <i class="sidebar-hide"></i>
            <h2><a href="javascript:;"><i class="h2-icon" title="切换到树型结构"></i><span>管理平台</span></a></h2>
            <ul class="nav" id="nav_platformManage">
                <li class="nav-li  current">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">新闻管理</span></a>
                    <ul class="subnav  current">
						<li class="subnav-li" href="index" data-id="1"style="display: none" ><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">首页</span></a></li>
						<li class="subnav-li" href="news/newsPrograma" data-id="2"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新闻栏目管理</span></a></li>
						<li class="subnav-li" href="news/newsSpecial" data-id="3"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新闻专题管理</span></a></li>
						<li class="subnav-li" href="news/news" data-id="4"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新闻管理</span></a></li>
					</ul>
                </li>
                <li class="nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">通知公告</span></a>
                	<ul class="subnav">
						<li class="subnav-li"  href="message/messageType" data-id="5"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">通知类型定义</span></a></li>
                        <li class="subnav-li" href="message/message" data-id="6"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">发送通知公告</span></a></li>
                    </ul>
                </li>
                <%--<li class="nav-li">--%>
                	<%--<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">党务公开</span></a>--%>
                    <%--<ul class="subnav">--%>
                    	<%--<li class="subnav-li" data-id="7"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党务公开</span></a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li class="nav-li last-nav-li">--%>
                	<%--<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">网上办事</span></a>--%>
                    <%--<ul class="subnav">--%>
                    	<%--<li class="subnav-li" data-id="12"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">事项管理</span></a></li>--%>
                        <%--<li class="subnav-li" data-id="13"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">待审核</span></a></li>--%>
                        <%--<li class="subnav-li" data-id="14"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">归档管理</span></a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>

				<li class="nav-li last-nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">APP管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="appSet/appShufflingPic" data-id="17"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">app轮播图</span></a></li>
						<li class="subnav-li" href="appSet/appSkins" data-id="18"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">app皮肤上传</span></a></li>
						<li class="subnav-li" href="appSet/appSkinVersion" data-id="19"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">皮肤版本发布</span></a></li>
					</ul>
				</li>

				<%--<li class="nav-li">--%>
					<%--<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">参考页</span></a>--%>
					<%--<ul class="subnav">--%>
						<%--<li class="subnav-li" href="index.html" data-id="8"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">参考1</span></a></li>--%>
						<%--<li class="subnav-li" href="form.html" data-id="9"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">参考2</span></a></li>--%>
						<%--<li class="subnav-li" href="table.html" data-id="10"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">参考3</span></a></li>--%>
						<%--<li class="subnav-li" data-id="11"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">自定义设置1</span></a></li>--%>
					<%--</ul>--%>
				<%--</li>--%>
            </ul>

			<%--<ul class="nav" id="nav_officialManage" style="display: none;">--%>
				<%--<li class="nav-li">--%>
					<%--<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">公文管理</span></a>--%>
					<%--<ul class="subnav">--%>
						<%--<li class="subnav-li" href="platformManage/news" data-id="22"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新闻管理</span></a></li>--%>
						<%--<li class="subnav-li" href="platformManage/news_type" data-id="23"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">新闻分类管理</span></a></li>--%>
					<%--</ul>--%>
				<%--</li>--%>
			<%--</ul>--%>

			<ul class="nav" id="nav_companyManage" style="display: none;">
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">单位支部管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="company/enterpriseInfo" data-id="32"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">单位管理</span></a></li>
						<li class="subnav-li" href="company/party" data-id="33"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">支部管理</span></a></li>
					</ul>
				</li>
				<li class="nav-li current">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">志愿者管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="company/volunteer"  data-id="34"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">志愿者管理</span></a></li>
					</ul>
				</li>
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">组织活动</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="activity/listPage" data-id="35"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">活动管理</span></a></li><!--党建专题活动-->
						<%--<li class="subnav-li" data-id="36"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教育教学活动</span></a></li>--%>
						<%--<li class="subnav-li" data-id="37"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">志愿者活动</span></a></li>--%>
					</ul>
				</li>
				<%--<li class="nav-li last-nav-li">--%>
					<%--<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">教学资源</span></a>--%>
					<%--<ul class="subnav">--%>
						<%--<li class="subnav-li" href="company/resourceType"  data-id="38"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教学类型定义</span></a></li>--%>
						<%--<li class="subnav-li" data-id="39"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">教学资源管理</span></a></li>--%>
					<%--</ul>--%>
				<%--</li>--%>
			</ul>

			<ul class="nav" id="nav_partyMemberManage" style="display: none;">
				<li class="nav-li  current">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">党员信息管理</span></a>
					<ul class="subnav  current">
						<li class="subnav-li" href="member/listPage" data-id="41"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党员信息查询</span></a></li>
						<li class="subnav-li" href="" data-id="42"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党费收缴管理</span></a></li>
						<li class="subnav-li" href="memberServe/listPage" data-id="43"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">党员服务记录</span></a></li>
						<li class="subnav-li" href="excellentMember/listPage" data-id="44"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">优秀党员管理</span></a></li>
						<li class="subnav-li" href="hardMemberApply/listPage" data-id="45"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">困难/老党员申请</span></a></li>
					</ul>
				</li>
			</ul>

			<ul class="nav" id="nav_interactiveManage" style="display: none;">
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">互动交流</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="interactive/panelDiscussion" data-id="52"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">论坛管理</span></a></li>
						<li class="subnav-li" href="reply/listPage" data-id="51"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">评论管理</span></a></li>
					</ul>
				</li>
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">调查问卷</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="exam/examQuestion" data-id="53"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">题库管理</span></a></li>
						<li class="subnav-li" href="exam/research" data-id="54"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">问卷管理</span></a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav" id="nav_itemManage" style="display: none;">
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">物品管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="/admin/item/listPage" data-id="61"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">物品管理</span></a></li>
						<li class="subnav-li" href="/admin/itemReceive/listPage" data-id="62"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">物品申领</span></a></li>
						<li class="subnav-li" href="/admin/facility/listPage" data-id="63"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">设施管理</span></a></li>
					</ul>
				</li>
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">车辆管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="/admin/car/listPage" data-id="71"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">车辆管理</span></a></li>
						<li class="subnav-li" href="/admin/carOrder/calendarListPage" data-id="72"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">车辆预定</span></a></li>
					</ul>
				</li>
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">会议室管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="/admin/meetingRoom/listPage" data-id="81"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">会议室管理</span></a></li>
						<li class="subnav-li" href="/admin/meetingRoomOrder/calendarListPage" data-id="82"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">会议室预约</span></a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav" id="nav_systemManage" style="display: none;">
				<li class="nav-li">
					<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">权限管理</span></a>
					<ul class="subnav">
						<li class="subnav-li" href="/admin/role/listPage" data-id="91"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">角色管理</span></a></li>
						<li class="subnav-li" href="/admin/permission/listPage" data-id="92"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">权限管理</span></a></li>
						<li class="subnav-li" href="/admin/staffRole/listPage" data-id="93"><a href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span class="subnav-text">授权管理</span></a></li>
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
<script type="text/javascript" src="<%=basePath%>js/nav.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Menu.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect: $('.nav').find('li[data-id="1"]')	
	});
	
	// 左侧树结构加载
	var setting = {};

		var zNodes =[
			{ name:"新闻管理",
			   children: [
				 { name:"新闻视频管理",icon:'/img/skin_/leftlist.png'},
				 { name:"新闻频道管理",icon:'/img/skin_/leftlist.png'},
				 { name:"地方新闻管理",icon:'/img/skin_/leftlist.png'}
			]},
			{ name:"用户信息设置", open:true,
			   children: [
				 { name:"首页", checked:true,icon:'/img/skin_/leftlist.png'},
				 { name:"表单",icon:'/img/skin_/leftlist.png'},
				 { name:"表格",icon:'/img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'/img/skin_/leftlist.png'}
			]},
			{ name:"工作安排",
			   children: [
				 { name:"工作安排",icon:'/img/skin_/leftlist.png'},
				 { name:"安排管理",icon:'/img/skin_/leftlist.png'},
				 { name:"类型选择",icon:'/img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'/img/skin_/leftlist.png'}
			]},
			{ name:"数据管理",
			   children: [
				 { name:"工作安排",icon:'/img/skin_/leftlist.png'},
				 { name:"安排管理",icon:'/img/skin_/leftlist.png'},
				 { name:"类型选择",icon:'/img/skin_/leftlist.png'},
				 { name:"自定义设置",icon:'/img/skin_/leftlist.png'}
			]}
		];

	//$.fn.zTree.init($(".tree"), setting, zNodes);
	
	
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
