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
<script type="text/javascript" src="<%=basePath%>easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
