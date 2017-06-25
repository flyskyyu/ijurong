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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skin_/main.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery.dialog.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/global.js"></script>
<title>数字管理系统</title>
</head>

<body>
<div id="container">
	<div id="hd">
    	<div class="hd-top">
            <h1 class="logo">
                <!--<a href="javascript:;" class="logo-icon"></a>-->
            </h1>
            <div class="user-info">
                <a href="javascript:;" class="user-avatar">
                    <span><i class="info-num">0</i></span>
                </a>
                <span class="user-name">admin</span>
                <a href="javascript:;" class="more-info"></a>
            </div>
            <div class="setting ue-clear">
            	<!--<div class="setting-skin">-->
                	<!--<div class="switch-bar">-->
                    	<!--<i class="skin-icon"></i>-->
                        <!--<span class="text">皮肤</span>-->
                        <!--<i class="arrow-icon"></i>-->
                    <!--</div>-->
                <!--</div>-->
                <ul class="setting-main ue-clear">
                	<li><a href="javascript:;">桌面</a></li>
                    <li><a href="javascript:;">设置</a></li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li><a href="javascript:;" class="close-btn exit"></a></li>
                </ul>
            </div>
        </div>
        <div class="hd-bottom">
        	<i class="home"><a href="javascript:;"></a></i>
        	<div class="nav-wrap">
                <ul class="nav ue-clear" id="topMenu">
                    <li><a href="javascript:;" id="platformManage">平台管理</a></li>
                    <%--<li><a href="javascript:;" id="officialManage">公文流转</a></li>--%>
                    <li><a href="javascript:;" id="companyManage">单位支部</a></li>
                    <li><a href="javascript:;" id="partyMemberManage">党员服务</a></li>
                    <li><a href="javascript:;" id="interactiveManage">互动交流</a></li>
                    <li><a href="javascript:;" id="itemManage">物品管理</a></li>
                    <li><a href="javascript:;" id="systemManage">系统管理</a></li>
                </ul>
            </div>
            <div class="nav-btn">
            	<a href="javascript:;" class="nav-prev-btn"></a>
                <a href="javascript:;" class="nav-next-btn"></a>
            </div>
        </div>
    </div>
    <div id="bd">
        <iframe width="100%" height="100%" id="mainIframe" src="menu" frameborder="0"></iframe>
    </div>

    <div id="ft" class="ue-clear">
    	<div class="ft1 ue-clear">
        	<i class="ft-icon1"></i>
            <span>数字管理系统</span>
            <em>Digital Pertal</em>
        </div>
        <div class="ft2 ue-clear">
        	<span>Call Center</span>
            <em>V2.0 2014</em>
            <i class="ft-icon2"></i>
        </div>
    </div>
</div>

<div class="exitDialog" style="display:none;">
	<div class="content">
    	<div class="ui-dialog-icon"></div>
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>

            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>

    </div>
</div>

<div class="opt-panel user-opt" style="top:52px;left:330px;">
	<ul>
    	<li><a class="text">用户资料</a></li>
        <li><a class="text">短消息<span class="num">(2)</span></a></li>
        <li><a class="text">资料信息</a></li>
        <li><a class="text">注销</a></li>
        <li><a class="text">自定义</a></li>
    </ul>
    <div class="opt-panel-tl"></div>
    <div class="opt-panel-tc"></div>
    <div class="opt-panel-tr"></div>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bl"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-arrow"></div>
</div>

</body>
<script type="text/javascript" src="<%=basePath%>js/core.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.dialog.js"></script>
<script type="text/javascript" src="<%=basePath%>js/myMenu.js"></script>
<script type="text/javascript">
    var menus = JSON.parse('${menus}');
    menuGenerator.init(menus);
    menuGenerator.generateMain();
$("#bd").height($(window).height()-$("#hd").outerHeight()-26);

$(window).resize(function(e) {
    $("#bd").height($(window).height()-$("#hd").outerHeight()-26);

});

$('.exitDialog').Dialog({
	title:'提示信息',
	autoOpen: false,
	width:400,
	height:200
});

$('.exit').click(function(){
	$('.exitDialog').Dialog('open');
});

$('.exitDialog input[type=button]').click(function(e) {
    $('.exitDialog').Dialog('close');
	
	if($(this).hasClass('ok')){
		window.location.href = "<%=basePath%>admin/logout"	;
	}
});

(function(){
	var totalWidth = 0, current = 1;
	
	$.each($('.nav').find('li'), function(){
		totalWidth += $(this).outerWidth();
	});
	
	$('.nav').width(totalWidth);
	
	function currentLeft(){
		return -(current - 1) * 93;	
	}
	
	$('.nav-btn a').click(function(e) {
		var tempWidth = totalWidth - ( Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width() );
        if($(this).hasClass('nav-prev-btn')){
			if( parseInt($('.nav').css('left').split('p')[0]) < 0){
				current--;
				Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': 0}, 200);
			}
		}else{

			if(tempWidth  > 0)	{
				
			   	current++;
				tempWidth > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': $('.nav').css('left').split('p')[0]-tempWidth}, 200);
			}
		}
    });
	
	
	
	$.each($('.skin-opt li'),function(index, element){
		if((index + 1) % 3 == 0){
			$(this).addClass('third');	
		}
		$(this).css('background',$(this).attr('attr-color'));
	});
	
	$('.setting-skin').click(function(e) {
        $('.skin-opt').show();
    });
	
	$('.skin-opt').click(function(e) {
        if($(e.target).is('li')){
			alert($(e.target).attr('attr-color'));	
		}
    });
	
	$('.hd-top .user-info .more-info').click(function(e) {
       $(this).toggleClass('active'); 
	   $('.user-opt').toggle();
    });
	
	$('.logo-icon').click(function(e) {
         $(this).toggleClass('active'); 
	     $('.system-switch').toggle();
    });

    $('#topMenu').on('click', 'a', function() {
        var id = $(this).attr('id');
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        var subId = '#nav_' + id;
        $($('#mainIframe')[0].contentWindow.document).find(subId).show();
    });

    $('#platformManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_platformManage").show()
    });
    $('#officialManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_officialManage").show()
    });
    $('#companyManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_companyManage").show()
    });
    $('#partyMemberManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_partyMemberManage").show()
    });
    $('#interactiveManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_interactiveManage").show()
    });
    $('#itemManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_itemManage").show()
    });
    $('#systemManage').click(function()
    {
        $($('#mainIframe')[0].contentWindow.document).find(".nav").hide();
        $($('#mainIframe')[0].contentWindow.document).find("#nav_systemManage").show()
    });
	hideElement($('.user-opt'), $('.more-info'), function(current, target){

		$('.more-info').removeClass('active'); 
	});
	
	hideElement($('.skin-opt'), $('.switch-bar'));
	
	hideElement($('.system-switch'), $('.logo-icon'), function(current, target){

		$('.logo-icon').removeClass('active'); 
	});
})();

</script>
</html>
