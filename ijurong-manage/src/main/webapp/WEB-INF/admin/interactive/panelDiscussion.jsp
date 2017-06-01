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
            var panelDiscussion = {};
            panelDiscussion.name = $('#name').val();
            panelDiscussion.isShadow=$('#isShadow').combobox('getValue');
            $('#panelDiscussion_grid').datagrid('load', panelDiscussion);
        }
        function doSubmit() {
            $('#panelDiscussion_form').form('submit', {
                success : function(data) {
                    if (data == "had") {
                        $.messager.alert('提示', '发表信息已存在!');
                        return;
                    }
                    if (data == "success") {
                        $('#panelDiscussion_dialog').dialog('close');
                        $('#panelDiscussion_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '提交失败!');
                    }
                }
            });
        }
        $(function() {
            $('#btn_add').bind('click', function() {
                panelDiscussion_form.reset();
                panelDiscussion_form.action = 'addPanelDiscussion';
                $('#panelDiscussion_dialog').dialog('setTitle', '添加发表信息');
                $('#level').combobox('clear');
                $('#panelDiscussion_dialog').dialog('open');
            });
        });

        $(function() {
            $('#btn_remove').bind('click', function() {
                var rowData = $('#panelDiscussion_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectPanelDiscussion/' + rowData.id;
                $.post(url, function(data) {
                    if (data == 'success') {
                        $('#panelDiscussion_grid').datagrid('reload');
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
        function formatType(value, rowData, rowIndex) {
            var result = "";
            if(rowData.isShadow==0)
            {
                result = '<a style="color:green;text-decoration:none;">员工论坛</a>';
            }
            else
            {
                result = '<a style="color:red;text-decoration:none;">光影圈</a>';
            }
            return result;
        }

        function formattitle(value, rowData, rowIndex) {
            var result = "";
            if(rowData.title.length > 20)
            {
                result = rowData.title.substring(0,17)+"...";
            }
            else
            {
                result = rowData.title;
            }
            return result;
        }


        function openDialog(id) {
            $('#panelDiscussion_grid').datagrid('selectRow', id);
            var rowData = $('#panelDiscussion_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#panelDiscussion_form').form('load', rowData);

            }
            panelDiscussion_form.action = "updatePanelDiscussion";
            $('#panelDiscussion_dialog').dialog('setTitle', '发表信息');
            $('#panelDiscussion_dialog').dialog('open');
        }


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="panelDiscussion_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            发表信息名：<input type="text" id="name">&nbsp;
            类别：<select  id="isShadow" class="easyui-combobox">
            <option selected>请选择</option>
            <option value="0">员工论坛</option>
            <option value="1">光影圈</option>
        </select>&nbsp;
            <a href="#" class="easyui-linkbutton" id="btn_Search"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            <%--<a href="#" class="easyui-linkbutton"--%>
               <%--data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;--%>
            <a ref="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
        </div>
    </div>
    <table id="panelDiscussion_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findPanelDiscussions" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'title',align:'center',formatter:formattitle" width="30">发表信息名称</th>
            <th data-options="field:'isShadow',align:'center',formatter:formatType"  width="20">类别</th>
            <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作</th>
        </tr>
        </thead>
    </table>
</div>

<div id="panelDiscussion_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'发表信息管理',
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
                        $('#panelDiscussion_dialog').dialog('close');
                    }  
                }]"
     style="width: 660px; height: 350px; padding: 10px;">


    <form id="panelDiscussion_form" name="panelDiscussion_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">发表信息管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">发表信息</td>
                            <td class="kv-content" colspan="3"><textarea name="title" rows="5"></textarea></td>
                        </tr>
                        <tr>
                            <td class="kv-label">发表时间</td>
                            <td class="kv-content" colspan="3"><input type="text" name="createTime"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">类别</td>
                            <td class="kv-content" colspan="3"><select  name="isShadow" class="easyui-combobox">
                                <option value="0">员工论坛</option>
                                <option value="1">光影圈</option>
                            </select></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <input type="hidden" value="0" name="userId"  />
        <input type="hidden" value="0" name="id"/>
    </form>
</div>
</body>
</html>