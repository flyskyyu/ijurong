<%--
  Created by IntelliJ IDEA.
  User: Cloud
  Date: 2017/5/19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>easyui/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/base.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/basic_info.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/custom.css" />
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>

<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>--%>
<%--<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>--%>
<script>
  $( document ).ajaxComplete(function( event, xhr, settings ) {
    // session过期的情况
    if(xhr.status == 401) {
      window.parent.parent.parent.location.href = '<%=basePath%>admin/login';
    }
  });
</script>

