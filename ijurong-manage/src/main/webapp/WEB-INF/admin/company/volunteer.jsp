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
  <style type="text/css">
    input {
      margin: 5px 5px 5px 0px;
      font-size: 15px;
    }

    .dialog_table td {
      text-align: right;
      font-size: 15px;
      width: auto;
      background-color: #FFFFFF;
      border: 0px;
    }
    .dialog_table td input{
      width: 200px;
      height: 20px;
      font-size: 15px;
      border-width: 1px;
      border-style: solid;
      border-left-color: #c5c5c5;
      border-top-color: #c5c5c5;
      border-right-color: #e0e0e0;
      border-bottom-color: #e0e0e0;
      outline: none;
      padding: 0 10px;
    }
    .dialog_table td select {
      width: 200px;
      height: 20px;
      font-size: 15px;
      padding: 0 10px;
    }
    .combobox-item
    {
      font-size: 15px;
      padding: 0 10px;
    }
    .textbox .textbox-text
    {
      font-size: 15px;
      padding: 0 10px;
    }

    .dialog_table td select option{
      font-size: 15px;
    }

    .dialog_table .field_color {
      text-align: left;
      background-color: white;
      padding-left: 2px;
    }

  </style>
  <script type="text/javascript">
    function doSearch() {
      var volunteer = {};
      volunteer.name = $('#name').val();
      volunteer.sex=$('#sex').val();
      $('#volunteer_grid').datagrid('load', volunteer);
    }
    function doSubmit() {
      $('#volunteer_form').form('submit', {
        success : function(data) {
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
        }
      });
    }
    $(function() {
      $('#btn_add').bind('click', function() {
        volunteer_form.reset();
        volunteer_form.action = 'addVolunteer';
        $('#volunteer_dialog').dialog('setTitle', '添加志愿者');
        $('#level').combobox('clear');
        $('#volunteer_dialog').dialog('open');
      });
    });

    $(function() {
      $('#btn_remove').bind('click', function() {
        var rowData = $('#volunteer_grid').datagrid('getSelected');
        if (rowData == null) {
          return;
        }
        var url = 'delectVolunteer/' + rowData.id;
        $.post(url, function(data) {
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
      性别：<select id="sex" class="easyui-combobox" style="width: 200px;height: 23px;font-size: 15px;padding: 0 10px;">
      <option value="0" selected>请选择</option>
      <option value="1">男</option>
      <option value="2">女</option>
    </select>
      <a href="#" class="easyui-linkbutton" id="btn_Search"
                                                  data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <%--<a href="#" class="easyui-linkbutton"--%>
         <%--data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;--%>
      <a ref="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
    </div>
  </div>
  <table id="volunteer_grid"
         class="easyui-datagrid" fitColumns="true" pagination="true"
         url="findVolunteers" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >

    <%--class="easyui-datagrid"--%>
    <%--data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findVolunteers',striped:true,toolbar:'#volunteers_toolbar'">--%>
    <thead>
    <tr>
      <th field="id" hidden="true"></th>
      <th field="userId" hidden="true"></th>
      <th data-options="field:'name',align:'center'" width="30">志愿者名称</th>
      <th data-options="field:'sex',align:'center',formatter:formatSex"  width="20">性别</th>
      <th data-options="field:'address',align:'center'" width="20">地址</th>
      <th data-options="field:'phoneNumber',align:'center'" width="20">电话</th>
      <th
              data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
              width="20">操作</th>
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
     style="width: 400px; height: 500px; padding: 10px;">
  <form id="volunteer_form" name="volunteer_form"
        method="post">
    <table
            style='font-size: 12px; padding: 2px; border-collapse: separate;border-spacing: 5px;'
            class="dialog_table" cellpadding="0">
      <tr>
        <td class="my-td">志愿者名称:</td>
        <td class="field_color"><input type="text" name="name" required="true" /></td>
      </tr>
      <tr>
        <td>性别:</td>
        <td class="field_color"><select name="sex"
                                        class="easyui-combobox" >
          <option value="0"></option>
          <option value="1">男</option>
          <option value="2">女</option>
        </select></td>
      </tr>
      <tr>
        <td>年龄:</td>
        <td class="field_color"><input type="text" name="age" /></td>
      </tr>
      <tr>
        <td>联系电话:</td>
        <td class="field_color"><input type="text" name="phoneNumber" validType="phone" /></td>
      </tr>
      <tr>
        <td>地址:</td>
        <td class="field_color"><input type="text" name="address" /></td>
      </tr>
      <tr>
        <td>服务时间:</td>
        <td class="field_color"><input type="text" name="time" /></td>
      </tr>
      <tr>
        <td>特长:</td>
        <td class="field_color"><input type="text" name="specialty" /></td>
      </tr>
      <tr>
        <td>服务意向:</td>
        <td class="field_color"><input type="text" name="intention" /></td>
      </tr>
      <tr>
        <td>服务范围:</td>
        <td class="field_color"><input type="text" name="ranges" /></td>
      </tr>


    </table>
    <input type="hidden" value="0" name="id" id="id" />
    <input type="hidden" value="0" name="userId" id="userId" />
  </form>
</div>
</body>
</html>