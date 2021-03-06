<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <script type="text/javascript">
        function doSearch() {
            var volunteer = {};
            volunteer.name = $('#name').val();
            volunteer.sex = $('#sex').val();
            volunteer.isPass = $('#isPass').val();
            $('#volunteer_grid').datagrid('load', volunteer);
        }
        function doSubmit() {
            if ($("#volunteer_form").form('validate')) {
                $.ajax({
                    url: volunteer_form.action,
                    type: volunteer_form.method,
                    data: $(volunteer_form).serialize(),
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '志愿者已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#volunteer_dialog').dialog('close');
                            $('#volunteer_grid').datagrid('reload');
                        } else {
                            $.messager.alert('提示', '提交失败!');
                        }
                    },
                    error: function () {
                        $.messager.alert('提示', '服务器内部错误!');
                    }
                });
            }

        }
        $(function () {
            $('#btn_add').bind('click', function () {
                volunteer_form.reset();
                TT.resetForm('volunteer_dialog');
                volunteer_form.action = 'addVolunteer';
                $('#volunteer_dialog').dialog('setTitle', '添加志愿者');
                $('#level').combobox('clear');
                $('#volunteer_dialog').dialog('open');
            });
        });

        $(function () {
            $('#btn_remove').bind('click', function () {
                var rowData = $('#volunteer_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectVolunteer/' + rowData.id;
                $.post(url, function (data) {
                    if (data == 'success') {
                        $('#volunteer_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败：' + data);
                    }
                });
            });
        });

        function formatOperation(value, rowData, rowIndex) {
            var result = "";
            <shiro:hasPermission name="volunteer:update">
            result = '<a href="#" onclick="openDialog(' + rowIndex
            + ')" style="color:green;text-decoration:none;">操作</a>';
            </shiro:hasPermission>
            return result;
        }


        function formatSex(value, rowData, rowIndex) {
            if (value == '2')
                return '<span>女</span>';
            if (value == '1')
                return '<span>男</span>';
        }

        function formatStatus(value, rowData, rowIndex) {
            if (value == '0')
                return '<span>待审核</span>';
            if (value == '1')
                return '<span  style="color:green">通过</span>';
            if (value == '2')
                return '<span  style="color:red">不通过</span>';
            if (value == '3')
                return '<span  style="color:#696969">暂退</span>';
        }


        function openDialog(id) {
            volunteer_form.reset();
            TT.resetForm('volunteer_dialog');
            $('#volunteer_grid').datagrid('selectRow', id);
            var rowData = $('#volunteer_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#volunteer_form').form('load', rowData);

            }
            volunteer_form.action = "updateVolunteer";
            $('#volunteer_dialog').dialog('setTitle', '志愿者');
            $('#volunteer_dialog').dialog('open');
        }


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="volunteer_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            志愿者：<input type="text" id="name">&nbsp;
            性别：<select id="sex" class="easyui-combobox">
            <option value="0" selected>请选择</option>
            <option value="1">男</option>
            <option value="2">女</option>
        </select>&nbsp;
            状态：
            <select id="isPass" class="easyui-combobox">
                <option value="-1" selected>请选择</option>
                <option value="0">待审核</option>
                <option value="1">通过</option>
                <option value="2">不通过</option>
                <option value="3">暂退</option>
            </select>
            <shiro:hasPermission name="volunteer:query">
                <a href="#" class="easyui-linkbutton" id="btn_Search"
                   data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;

            </shiro:hasPermission>
            <%--<shiro:hasPermission name="volunteer:add">--%>
            <%--<a href="#" class="easyui-linkbutton"--%>
            <%--data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;--%>
            <%--</shiro:hasPermission>--%>
            <shiro:hasPermission name="volunteer:delete">
                <a ref="#" class="easyui-linkbutton"
                   data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
            </shiro:hasPermission>
        </div>
    </div>
    <table id="volunteer_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findVolunteers" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true">

        <%--class="easyui-datagrid"--%>
        <%--data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findVolunteers',striped:true,toolbar:'#volunteers_toolbar'">--%>
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th field="userId" hidden="true"></th>
            <th data-options="field:'name',align:'center'" width="30">志愿者名称</th>
            <th data-options="field:'sex',align:'center',formatter:formatSex" width="20">性别</th>
            <th data-options="field:'address',align:'center'" width="20">地址</th>
            <th data-options="field:'phoneNumber',align:'center'" width="20">电话</th>
            <th data-options="field:'isPass',align:'center',formatter:formatStatus" width="10">状态</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作
            </th>
        </tr>
        </thead>
    </table>
</div>

<div id="volunteer_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'志愿者管理',
		modal:true,
		resizable:true,
		iconCls:'icon-save',
		buttons: [{
					id:'btn_submit',
                    text:'提交',  
                    iconCls:'icon-ok',  
                    handler:function(){  
                        doSubmit();  
                    }  
                },{  
                    text:'取消',
                    iconCls:'icon-cancel',   
                    handler:function(){  
                        $('#volunteer_dialog').dialog('close');
                    }  
                }]"
     style="width: 800px; height: 500px; padding: 10px;">


    <form id="volunteer_form" name="volunteer_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">志愿者管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">志愿者名称</td>
                            <td class="kv-content"><input type="text" name="name" class="easyui-validatebox"
                                                          data-options="required:true"/></td>
                            <td class="kv-label">性别</td>
                            <td class="kv-content">
                                <input type="radio" name="sex" value="1"> 男
                                <input type="radio" name="sex" value="2"> 女
                            </td>
                        </tr>
                        <tr>
                            <td class="kv-label">年龄</td>
                            <td class="kv-content"><input type="text" name="age" class="easyui-validatebox"
                                                          data-options="required:true"></td>
                            <td class="kv-label">联系电话</td>
                            <td class="kv-content"><input type="text" name="phoneNumber" class="easyui-validatebox"
                                                          data-options="required:true"></td>
                        </tr>
                        <tr>
                            <td class="kv-label">地址</td>
                            <td class="kv-content"><input type="text" name="address"/></td>
                            <td class="kv-label">服务时间</td>
                            <td class="kv-content"><input type="text" name="time"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">特长</td>
                            <td class="kv-content" colspan="3"><textarea name="specialty" rows="5"></textarea></td>
                        </tr>
                        <tr>
                            <td class="kv-label">服务意向</td>
                            <td class="kv-content" colspan="3"><textarea name="intention" rows="5"></textarea></td>
                        </tr>
                        <tr>
                            <td class="kv-label">服务范围</td>
                            <td class="kv-content" colspan="3"><textarea name="ranges" rows="5"></textarea></td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="column"><span class="current">审批</span></div>

                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">状态</td>
                            <td class="kv-content"><select name="isPass" class="easyui-combobox">
                                <option value="0">待审核</option>
                                <option value="1">通过</option>
                                <option value="2">不通过</option>
                                <option value="3">暂退</option>
                            </select></td>
                            <td class="kv-label"></td>
                            <td class="kv-content"></td>
                        </tr>

                        <tr>
                            <td class="kv-label">反馈信息</td>
                            <td class="kv-content" colspan="3"><textarea name="feedback" rows="5"></textarea></td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <input type="hidden" value="0" name="id" id="id"/>
        <input type="hidden" value="0" name="userId" id="userId"/>
    </form>
</div>
</body>
</html>