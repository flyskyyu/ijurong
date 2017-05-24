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
    <script type="text/javascript">
        var ue = UE.getEditor('editor');

        function doSearch() {
            var message = {};
            message.title = $('#title').val();
            $('#message_grid').datagrid('load', message);
        }
        function doSubmit() {
            $('#message_form').form('submit', {
                success : function(data) {
                    if (data == "success") {
                        $('#message_dialog').dialog('close');
                        $('#message_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '提交失败!');
                    }
                }
            });
        }
        $(function() {
            $('#btn_add').bind('click', function() {
                message_form.reset();
                message_form.action = 'addMessage';
                $('#message_dialog').dialog('setTitle', '添加通知');
                $('#level').combobox('clear');
                $('#message_dialog').dialog('open');
            });
        });

        $(function() {
            $('#btn_remove').bind('click', function() {
                var rowData = $('#message_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectMessage/' + rowData.id;
                $.post(url, function(data) {
                    if (data == 'success') {
                        $('#message_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败：消息发布中或系统异常');
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
            + ')" style="color:green;text-decoration:none;">操作</a>'
            +'    <a href="#" onclick="openPostDialog(' + rowIndex
            + ')" style="color:red;text-decoration:none;">发布</a>';
//      }
            return result;
        }

        function formatterStatus(value, rowData, rowIndex) {
            var result = "";
            if (rowData.isPost == '0') {
                result = '<a style="color:green;text-decoration:none;">未发布</a>';
            }
            else if (rowData.isPost == '1') {
                result = '<a style="color:red;text-decoration:none;">发布中</a>';
            }else {
                result = '<a style="color:grey;text-decoration:none;">已发布</a>';
            }
            return result;
        }

        $(function(){
            $('#post_users').combotree('loadData', [{
                id: 1,
                text: '市党支部',
                children: [{
                    id: 11,
                    text: '雨花区党支部'
                },{
                    id: 12,
                    text: '阿萨党支部'
                }]
            }]);
        });


        function openPostDialog(id) {
            $('#message_grid').datagrid('selectRow', id);
            var rowData = $('#message_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#message_form_post').form('load', rowData);

            }
            message_form_post.action = "updateMessage";
            $('#message_dialog_post').dialog('setTitle', '通知发布');
            $('#message_dialog_post').dialog('open');
        }


        function doSubmitPost() {
            $.messager.confirm('是否发布!', '发布后大家都能收到咯，请确认您的操作!', function(r){
                if (r){
                    var t = $('#post_users').combotree('tree');	// get the tree object
                    var n = t.tree('getSelected');		// get selected node
                    alert(n.text);

                    alert('true!');
                }
                else
                {
                    alert('false!');
                }
            });
//            $('#message_form').form('submit', {
//                success : function(data) {
//                    if (data == "success") {
//                        $('#message_dialog').dialog('close');
//                        $('#message_grid').datagrid('reload');
//                    } else {
//                        $.messager.alert('提示', '提交失败!');
//                    }
//                }
//            });
        }

        function openDialog(id) {
            $('#message_grid').datagrid('selectRow', id);
            var rowData = $('#message_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#message_form').form('load', rowData);

            }
            message_form.action = "updateMessage";
            $('#message_dialog').dialog('setTitle', '通知管理');
            $('#message_dialog').dialog('open');
        }


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="message_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            通知名：<input type="text" id="title">&nbsp;
            <a href="#" class="easyui-linkbutton" id="btn_Search"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            <a href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            <a ref="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
        </div>
    </div>
    <table id="message_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findMessages" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'title',align:'center'" width="30">通知名称</th>
            <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
            <th data-options="field:'isPost',align:'center',formatter:formatterStatus"  width="20">状态</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作</th>
        </tr>
        </thead>
    </table>
</div>

<div id="message_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'通知管理',
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
                        $('#message_dialog').dialog('close');
                    }  
                }]"
     style="width: 980px; height: 480px; padding: 10px;">


    <form id="message_form" name="message_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">通知管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">通知名称</td>
                            <td class="kv-content" colspan="3"><input type="text" name="title"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label" >通知类型:</td>
                            <td class="kv-content" colspan="3">
                                <input id="cc" class="easyui-combobox" name="type"
                                       data-options="valueField:'id',textField:'name',url:'findAllMessageTypes'">
                            </td>
                        </tr>

                        </tbody>
                    </table>
                    <div class="column"><span class="current">通知内容</span></div>
                    <!-- 加载编辑器的容器 -->
                    <script id="editor" name="newsContent" type="text/plain" style="width:890px;height:400px;"></script>

                </div>
            </div>
        </div>
        <input type="hidden" value="0" name="id"/>
    </form>
</div>

<div id="message_dialog_post" class="easyui-dialog"
     data-options="closed:true,
		title:'通知发布',
		modal:true,
		resizable:true,
		iconCls:'icon-save',
		buttons: [{
					id:'btn_submit',
                    text:'发布',
                    iconCls:'icon-ok',
                    handler:function(){
                        doSubmitPost();
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#message_dialog_post').dialog('close');
                    }
                }]"
     style="width: 660px; height: 350px; padding: 10px;">


    <form id="message_form_post" name="message_form_post"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">通知发布</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">通知名称</td>
                            <td class="kv-content" colspan="3"><input type="text" name="title"/></td>
                        </tr>

                        <tr>
                            <td class="kv-label">发布对象</td>
                            <td class="kv-content" colspan="3">
                                <select id="post_users"  name="post_users" class="easyui-combotree" style="width:200px;"
                                        data-options="url:'get_data.php',required:true,multiple:true">
                                </select>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <input type="hidden" value="0" name="id_post" />
    </form>
</div>
</body>
</html>