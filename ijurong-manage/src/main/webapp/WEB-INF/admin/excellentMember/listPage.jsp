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
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="search_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      优秀党员名称：<input type="text" id="name">&nbsp;<a href="#"
                                                 class="easyui-linkbutton" id="btn_Search"
                                                 data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
    </div>
  </div>
  <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/excellentMember/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'staffName',width:100,align:'center'">姓名</th>
      <th data-options="field:'sex',width:60,align:'center',formatter:TT.formatSex">性别</th>
      <th data-options="field:'phoneNumber',width:60,align:'center'">电话</th>
      <th data-options="field:'selectionDate',width:60,align:'center',formatter:TT.formatDate">当选时间</th>
      <th data-options="field:'ids',width:100,align:'center',formatter:formatOperation">操作</th>
    </tr>
    </thead>
  </table>
  <div id="editWindow" class="easyui-window"
       data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/excellentMember/editPage'"
       style="width:90%;height:80%;padding:10px;">
  </div>
</div>
<script>
  function doSearch() {
    var params = {};
    params.staffName = $('#name').val();
    $('#tableList').datagrid('load', params);
  }

  function edit(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if (rowData != null) {
      $("#editWindow").window({
        title: '编辑优秀党员',
        onLoad: function() {
          $('#editForm').attr('action', '<%=basePath%>admin/excellentMember/update')
                  .form('load', rowData);
        }
      }).window('open');
    }
  }

  $('#btn_add').bind('click', function() {
    $("#editWindow").window({
      title: '新增优秀党员',
      onLoad: function() {
        $('#editForm').attr('action', '<%=basePath%>admin/excellentMember/add');
      }
    }).window('open');
  });

  function del(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认','确定删除姓名为 '+rowData.staffName+' 的记录吗？',function(r){
      if (r){
        var params = {"id":rowData.id};
        $.post("<%=basePath%>admin/excellentMember/delete",params, function(data){
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
    var result = '<a href="#" onclick="edit(' + rowIndex + ')" class="operate_btn">编辑</a>';
    result += '&nbsp;&nbsp;&nbsp;<a href="#" onclick="del(' + rowIndex +  ')" class="operate_btn">删除</a>';
    return result;
  }
</script>
</body>
</html>