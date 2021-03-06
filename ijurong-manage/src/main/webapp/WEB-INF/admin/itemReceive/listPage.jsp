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
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="search_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      申请人姓名：<input type="text" id="nameFilter"><span class="white_space"></span>
      查看类型：<select class="easyui-combobox" id="typeFilter">
      <option value="0">所有</option>
      <option value="1">未回复</option>
      <option value="2">未领取</option>
    </select><span class="white_space"></span>
      <a href="#" class="easyui-linkbutton" id="btn_Search"
                                                 data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <shiro:hasPermission name="itemReceive:add">
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      </shiro:hasPermission>
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
    </div>
  </div>
  <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/itemReceive/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'staffName',width:100,align:'center'">领取人姓名</th>
      <th data-options="field:'phoneNumber',width:60,align:'center'">电话</th>
      <th data-options="field:'itemName',width:60,align:'center'">领取物品</th>
      <th data-options="field:'num',width:60,align:'center'">领取数量</th>
      <th data-options="field:'isAgree',width:30,align:'center',formatter:TT.formatYesNo">是否同意</th>
      <th data-options="field:'isReceive',width:30,align:'center',formatter:TT.formatYesNo">是否领取</th>
      <th data-options="field:'ids',width:60,align:'center',formatter:formatOperation">操作</th>
    </tr>
    </thead>
  </table>
  <div id="editWindow" class="easyui-window"
       data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/itemReceive/editPage'"
       style="width:90%;height:80%;padding:10px;">
  </div>
</div>
<script>
  function doSearch() {
    var params = {};
    params.staffName = $('#nameFilter').val();
    params.typeFilter = $('#typeFilter').val();
    $('#tableList').datagrid('load', params);
  }

  $('#btn_add').bind('click', function() {
    $("#editWindow").window({
      title: '新增物品申领',
      onLoad: function() {
        TT.createEditBtn(['ok', 'cancel']);
        $('#editForm').attr('action', '<%=basePath%>admin/itemReceive/add');
      }
    }).window('open');
  });

  /*function reply(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认申请','是否同意姓名为 '+rowData.staffName+' 的申请？',function(r){
      var params = {"id":rowData.id};
      if(r) {
        params.isAgree = 1;
      } else {
        params.isAgree = 0;
      }
      $.post("<%=basePath%>admin/itemReceive/reply",params, function(data){
        if(data == 'success'){
          $("#tableList").datagrid("reload");
        } else if(data == 'lack') {
          $.messager.alert('警告', '物品数量不足');
        } else {
          $.messager.alert('出现错误');
        }
      });
    });
  }*/

  function reply(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $("#editWindow").window({
      title: '审核物品兑换申请',
      onLoad: function() {
        $('#editForm').attr('action', '<%=basePath%>admin/itemReceive/reply')
                .form('load', rowData);
        TT.disabledAllExcept('editForm');
        TT.createEditBtn(['yes','no', 'cancel']);
        document.getElementById('replyInput').focus()
      }
    }).window('open');
  }

  function receive(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认领取','是否确认姓名为 '+rowData.staffName+' 的领取？',function(r){
      var params = {"id":rowData.id};
      if(r) {
        $.post("<%=basePath%>admin/itemReceive/receive",params, function(data){
          if(data == 'success'){
            $("#tableList").datagrid("reload");
          } else {
            $.messager.alert('出现错误');
          }
        });
      }
    });
  }

  function look(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $("#editWindow").window({
      title: '查看物品申请',
      onLoad: function() {
        $('#editForm').attr('action', '<%=basePath%>admin/itemReceive/reply').form('load', rowData);
        TT.disabledAll('editForm');
        TT.createEditBtn(['cancel']);
      }
    }).window('open');
  }

  function del(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认','确定删除该记录吗？',function(r){
      if (r){
        var params = {"id":rowData.id};
        $.post("<%=basePath%>admin/itemReceive/delete",params, function(data){
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
    if(rowData.isAgree == null) {
      <shiro:hasPermission name="itemReceive:check">
      operator.reply = '回复';
      </shiro:hasPermission>
    } else {
      if(rowData.isAgree == 1 && rowData.isReceive == 0) {
        <shiro:hasPermission name="itemReceive:check">
        operator.receive = '领取';
        </shiro:hasPermission>
      }
      operator.look = '查看';
    }
    <shiro:hasPermission name="itemReceive:delete">
    operator.del = '删除';
    </shiro:hasPermission>
    return TT.createOptionBtn(operator, rowIndex);
  }
</script>
</body>
</html>