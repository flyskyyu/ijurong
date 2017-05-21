<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台帐号管理</title>
    <jsp:include page="../contentHeader.jsp"/>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="enterpriseInfo_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            党员名称：<input type="text" id="name">&nbsp;<a href="#"
                                                       class="easyui-linkbutton" id="btn_Search"
                                                       data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" id="btn_remove" style="display:none;">删除</a>
        </div>
    </div>
    <table class="easyui-datagrid" id="tableList" fitColumns="true" style="width:auto;"
           data-options="url:'<%=basePath%>admin/member/list',rownumbers:true,singleSelect:false,collapsible:false,pagination:true,method:'get',pageSize:20">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'staffName',width:100,align:'center'">姓名</th>
            <th data-options="field:'sex',width:60,formatter:TT.formatSex,align:'center'">性别</th>
            <th data-options="field:'nation',width:100,align:'center'">民族</th>
            <th data-options="field:'originPlace',width:120,align:'center'">籍贯</th>
            <th data-options="field:'education',width:70,align:'center',formatter:TT.formatEducation">学历</th>
            <th data-options="field:'phoneNumber',width:120,align:'center'">电话</th>
            <th data-options="field:'birthday',width:120,align:'center',formatter:TT.formatDate">生日</th>
            <th data-options="field:'staffId',width:130,align:'center',formatter:formatOperation">操作</th>
        </tr>
        </thead>
    </table>
    <div id="editWindow" class="easyui-window" title="新增党员"
         data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/member/editPage'"
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
                title: '编辑党员 - ' + rowData.staffName,
                onLoad: function() {
                    $('#editForm').attr('action', '<%=basePath%>admin/member/update')
                            .form('load', rowData);
                    $.get('<%=basePath%>admin/member/getMember', {id:rowData.staffId}, function(data) {
                        $('#editForm').form('load', data);
                    });
                }
            }).window('open');
        }
    }

    $('#btn_add').bind('click', function() {
        $("#editWindow").window({
            title: '新增党员',
            onLoad: function() {
                $('#editForm').attr('action', '<%=basePath%>admin/member/add');
            }
        }).window('open');
    });

    function del(rowIndex) {
        $('#tableList').datagrid('selectRow', rowIndex);
        var rowData = $('#tableList').datagrid('getSelected');
        if(rowData == null) return;
        $.messager.confirm('确认','确定删除姓名为 '+rowData.staffName+' 的信息吗？',function(r){
            if (r){
                var params = {"id":rowData.staffId};
                $.post("<%=basePath%>admin/member/delete",params, function(data){
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