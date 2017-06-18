<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":" +request.getServerPort()+path+"/" ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台帐号管理</title>
    <jsp:include page="../contentHeader.jsp"/>
    <script type="text/javascript">
        function doSearch() {
            var resourceType = {};
            resourceType.type = $('#type').val();
            $('#resourceType_grid').datagrid('load', resourceType);
        }
        function doSubmit() {
            if($("#resourceType_form").form('validate'))
            {
                $.ajax({
                    url: resourceType_form.action,
                    type: resourceType_form.method,
                    data: $(resourceType_form).serialize(),
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '资源类型已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#resourceType_dialog').dialog('close');
                            $('#resourceType_grid').datagrid('reload');
                        } else {
                            $.messager.alert('提示', '提交失败!');
                        }
                    },
                    error: function() {
                        $.messager.alert('提示', '服务器内部错误!');
                    }
                });
            }

        }
        $(function() {
            $('#btn_add').bind('click', function() {
                resourceType_form.reset();
                TT.resetForm('resourceType_dialog');
                resourceType_form.action = 'addResourceType';
                $('#resourceType_dialog').dialog('setTitle', '添加资源类型');
                $('#level').combobox('clear');
                $('#resourceType_dialog').dialog('open');
            });
        });

        $(function() {
            $('#btn_remove').bind('click', function() {
                var rowData = $('#resourceType_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectResourceType/' + rowData.id;
                $.post(url, function(data) {
                    if (data == 'success') {
                        $('#resourceType_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败：' + data);
                    }
                });
            });
        });

        function formatOperation(value, rowData, rowIndex) {
            var result = "";
//      if (rowData.level == '0') {
//        result = '<a style="color:red;text-decoration:none;">管理员</a>';
//      } else {
            result = '<a href="#" onclick="openDialog(' + rowIndex
            + ')" style="color:green;text-decoration:none;">操作</a>';
//      }
            return result;
        }


        function formatSex(value, rowData, rowIndex) {
            if (value == '2')
                return '<span>女</span>';
            if (value == '1')
                return '<span>男</span>';
        }


        function openDialog(id) {
            resourceType_form.reset();
            TT.resetForm('resourceType_dialog');
            $('#resourceType_grid').datagrid('selectRow', id);
            var rowData = $('#resourceType_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#resourceType_form').form('load', rowData);

            }
            resourceType_form.action = "updateResourceType";
            $('#resourceType_dialog').dialog('setTitle', '资源类型');
            $('#resourceType_dialog').dialog('open');
        }


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="resourceType_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            资源名：<input type="text" id="type">&nbsp;
            <a href="#" class="easyui-linkbutton" id="btn_Search"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            <a href="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            <a ref="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
        </div>
    </div>
    <table id="resourceType_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findResourceTypes" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'type',align:'center'" width="30">资源类型名称</th>
            <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作</th>
        </tr>
        </thead>
    </table>
</div>

<div id="resourceType_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'资源类型管理',
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
                        $('#resourceType_dialog').dialog('close');
                    }  
                }]"
     style="width: 660px; height: 350px; padding: 10px;">


    <form id="resourceType_form" name="resourceType_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">资源类型管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">资源类型名称</td>
                            <td class="kv-content" colspan="3"><input type="text" name="type" class="easyui-validatebox" data-options="required:true"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">备注</td>
                            <td class="kv-content" colspan="3"><textarea name="remark" rows="5"></textarea></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <input type="hidden" value="0" name="id" id="id" />
    </form>
</div>
</body>
</html>