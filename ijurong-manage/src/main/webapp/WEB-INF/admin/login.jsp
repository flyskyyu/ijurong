<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skin_/login.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.select.js"></script>
    <style>
        #randomcode_img {
            position: absolute;
            left: 206px;
            width: 105px;
            height: 38px;
            border-radius: 4px;
            cursor: pointer;
        }
        .err_msg {
            top: 325px;
            position: relative;
            left: 144px;
            color: #cc0033;
            font-size: 15px;
        }
    </style>
<title>数字管理系统_用户登录</title>
</head>

<body>
<div id="container">
    <div id="bd">
    	<div id="main">
            <form action="<%=basePath%>admin/loginUrl" method="post">
        	<div class="login-box">
                <div id="logo"></div>
                <h1></h1>
                <div class="input username" id="username">
                    <label for="userName">用户名</label>
                    <span></span>
                    <input type="text" id="userName" name="username"/>
                </div>
                <div class="input psw" id="psw">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="password" name="password"/>
                </div>
                <div class="input validate" id="validate">
                    <label for="valiDate">验证码</label>
                    <input type="text" id="valiDate" name="randomcode"/>
                    <img id="randomcode_img" src="<%=basePath%>validatecode.jsp" alt=""
                            width="56" height="20" align='absMiddle'  onclick="randomcode_refresh()"/>
                </div>
                <div class="err_msg">
                    ${errMsg}
                </div>
                <!--<div class="styleArea">-->
                    <!--<div class="styleWrap">-->
                        <!--<select name="style">-->
                            <!--<option value="默认风格">默认风格</option>-->
                            <!--<option value="红色风格">红色风格</option>-->
                            <!--<option value="绿色风格">绿色风格</option>-->
                        <!--</select>-->
                    <!--</div>-->
                <!--</div>-->
                <div id="btn" class="loginButton">
                    <input type="submit" class="button" value="登录"  />
                </div>
            </div>
            </form>
        </div>
        <div id="ft">CopyRight&nbsp;2017&nbsp;&nbsp;版权所有 &nbsp;&nbsp;苏ICP备00000000号</div>
    </div>
   
</div>
</body>
<script type="text/javascript">
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
        var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
    });
	$('select').select();
	
	/*$('.loginButton').click(function(e) {
        document.location.href = "main.html";
    });*/

    function randomcode_refresh() {
        $('#randomcode_img').attr('src', '<%=basePath%>validatecode.jsp?t=' + new Date().getTime());
   }
</script>
</html>
