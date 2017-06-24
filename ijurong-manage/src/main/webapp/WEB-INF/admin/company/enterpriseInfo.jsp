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
            var enterpriseInfo = {};
            enterpriseInfo.name = $('#name').val();
            $('#enterpriseInfo_grid').datagrid('load', enterpriseInfo);
        }
        function doSubmit() {
            if ($("#enterpriseInfo_form").form('validate')) {
                $.ajax({
                    url: enterpriseInfo_form.action,
                    type: enterpriseInfo_form.method,
                    data: $(enterpriseInfo_form).serialize(),
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '企业名已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#enterpriseInfo_dialog').dialog('close');
                            $('#enterpriseInfo_grid').datagrid('reload');
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
                enterpriseInfo_form.reset();
                TT.resetForm('enterpriseInfo_dialog');
                enterpriseInfo_form.action = 'addEnterpriseInfo';
                $('#enterpriseInfo_dialog').dialog('setTitle', '添加企业');
                $('#level').combobox('clear');
                $('#enterpriseInfo_dialog').dialog('open');
            });
        });

        $(function () {
            $('#btn_remove').bind('click', function () {
                var rowData = $('#enterpriseInfo_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectEnterpriseInfo/' + rowData.id;
                $.post(url, function (data) {
                    if (data == 'success') {
                        $('#enterpriseInfo_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败：' + data);
                    }
                });
            });
        });

        function formatOperation(value, rowData, rowIndex) {
            var result = "";
            <shiro:hasPermission name="enterpriseInfo:update">
            result = '<a href="#" onclick="openDialog(' + rowIndex
            + ')" style="color:green;text-decoration:none;">操作</a>';
            </shiro:hasPermission>
            return result;
        }


        function formatType(value, rowData, rowIndex) {
            if (value == '1')
                return '<span>国企</span>';
            if (value == '2')
                return '<span>民营</span>';
            if (value == '3')
                return '<span>外资</span>';
            if (value == '4')
                return '<span>合资</span>';
            if (value == '5')
                return '<span>其他</span>';
        }


        function openDialog(id) {
            enterpriseInfo_form.reset();
            TT.resetForm('enterpriseInfo_dialog');
            $('#enterpriseInfo_grid').datagrid('selectRow', id);
            var rowData = $('#enterpriseInfo_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#enterpriseInfo_form').form('load', rowData);

            }
            enterpriseInfo_form.action = "updateEnterpriseInfo";
            $('#enterpriseInfo_dialog').dialog('setTitle', '企业帐号');
            $('#enterpriseInfo_dialog').dialog('open');
        }


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="enterpriseInfo_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            企业名称：<input type="text" id="name">&nbsp;
            <shiro:hasPermission name="enterpriseInfo:query">
                <a href="#" class="easyui-linkbutton" id="btn_Search"
                   data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="enterpriseInfo:add">
                <a href="#" class="easyui-linkbutton"
                   data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="enterpriseInfo:delete">
                <a href="#" class="easyui-linkbutton"
                   data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
            </shiro:hasPermission>
        </div>
    </div>
    <table id="enterpriseInfo_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findEnterpriseInfos" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;"
           singleSelect="true">

        <%--class="easyui-datagrid"--%>
        <%--data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findEnterpriseInfos',striped:true,toolbar:'#enterpriseInfos_toolbar'">--%>
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'name',align:'center'" width="30">企业名称</th>
            <th data-options="field:'type',align:'center',formatter:formatType" width="20">公司类型</th>
            <th data-options="field:'address',align:'center'" width="20">公司地址</th>
            <th data-options="field:'phone',align:'center'" width="20">公司电话</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作
            </th>
        </tr>
        </thead>
    </table>
</div>

<div id="enterpriseInfo_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'企业管理',
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
                        $('#enterpriseInfo_dialog').dialog('close');
                    }  
                }]"
     style="width: 750px; height: 400px; padding: 10px;">
    <form id="enterpriseInfo_form" name="enterpriseInfo_form"
          method="post">

        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">企业管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">企业名称</td>
                            <td class="kv-content"><input type="text" name="name" class="easyui-validatebox"
                                                          data-options="required:true"/></td>
                            <td class="kv-label">公司类型</td>
                            <td class="kv-content">
                                <select name="type" class="easyui-combobox" data-options="required:true">
                                    <option value="1">国企</option>
                                    <option value="2">民营</option>
                                    <option value="3">外资</option>
                                    <option value="4">合资</option>
                                    <option value="5">其他</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td class="kv-label">公司地址</td>
                            <td class="kv-content"><input type="text" name="address"/></td>
                            <td class="kv-label">公司电话</td>
                            <td class="kv-content"><input type="text" name="phone"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">组织机构代码</td>
                            <td class="kv-content"><input type="text" name="code"/></td>
                            <td class="kv-label">成立时间</td>
                            <td class="kv-content"><input class="easyui-datebox" name="createDate"/></td>
                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <input type="hidden" value="0" name="id" id="id"/>
    </form>
</div>
</body>
</html>