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
            var research = {};
            research.researchName = $('#researchName').val();
            $('#research_grid').datagrid('load', research);
        }
        //清空列表 参数为从第几行开始
        function clearTable()
        {
            $('.tr_class').remove();
        }
        function doSubmit() {
            if($("#research_form").form('validate'))
            {
                var length=document.getElementById("tab_answer").rows.length;
                var jsonArray = [];
                for(var i=1;i<length;i++)
                {
                    var json = new Object;
                    json.questionScore=document.getElementById("tab_answer").rows[i].cells[1].firstChild.value;
                    json.questionSort=document.getElementById("tab_answer").rows[i].cells[2].firstChild.value;
                    json.questionId=document.getElementById("tab_answer").rows[i].cells[3].firstChild.value;
                    jsonArray.push(json);
                }
                var formData=$(research_form).serialize();
                formData += '&opt=' + JSON.stringify(jsonArray);
                $.ajax({
                    url: research_form.action,
                    type: research_form.method,
                    data: formData,
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '卷子名已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#research_dialog').dialog('close');
                            $('#research_grid').datagrid('reload');
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
                research_form.reset();
                TT.resetForm('research_dialog');
                clearTable();
                research_form.action = 'addResearch';
                $('#research_dialog').dialog('setTitle', '添加卷子');
                $('#research_dialog').dialog('open');
            });
        });

        $(function(){
            $(document).on("click",'.aaa',function(){
                $(this).parent("td").parent("tr").remove();
            });
        });





        $(function() {
            $('#btn_remove').bind('click', function() {
                var rowData = $('#research_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'deleteResearch/' + rowData.id;
                $.post(url, function(data) {
                    if (data == 'success') {
                        $('#research_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败：' + data);
                    }
                });
            });
        });

        function formatOperation(value, rowData, rowIndex) {
            var result = "";
        <shiro:hasPermission name="research:update">
            result = '<a href="#" onclick="openDialog(' + rowIndex
                    + ')" style="color:green;text-decoration:none;">操作</a>';
        </shiro:hasPermission>
            return result;
        }

        function formatQuestionType(value, rowData, rowIndex) {
            var result = "";
            if(rowData.type==0)
            {
                result = '<a style="color:green;text-decoration:none;">单选</a>';
            }
            else
            {
                result = '<a style="color:blue;text-decoration:none;">多选</a>';
            }
            return result;
        }



        function openDialog(id) {
            TT.resetForm('research_dialog');
            clearTable();
            $('#research_grid').datagrid('selectRow', id);
            var rowData = $('#research_grid').datagrid('getSelected');
            if (rowData != null) {
                //加载选项数据
                var url = 'findResearchExamsByResearchId/' + rowData.id;
                $.post(url, function(data) {
                    if (data) {
                        for(var i=0;i<data.length;i++)
                        {
                            var t=Math.random();
                            var html_answer= '<tr class="tr_class"><td class="kv-content"><input type="text" name="questionContent" value="'+data[i].questionContent+'"/>'+
                                    '</td>'+
                                    '<td class="kv-content"><input type="text" name="questionScore" value="'+data[i].questionScore+'"/>'+
                                    '</td>'+
                                    '<td class="kv-content"><input type="text" name="questionSort" value="'+data[i].questionSort+'"/>'+
                                    '</td>'+
                                    '<td style="display: none"><input type="hidden" name="questionId" value="'+data[i].questionId+'"></td>'+
                                    '<td class="kv-content" id="tr_del"><a class="aaa">删除</a>'+
                                    '</td></tr>';
                            $("#tab_answer").append(html_answer);
                        }
                        $("#tab_answe").trigger("create");
                    } else {
                        $.messager.alert('提示', '获取数据失败：' + data);
                    }
                });

                $('#research_form').form('load', rowData);

            }
            research_form.action = "updateResearch";
            $('#research_dialog').dialog('setTitle', '卷子');
            $('#research_dialog').dialog('open');
        }


        $(function() {
            $('#refGrid').combogrid({
                onSelect : function(rowIndex, rowData) {
                    $('#url1').val(rowData.url);

                    var t=Math.random();
                    var html_answer= '<tr class="tr_class"><td class="kv-content"><input type="text" name="questionContent" value="'+rowData.questionContent+'"/>'+
                            '</td>'+
                            '<td class="kv-content"><input type="text" name="questionScore"/>'+
                            '</td>'+
                            '<td class="kv-content"><input type="text" name="questionSort"/>'+
                            '</td>'+
                            '<td style="display: none"><input type="hidden" name="questionId" value="'+rowData.id+'"></td>'+
                            '<td class="kv-content" id="tr_del"><a class="aaa">删除</a>'+
                            '</td></tr>';
                    $("#tab_answer").append(html_answer);
                    $("#tab_answe").trigger("create");
                }
            });
        });

    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="research_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            问卷：<input type="text" id="researchName">&nbsp;
            <shiro:hasPermission name="research:query">
            <a href="#" class="easyui-linkbutton" id="btn_Search"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="research:add">
            <a href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="research:delete">
            <a ref="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
            </shiro:hasPermission>
        </div>
    </div>
    <table id="research_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findResearchs" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'researchName',align:'center'" width="30">卷子名称</th>
            <th data-options="field:'startTime',align:'center'"  width="20">开始时间</th>
            <th data-options="field:'stopTime',align:'center'"  width="20">结束时间</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作</th>
        </tr>
        </thead>
    </table>
</div>

<div id="research_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'問卷管理',
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
                        $('#research_dialog').dialog('close');
                    }
                }]"
     style="width: 850px; height: 450px; padding: 10px;">


    <form id="research_form" name="research_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">调查問卷管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">問卷名称</td>
                            <td class="kv-content" colspan="3"><input type="text"name="researchName" class="easyui-validatebox" data-options="required:true"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">调查目的</td>
                            <td class="kv-content" colspan="3"><textarea name="researchGoal" rows="5"></textarea></td>
                        </tr>
                        <tr>
                            <td class="kv-label">是否公开</td>
                            <td class="kv-content" colspan="3"><input type="radio" name="isOpen" value="0"/>不公开
                                <input type="radio"name="isOpen" value="1" checked/>公开</td>
                        </tr>
                        <tr>
                            <td class="kv-label">调查开始时间</td>
                            <td class="kv-content" ><input class="easyui-datetimebox" name="startTime" data-options="required:true"/></td>
                            <td class="kv-label">调查结束时间</td>
                            <td class="kv-content" ><input class="easyui-datetimebox" name="stopTime" data-options="required:true"/></td>
                        </tr>

                        </tbody>
                    </table>


                    <div class="column"><span class="current">卷子管理</span></div>
                    <table  class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">查找添加</td>
                            <td class="kv-content" colspan="3">
                                <div>

                                    <div style="float:left;width:40%">
                                        <select id="refGrid" class="easyui-combogrid"
                                                style="width: 230px"
                                                data-options="mode:'remote',
                                            panelWidth: 350,
                                            loadMsg: '正在搜索，请稍等...',
                                            pagination : true,
                                            idField: 'id',
                                            textField: 'questionContent',
                                            url: 'findExamQuestionsByName',
                                            columns: [[
                                            {field:'questionContent',title:'题目名称',width:100},
                                                {field:'id',hidden:true}
                                            ]],
                                            fitColumns: true
                                            ">
                                        </select>
                                    </div>
                                    <%--<div style="float:right;width:60%">--%>
                                    <%--<img style="width:25px;height: 25px;" id="addAnswer" src="/img/add_img_icon.png" alt="">--%>
                                    <%--</div>--%>
                                </div>
                            </td>
                        </tr>


                        <tr>
                            <td class="kv-label">卷子</td>
                            <td class="kv-content" colspan="3">
                                <div>
                                    <table id="tab_answer">
                                        <tr>
                                            <td class="kv-label">卷子
                                            </td>
                                            <td class="kv-label">分值
                                            </td>
                                            <td class="kv-label">选项序号
                                            </td>
                                            <td class="kv-label">操作
                                            </td>
                                        </tr>
                                        <tr class="tr_class">
                                            <td class="kv-content"><input type="text" name="questionContent"/>
                                            </td>
                                            <td class="kv-content"><input type="text" name="questionScore"/>
                                            </td>
                                            <td class="kv-content"><input type="text" name="questionSort"/>
                                            </td>
                                            <td style="display: none"><input type="hidden" name="questionId"></td>
                                            <td class="kv-content" id="tr_del"><a class="aaa">删除</a>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
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
