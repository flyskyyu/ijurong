<%--
  Created by IntelliJ IDEA.
  User: Cloud
  Date: 2017/5/19
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<html>
<head>
    <title>党员查询</title>
    <jsp:include page="../contentHeader.jsp"/>
</head>
<body>
<table class="easyui-datagrid" id="itemList" title="党员信息列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'<%=basePath%>admin/member',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
    </tr>
    </thead>
</table>
</body>
</html>
