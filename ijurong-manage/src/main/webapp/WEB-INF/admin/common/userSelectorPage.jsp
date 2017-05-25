<%--
  Created by IntelliJ IDEA.
  User: Cloud
  Date: 2017/5/22
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div region="center" style="padding: 5px;">
  <div  style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      姓名：<input type="text" id="selectorName">&nbsp;<a href="#"
                                                 class="easyui-linkbutton"
                                                 data-options="iconCls:'icon-search'" onclick="selectorSearch()">查找</a>&nbsp;
    </div>
  </div>
  <table  id="selectorTableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/staff/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'staffName',width:100,align:'center'">姓名</th>
      <th data-options="field:'sex',width:60,formatter:TT.formatSex,align:'center'">性别</th>
      <th data-options="field:'originPlace',width:120,align:'center'">籍贯</th>
      <th data-options="field:'phoneNumber',width:120,align:'center'">电话</th>
    </tr>
    </thead>
  </table>
</div>
<script>
  function selectorSearch() {
    var params = {};
    params.staffName = $('#selectorName').val();
    $('#selectorTableList').datagrid('load', params);
  }
</script>
