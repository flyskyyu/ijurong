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
      预约人姓名：<input type="text" id="nameFilter"><span class="white_space"></span>
        查看类型：<select class="easyui-combobox" id="typeFilter">
          <option value="0">所有</option>
          <option value="1">未回复</option>
          <option value="2">已回复</option>
        </select><span class="white_space"></span>
        <a href="#" class="easyui-linkbutton" id="btn_Search"
                                                 data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <shiro:hasPermission name="roomOrder:add">
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add" style="margin-right: 80px;">添加申请</a>&nbsp;
      </shiro:hasPermission>
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
      <select class="easyui-combobox" id="listMode">
        <option value="1">日历模式</option>
        <option value="2" selected>列表模式</option>
      </select>
    </div>
  </div>
  <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/meetingRoomOrder/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'staffName',width:60,align:'center'">姓名</th>
      <th data-options="field:'phoneNumber',width:60,align:'center'">电话</th>
      <th data-options="field:'name',width:60,align:'center'">会议室</th>
      <th data-options="field:'startTime',width:60,align:'center'">借取时间</th>
      <th data-options="field:'endTime',width:60,align:'center'">返还时间</th>
      <th data-options="field:'isAgree',width:30,align:'center',formatter:TT.formatYesNo">是否同意</th>
      <th data-options="field:'ids',width:60,align:'center',formatter:formatOperation">操作</th>
    </tr>
    </thead>
  </table>
  <div id="editWindow" class="easyui-window"
       data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/meetingRoomOrder/editPage'"
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

  function edit(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if (rowData != null) {
      $("#editWindow").window({
        title: '查看申请',
        onLoad: function() {
          $('#editForm').attr('action', '<%=basePath%>admin/meetingRoomOrder/update')
                  .form('load', rowData);
        }
      }).window('open');
    }
  }

  function reply(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $("#editWindow").window({
      title: '审核会议室预约申请',
      onLoad: function() {
        TT.createEditBtn(['yes', 'no', 'cancel']);
        $('#editUserName').combogrid('disable');
        document.getElementById('replyInput').focus();
        $('#editForm').attr('action', '<%=basePath%>admin/meetingRoomOrder/reply')
                .form('load', rowData);
        reloadUPloadObjs();
        /*if (!$('#roomComogrid').combogrid('grid').datagrid('getSelected')) {
          $('#roomComogrid').combogrid('grid').datagrid('reload',{'q':rowData.name});
        }*/
      }
    }).window('open');
  }

  function look(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $("#editWindow").window({
      title: '查看会议室预约申请',
      onLoad: function() {
        $('#editForm').attr('action', '#').form('load', rowData);
        reloadUPloadObjs();
        TT.disabledAll('editForm');
        TT.createEditBtn(['cancel']);
      }
    }).window('open');
  }

  $('#btn_add').bind('click', function() {
    $("#editWindow").window({
      title: '新增会议室预约申请',
      onLoad: function() {
        $('#editForm').attr('action', '<%=basePath%>admin/meetingRoomOrder/add');
        TT.createEditBtn(['ok', 'cancel']);
      }
    }).window('open');
  });

  function del(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认','确定删除姓名为 '+rowData.staffName+' 的申请记录吗？',function(r){
      if (r){
        var params = {"id":rowData.id};
        $.post("<%=basePath%>admin/meetingRoomOrder/delete",params, function(data){
          if(data == 'success'){
            $("#tableList").datagrid("reload");
          } else {
            $.messager.alert('提示','删除出现错误');
          }
        });
      }
    });
  }

  function formatOperation(value, rowData, rowIndex) {
    var operator = {};
    if(rowData.isAgree == null) {
      <shiro:hasPermission name="roomOrder:check">
      operator.reply = '回复';
      </shiro:hasPermission>
    } else {
      operator.look = '查看';
    }
    <shiro:hasPermission name="roomOrder:delete">
    operator.del = '删除';
    </shiro:hasPermission>
    return TT.createOptionBtn(operator, rowIndex);
  }

  $('#listMode').combobox({
    onChange: function() {
      if($(this).val() == 1) {
        window.location.href = 'calendarListPage';
      }
    }
  });
</script>
</body>
</html>