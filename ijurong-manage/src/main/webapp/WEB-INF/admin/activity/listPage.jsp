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
  <script type="text/javascript" src="<%=basePath%>ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="<%=basePath%>ueditor/ueditor.all.js"></script>
  <script type="text/javascript" charset="utf-8" src="<%=basePath%>ueditor/lang/zh-cn/zh-cn.js"></script>
  <!--以下样式为了解决ue 和easyui的弹出层冲突-->
  <style type="text/css">
    .window{
      z-index: 905 ! important;
    }
    .window-shadow{
      z-index: 904 ! important;
    }
    .window-mask{
      z-index: 903 ! important;
    }
  </style>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="search_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      活动标题：<input type="text" id="nameFilter">&nbsp;
      活动类型：<select class="easyui-combobox" id="typeFilter">
      <option value="0">组织活动</option>
      <option value="1">志愿者活动</option>
      <option value="2">专题讨论</option>
    </select><span class="white_space"></span>
      开始时间：<input class="easyui-datetimebox" id="startTime"/><span class="white_space"></span>
      结束时间：<input class="easyui-datetimebox" id="endTime"/><span class="white_space"></span>
      <a href="#" class="easyui-linkbutton" id="btn_Search"
                                                 data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
    </div>
  </div>
  <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/activity/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'title',width:100,align:'center'">标题</th>
      <th data-options="field:'type',width:60,align:'center',formatter:formatActivityType">活动类型</th>
      <th data-options="field:'startTime',width:60,align:'center'">开始时间</th>
      <th data-options="field:'endTime',width:60,align:'center'">结束时间</th>
      <th data-options="field:'ids',width:60,align:'center',formatter:formatOperation">操作</th>
    </tr>
    </thead>
  </table>
  <div id="editDialog" class="easyui-dialog" style="width:90%;height:80%;padding:10px;" data-options="modal:true,resizable:true,maximizable:true,closed:true,iconCls:'icon-save'">
    <jsp:include page="editPage.jsp"/>
  </div>
</div>
<script>
  function formatActivityType(val, row) {
    if(val == 0) {
      return '组织活动';
    } else if(val == 1) {
      return '志愿者活动';
    } else if(val == 2) {
      return '专题讨论';
    }
    return '';
  }
  function doSearch() {
    var params = {};
    params.title = $('#nameFilter').val();
    params.type = $('#typeFilter').val();
    params.startTime = $('#startTime').val();
    params.endTime = $('#endTime').val();
    $('#tableList').datagrid('load', params);
  }

  function edit(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if (rowData != null) {
      TT.resetForm();
      $('#editDialog').dialog('setTitle', '编辑活动');
      $('#editForm').attr('action', '<%=basePath%>admin/activity/update')
              .form('load', rowData);
      uEditor.setContent(rowData.detail);
      initPerson();
      $('#editDialog').dialog('open');
    }
  }

  $('#btn_add').bind('click', function() {
    TT.resetForm();
    $('#editDialog').dialog('setTitle', '新增活动');
    $('#editForm').attr('action', '<%=basePath%>admin/activity/add');
    initPerson();
    $('#editDialog').dialog('open');
  });

  function del(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认','确定删除该记录吗？',function(r){
      if (r){
        var params = {"id":rowData.id};
        $.post("<%=basePath%>admin/activity/delete",params, function(data){
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
    operator.edit = '编辑';
    operator.del = '删除';
    return TT.createOptionBtn(operator, rowIndex);
  }
</script>
</body>
</html>