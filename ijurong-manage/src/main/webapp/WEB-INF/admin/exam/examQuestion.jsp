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
            var examQuestion = {};
            examQuestion.questionContent = $('#questionContent').val();
            $('#examQuestion_grid').datagrid('load', examQuestion);
        }
        //清空列表 参数为从第几行开始
        function clearTable()
        {
            $('.tr_class').remove();
        }
        function doSubmit() {
            if($("#examQuestion_form").form('validate'))
            {
                var length=document.getElementById("tab_answer").rows.length;
                var jsonArray = [];
                for(var i=1;i<length;i++)
                {
                    var json = new Object;
                    json.optionContent=document.getElementById("tab_answer").rows[i].cells[0].firstChild.value;
                    json.isCorrect=$(document.getElementById("tab_answer").rows[i].cells[1]).find('input:checked').val();
                    json.optionNum=document.getElementById("tab_answer").rows[i].cells[2].firstChild.value;
                    jsonArray.push(json);
                }
                var formData=$(examQuestion_form).serialize();
                formData += '&opt=' + JSON.stringify(jsonArray);
                $.ajax({
                    url: examQuestion_form.action,
                    type: examQuestion_form.method,
                    data: formData,
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '题目已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#examQuestion_dialog').dialog('close');
                            $('#examQuestion_grid').datagrid('reload');
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
                examQuestion_form.reset();
                TT.resetForm('examQuestion_dialog');
                clearTable();
                examQuestion_form.action = 'addExamQuestion';
                $('#examQuestion_dialog').dialog('setTitle', '添加题目');
                $('#examQuestion_dialog').dialog('open');
            });
        });

        $(function(){
            $(document).on("click",'.aaa',function(){
                $(this).parent("td").parent("tr").remove();
            });
        });

        $(function() {
            $('#addAnswer').bind('click', function() {
                var t=Math.random();
                var html_answer='<tr class="tr_class"><td class="kv-content"><input type="text" name="optionContent"/></td>'+
                        '<td class="kv-content"><input type="radio" name="isCorrect'+t+'" value="1"/>是<input type="radio" name="isCorrect'+t+'" value="0"/>否</td>'+
                        '<td class="kv-content"><input type="text" name="optionNum"/></td>'+
                        '<td class="kv-content" id="tr_del"><a class="aaa">删除</a></td></tr>';
                $("#tab_answer").append(html_answer);
                $("#tab_answe").trigger("create");
            });
        });

        $(function() {
            $('#btn_remove').bind('click', function() {
                var rowData = $('#examQuestion_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'deleteExamQuestion/' + rowData.id;
                $.post(url, function(data) {
                    if (data == 'success') {
                        $('#examQuestion_grid').datagrid('reload');
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
            TT.resetForm('examQuestion_dialog');
            clearTable();
            $('#examQuestion_grid').datagrid('selectRow', id);
            var rowData = $('#examQuestion_grid').datagrid('getSelected');
            if (rowData != null) {
                //加载选项数据
                var url = 'findExamAnswersByQuestionId/' + rowData.id;
                $.post(url, function(data) {
                    if (data) {
                        for(var i=0;i<data.length;i++)
                        {
                            var checked1=data[i].isCorrect==1?'checked':'';
                            var checked0=data[i].isCorrect==0?'checked':'';
                            var t=Math.random();
                            var html_answer='<tr class="tr_class"><td class="kv-content"><input type="text" name="optionContent" value="'+data[i].optionContent+'"/></td>'+
                                    '<td class="kv-content"><input type="radio" name="isCorrect'+t+'" value="1" '+checked1+'/>是<input type="radio" name="isCorrect'+t+'" value="0" '+checked0+'/>否</td>'+
                                    '<td class="kv-content"><input type="text" name="optionNum" value="'+data[i].optionNum+'"/></td>'+
                                    '<td class="kv-content" id="tr_del"><a class="aaa">删除</a></td></tr>';
                            $("#tab_answer").append(html_answer);
                        }
                        $("#tab_answe").trigger("create");
                    } else {
                        $.messager.alert('提示', '获取数据失败：' + data);
                    }
                });

                $('#examQuestion_form').form('load', rowData);

            }
            examQuestion_form.action = "updateExamQuestion";
            $('#examQuestion_dialog').dialog('setTitle', '题目');
            $('#examQuestion_dialog').dialog('open');
        }


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="examQuestion_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            题目：<input type="text" id="questionContent">&nbsp;
            <a href="#" class="easyui-linkbutton" id="btn_Search"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            <a href="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            <a ref="#" class="easyui-linkbutton"
               data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
        </div>
    </div>
    <table id="examQuestion_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findExamQuestions" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'questionContent',align:'center'" width="30">题目名称</th>
            <th data-options="field:'questionType',align:'center',formatter:formatQuestionType"  width="20">类型</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作</th>
        </tr>
        </thead>
    </table>
</div>

<div id="examQuestion_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'题目管理',
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
                        $('#examQuestion_dialog').dialog('close');
                    }
                }]"
     style="width: 850px; height: 450px; padding: 10px;">


    <form id="examQuestion_form" name="examQuestion_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">题目管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">题目</td>
                            <td class="kv-content" colspan="3"><input type="text"name="questionContent" class="easyui-validatebox" data-options="required:true"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">类型</td>
                            <td class="kv-content"><input type="radio" name="questionType" value="1"/>单选
                                <input type="radio"name="questionType" value="2"/>多选</td>
                        </tr>

                        <tr>
                            <td class="kv-label">选项增加</td>
                            <td class="kv-content" colspan="3">
                                <div>
                                    <table id="tab_answer">
                                        <tr>
                                            <td class="kv-label">选项内容
                                            </td>
                                            <td class="kv-label">是否正确选项
                                            </td>
                                            <td class="kv-label">选项序数
                                            </td>
                                            <td class="kv-label">操作
                                            </td>
                                        </tr>
                                        <tr class="tr_class">
                                            <td class="kv-content"><input type="text" name="optionContent"/>
                                            </td>
                                            <td class="kv-content"><input type="radio" name="isCorrect" value="1"/>是
                                                <input type="radio" name="isCorrect" value="0"/>否
                                            </td>
                                            <td class="kv-content"><input type="text" name="optionNum"/>
                                            </td>
                                            <td class="kv-content" id="tr_del"><a class="aaa">删除</a>
                                            </td>
                                        </tr>
                                    </table>
                                    <div style="text-align:right; margin-right: 10px; margin-top: 10px;">
                                        <img style="width:30px;height: 30px;" id="addAnswer" src="/img/add_img_icon.png" alt="">
                                    </div>

                                </div>

                            </td>
                        </tr>

                        <tr>
                            <td class="kv-label">答案解读</td>
                            <td class="kv-content" colspan="3"><textarea name="explains" rows="5"></textarea></td>
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
