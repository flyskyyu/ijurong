<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>后台帐号管理</title>
  <jsp:include page="../contentHeader.jsp"/>
  <script type="text/javascript" src="<%=basePath%>resource/jqueryFileUpload/js/vendor/jquery.ui.widget.js"></script>
  <script type="text/javascript" src="<%=basePath%>resource/jqueryFileUpload/js/jquery.iframe-transport.js"></script>
  <script type="text/javascript" src="<%=basePath%>resource/jqueryFileUpload/js/jquery.fileupload.js"></script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="search_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      设施名称：<input type="text" id="nameFilter">&nbsp;
      所属支部：<select class="easyui-combobox" id="branchFilter">
      <c:forEach var="branch" items="${sessionScope.USER_KEY.branchInfos}">
        <option value="${branch.id}">${branch.organizationName}</option>
      </c:forEach>
    </select>&nbsp;&nbsp;&nbsp;
      设施类型：<select class="easyui-combobox" id="typeFilter">
        <option>所有</option>
      <option value="1">会议室设施</option>
      <option value="2">随车物品</option>
    </select>&nbsp;&nbsp;&nbsp;
      <a href="#" class="easyui-linkbutton" id="btn_Search"
                                                 data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <shiro:hasPermission name="facility:add">
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      </shiro:hasPermission>
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
    </div>
  </div>
  <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/facility/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'name',width:100,align:'center'">设施名称</th>
      <th data-options="field:'num',width:60,align:'center'">设施数量</th>
      <th data-options="field:'type',width:60,align:'center',formatter:formatType">设施数量</th>
      <th data-options="field:'ids',width:60,align:'center',formatter:formatOperation">操作</th>
    </tr>
    </thead>
  </table>
  <div id="editDialog" class="easyui-dialog" style="width:90%;height:80%;padding:10px;" data-options="modal:true,closed:true,iconCls:'icon-save'">
    <jsp:include page="editPage.jsp"/>
  </div>
</div>
<script>
  function doSearch() {
    var params = {};
    params.name = $('#nameFilter').val();
    params.partyBranchId = $('#branchFilter').val();
    params.type = $('#typeFilter').val();
    $('#tableList').datagrid('load', params);
  }

  function formatType(val) {
    if(val == 1) {
      return '会议室设施';
    } else if(val == 2) {
      return '随车物品';
    }
    return '';
  }

  function edit(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if (rowData != null) {
      TT.resetForm();
      $('#editDialog').dialog('setTitle', '编辑设施');
      $('#editForm').attr('action', '<%=basePath%>admin/facility/update')
              .form('load', rowData);
      resetAvatar(rowData.avatar);
      $('#editDialog').dialog('open');
    }
  }

  $('#btn_add').bind('click', function() {
    TT.resetForm();
    $('#editDialog').dialog('setTitle', '新增设施');
    $('#editForm').attr('action', '<%=basePath%>admin/facility/add');
    resetAvatar(null);
    $('#editDialog').dialog('open');
  });

  function del(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认','确定删除设施名称为 '+rowData.name+' 的记录吗？',function(r){
      if (r){
        var params = {"id":rowData.id};
        $.post("<%=basePath%>admin/facility/delete",params, function(data){
          if(data == 'success'){
            $("#tableList").datagrid("reload");
          } else {
            $.messager.alert('删除出现错误');
          }
        });
      }
    });
  }

  function formatOperation(value, rowData, rowIndex) {
    var operator = {};
    <shiro:hasPermission name="facility:update">
    operator.edit = '编辑';
    </shiro:hasPermission>
    <shiro:hasPermission name="facility:delete">
    operator.del = '删除';
    </shiro:hasPermission>
    return TT.createOptionBtn(operator, rowIndex);
  }
</script>
</body>
</html>