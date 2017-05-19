<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>后台帐号管理</title>
  <link rel="stylesheet" type="text/css"
        href="../../easyui/themes/gray/easyui.css" />
  <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css" />
  <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
  <script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript"
          src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
  <style type="text/css">
    input {
      margin: 5px 5px 5px 0px;
      font-size: 12px;
    }

    .dialog_table td {
      border: #d0ccc9 1px solid;
      background-color: #f4f4f4;
      text-align: right;
    }

    .dialog_table .field_color {
      text-align: left;
      background-color: white;
      padding-left: 2px;
    }
  </style>
  <script type="text/javascript">
    function doSearch() {
      var company = {};
      company.name = $('#name').val();
      $('#company_grid').datagrid('load', company);
    }
    function doSubmit() {
      $('#company_form').form('submit', {
        success : function(data) {
          if (data == "had") {
            $.messager.alert('提示', '企业名已存在!');
            return;
          }
          if (data == "success") {
            $('#company_dialog').dialog('close');
            $('#company_grid').datagrid('reload');
          } else {
            $.messager.alert('提示', '提交失败!');
          }
        }
      });
    }
    $(function() {
      $('#btn_add').bind('click', function() {
        company_form.reset();
        company_form.action = 'addCompany';
        $('#company_dialog').dialog('setTitle', '添加企业');
        $('#level').combobox('clear');
        $('#company_dialog').dialog('open');
      });
    });

    $(function() {
      $('#btn_remove').bind('click', function() {
        var rowData = $('#company_grid').datagrid('getSelected');
        if (rowData == null) {
          return;
        }
        var url = 'delectCompany/' + rowData.id;
        $.post(url, function(data) {
          if (data == 'success') {
            $('#company_grid').datagrid('reload');
          } else {
            $.messager.alert('提示', '删除失败：' + data);
          }
        });
      });
    });

    function formatOperation(value, rowData, rowIndex) {
      var result = "";
      if (rowData.level == '0') {
        result = '<a style="color:red;text-decoration:none;">管理员</a>';
      } else {
        result = '<a href="#" onclick="openDialog(' + rowIndex
        + ')" style="color:green;text-decoration:none;">操作</a>';
      }
      return result;
    }

    function openDialog(id) {
      $('#company_grid').datagrid('selectRow', id);
      var rowData = $('#company_grid').datagrid('getSelected');
      if (rowData != null) {

        $('#company_form').form('load', rowData);

      }
      company_form.action = "updateCompany";
      $('#company_dialog').dialog('setTitle', '企业帐号');
      $('#company_dialog').dialog('open');
    }


  </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="company_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      企业名称：<input type="text" id="name">&nbsp;<a href="#"
                                               class="easyui-linkbutton" id="btn_Search"
                                               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp; <a
            href="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
    </div>
  </div>
  <table id="company_grid" style="width: auto; height: 638px"
         class="easyui-datagrid"
         data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findCompanys',striped:true,toolbar:'#drug_biologicals_toolbar'">
    <thead>
    <tr>
      <th field="id" hidden="true"></th>
      <th field="name" width="30">企业名称</th>
      <th field="type" width="20">公司类型</th>
      <th field="address" width="20">公司地址</th>
      <th field="phone" width="20">公司电话</th>
      <th
              data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
              width="20">操作</th>
    </tr>
    </thead>
  </table>
</div>

<div id="company_dialog" class="easyui-dialog"
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
                        $('#drug_chinese_herbal_pieces_dialog').dialog('close');
                    }  
                }]"
     style="width: 260px; height: 340px; padding: 10px;">
  <form id="company_form" name="company_form"
        method="post">
    <table
            style='font-size: 12px; padding: 2px; border-collapse: collapse; margin: auto'
            class="dialog_table" cellpadding="0">
      <tr>
        <td>企业名称:</td>
        <td class="field_color"><input type="text" name="name" /></td>
      </tr>
      <tr>
        <td>公司类型:</td>
        <td class="field_color"><input type="text" name="type" /></td>
      </tr>
      <tr>
        <td>公司地址:</td>
        <td class="field_color"><input type="text" name="address" /></td>
      </tr>
      <tr>
        <td>公司电话:</td>
        <td class="field_color"><input type="text" name="phone" /></td>
      </tr>
      <tr>
        <td>组织机构代码:</td>
        <td class="field_color"><input type="text" name="code" /></td>
      </tr>
      <tr>
        <td>成立时间:</td>
        <td class="field_color"><input type="text" name="create_date" /></td>
      </tr>
    </table>
    <input type="hidden" value="0" name="id" id="id" />
  </form>
</div>
</body>
</html>