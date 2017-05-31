<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <script type="text/javascript" src="<%=basePath%>resource/jqueryFileUpload/js/jquery.iframe-transport.js"></script>
  <script type="text/javascript" src="<%=basePath%>resource/jqueryFileUpload/js/jquery.fileupload.js"></script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="search_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      会议室名称：<input type="text" id="nameFilter">&nbsp;
        所属支部：<select class="easyui-combobox" id="branchFilter">
          <c:forEach var="branch" items="${sessionScope.USER_KEY.branchInfos}">
            <option value="${branch.id}">${branch.organizationName}</option>
          </c:forEach>
        </select>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" id="btn_Search"  data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;&nbsp;&nbsp;
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
    </div>
  </div>
  <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
         data-options="url:'<%=basePath%>admin/meetingRoom/list',rownumbers:true,singleSelect:true,collapsible:false,pagination:true,method:'get',pageSize:20">
    <thead>
    <tr>
      <th data-options="field:'name',width:40,align:'center'">会议室</th>
      <th data-options="field:'introduce',width:100,align:'center'">介绍</th>
      <th data-options="field:'ids',width:40,align:'center',formatter:formatOperation">操作</th>
    </tr>
    </thead>
  </table>
  <div id="editWindow" class="easyui-window"
       data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/meetingRoom/editPage'"
       style="width:90%;height:80%;padding:10px;">
  </div>
</div>
<script>
  function doSearch() {
    var params = {};
    params.name = $('#nameFilter').val();
    params.partyBranchId = $('#branchFilter').val();
    $('#tableList').datagrid('load', params);
  }

  function edit(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if (rowData != null) {
      $("#editWindow").window({
        title: '编辑会议室',
        onLoad: function() {
          $('#editForm').attr('action', '<%=basePath%>admin/meetingRoom/update')
                  .form('load', rowData);
        }
      }).window('open');
    }
  }

  $('#btn_add').bind('click', function() {
    $("#editWindow").window({
      title: '新增会议室',
      onLoad: function() {
        $('#editForm').attr('action', '<%=basePath%>admin/meetingRoom/add');
      }
    }).window('open');
  });

  function del(rowIndex) {
    $('#tableList').datagrid('selectRow', rowIndex);
    var rowData = $('#tableList').datagrid('getSelected');
    if(rowData == null) return;
    $.messager.confirm('确认','确定会议室名为 '+rowData.name+' 的记录吗？',function(r){
      if (r){
        var params = {"id":rowData.id};
        $.post("<%=basePath%>admin/meetingRoom/delete",params, function(data){
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
    operator.edit = '编辑';
    operator.del = '删除';
    return TT.createOptionBtn(operator, rowIndex);
  }
</script>
</body>
</html>