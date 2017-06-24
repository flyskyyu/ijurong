<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
            var appShufflingPic = {};
            appShufflingPic.name = $('#name').val();
            $('#appShufflingPic_grid').datagrid('load', appShufflingPic);
        }
        function doSubmit() {
            if($("#appShufflingPic_form").form('validate'))
            {
                var form = new FormData(document.getElementById("appShufflingPic_form"));
                $.ajax({
                    url: appShufflingPic_form.action,
                    type: appShufflingPic_form.method,
                    data: form,//$(appShufflingPic_form).serialize(),
                    cache: false,
                    processData: false,
                    contentType: false,
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '轮播图名称已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#appShufflingPic_dialog').dialog('close');
                            $('#appShufflingPic_grid').datagrid('reload');
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
                appShufflingPic_form.reset();
                TT.resetForm('appShufflingPic_dialog');
                $('#detail_type').combobox('setValue', '');
                $('#flag').combobox('setValue', '');
                $("#img_uploaded_url").hide();
                appShufflingPic_form.action = 'addAppShufflingPic';
                $('#appShufflingPic_dialog').dialog('setTitle', '添加轮播图');
                $('#level').combobox('clear');
                $('#appShufflingPic_dialog').dialog('open');
            });
        });

        $(function() {
            $('#btn_remove').bind('click', function() {
                var rowData = $('#appShufflingPic_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectAppShufflingPic/' + rowData.id;
                $.post(url, function(data) {
                    if (data == 'success') {
                        $('#appShufflingPic_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败：' + data);
                    }
                });
            });
        });

        function formatOperation(value, rowData, rowIndex) {
            var result = "";
            <shiro:hasPermission name="appShufflingPic:update">
            result = '<a href="#" onclick="openDialog(' + rowIndex
            + ')" style="color:green;text-decoration:none;">操作</a>';
            </shiro:hasPermission>
            return result;
        }




        function formatType(value, rowData, rowIndex) {
            var result = "";
            if(rowData.type==1)
            {
                result = '<a style="color:green;text-decoration:none;">URL</a>';
            }
            else
            {
                result = '<a style="color:blue;text-decoration:none;">功能</a>';
            }
            return result;
        }



        function openDialog(id) {
            appShufflingPic_form.reset();
            TT.resetForm('appShufflingPic_dialog');
            $('#detail_type').combobox('setValue', '');
            $('#flag').combobox('setValue', '');

            $('#appShufflingPic_grid').datagrid('selectRow', id);
            var rowData = $('#appShufflingPic_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#appShufflingPic_form').form('load', rowData);
                if(rowData.url!=null&&rowData.url!="")
                {
                    $("#img_uploaded_url").attr('src',rowData.url);
                    $("#img_uploaded_url").show();
                }
                else
                {
                    $("#img_uploaded_url").hide();
                }

            }
            appShufflingPic_form.action = "updateAppShufflingPic";
            $('#appShufflingPic_dialog').dialog('setTitle', '轮播图');
            $('#appShufflingPic_dialog').dialog('open');
        }




    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="appShufflingPic_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            轮播图名：<input type="text" id="name">&nbsp;
            <shiro:hasPermission name="appShufflingPic:query">
            <a href="#" class="easyui-linkbutton" id="btn_Search"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="appShufflingPic:add">
            <a href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="appShufflingPic:delete">
            <a ref="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
            </shiro:hasPermission>
        </div>
    </div>
    <table id="appShufflingPic_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findAppShufflingPics" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'name',align:'center'" width="20">轮播图名称</th>
            <th data-options="field:'type',align:'center',formatter:formatType"  width="5">功能类型</th>
            <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="25">操作</th>
        </tr>
        </thead>
    </table>
</div>

<div id="appShufflingPic_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'轮播图管理',
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
                        $('#appShufflingPic_dialog').dialog('close');
                    }  
                }]"
     style="width: 660px; height: 350px; padding: 10px;">


    <form id="appShufflingPic_form" name="appShufflingPic_form"
          method="post" enctype="multipart/form-data">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">轮播图管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">轮播图名称</td>
                            <td class="kv-content" colspan="3"><input type="text" name="name"  class="easyui-validatebox" data-options="required:true"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">图片上传</td>
                            <td class="kv-content" colspan="3"> <input type="file" name="file"><br/>
                            <img src="#" alt="已上传图片" id ="img_uploaded_url"style="width: 72px;height: 40px;"></td><input type="hidden"  name="url"/>
                        </tr>
                        <tr>
                            <td class="kv-label">展示地址</td>
                            <td class="kv-content" colspan="3"><select name="flag" id="flag" class="easyui-combobox" data-options="required:true">
                                <option value="0">首页轮播</option>
                                <option value="1">物品商城</option>
                            </select> </td>

                        </tr>
                        <tr>
                            <td class="kv-label">功能类型</td>
                            <td class="kv-content" colspan="3"><select name="type" id="detail_type" class="easyui-combobox" data-options="required:true">
                                <option value="1">url</option>
                                <option value="2">功能</option>
                            </select> </td>

                        </tr>
                        <tr>
                            <td class="kv-label">图片功能</td>
                            <td class="kv-content" colspan="3"><textarea name="toFunction" rows="5" placeholder="图片功能为url请填写url，为功能请填写执行代码" ></textarea></td>
                        </tr>
                        <tr>
                            <td class="kv-label">备注</td>
                            <td class="kv-content" colspan="3"><textarea name="remark" rows="5"></textarea></td>
                        </tr>

                        <tr>
                            <td class="kv-label" colspan="4"><p style="color: #cc0033">注：功能代码为<br/>通知AAA 组织活动AAB 优秀党员AAC 互动资源AAD 志愿大厅AAE 问卷调查AAF 专题讨论AAG 积分商城ABA</p></td>
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