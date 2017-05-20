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

  <%--<link rel="stylesheet" type="text/css" href="../../css/skin_/form.css" />--%>
  <%--<link rel="stylesheet" type="text/css" href="../../css/style.css" />--%>
  <%--<link rel="stylesheet" type="text/css" href="../../css/WdatePicker.css" />--%>

  <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
  <script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript"
          src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
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
      if($('#name').val()==null||$('#name').val()=="")
      {
        return;
      }
      var enterpriseInfo = {};
      enterpriseInfo.name = $('#name').val();
      $('#enterpriseInfo_grid').datagrid('load', enterpriseInfo);
    }
    function doSubmit() {
      $('#enterpriseInfo_form').form('submit', {
        success : function(data) {
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
        }
      });
    }
    $(function() {
      $('#btn_add').bind('click', function() {
        enterpriseInfo_form.reset();
        enterpriseInfo_form.action = 'addEnterpriseInfo';
        $('#enterpriseInfo_dialog').dialog('setTitle', '添加企业');
        $('#level').combobox('clear');
        $('#enterpriseInfo_dialog').dialog('open');
      });
    });

    $(function() {
      $('#btn_remove').bind('click', function() {
        var rowData = $('#enterpriseInfo_grid').datagrid('getSelected');
        if (rowData == null) {
          return;
        }
        var url = 'delectEnterpriseInfo/' + rowData.id;
        $.post(url, function(data) {
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
//      if (rowData.level == '0') {
//        result = '<a style="color:red;text-decoration:none;">管理员</a>';
//      } else {
        result = '<a href="#" onclick="openDialog(' + rowIndex
        + ')" style="color:green;text-decoration:none;">操作</a>';
//      }
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
      企业名称：<input type="text" id="name">&nbsp;<a href="#"
                                               class="easyui-linkbutton" id="btn_Search"
                                               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp; <a
            href="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
    </div>
  </div>
  <table id="enterpriseInfo_grid"
         class="easyui-datagrid" fitColumns="true" pagination="true"
         url="findEnterpriseInfos" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >

         <%--class="easyui-datagrid"--%>
         <%--data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findEnterpriseInfos',striped:true,toolbar:'#enterpriseInfos_toolbar'">--%>
    <thead>
    <tr>
      <th field="id" hidden="true"></th>
      <th data-options="field:'name',align:'center'" width="30">企业名称</th>
      <th data-options="field:'type',align:'center',formatter:formatType"  width="20">公司类型</th>
      <th data-options="field:'address',align:'center'" width="20">公司地址</th>
      <th data-options="field:'phone',align:'center'" width="20">公司电话</th>
      <th
              data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
              width="20">操作</th>
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
     style="width: 400px; height: 400px; padding: 10px;">
  <form id="enterpriseInfo_form" name="enterpriseInfo_form"
        method="post">
    <table
            style='font-size: 12px; padding: 2px; border-collapse: separate;border-spacing: 5px;'
            class="dialog_table" cellpadding="0">
      <tr>
        <td class="my-td">企业名称:</td>
        <td class="field_color"><input type="text" name="name" required="true" /></td>
      </tr>
      <tr>
        <td>公司类型:</td>
        <td class="field_color"><select name="type"
                                        class="easyui-combobox" >
          <option value="1">国企</option>
          <option value="2">民营</option>
          <option value="3">外资</option>
          <option value="4">合资</option>
          <option value="5">其他</option>
        </select></td>
      </tr>
      <tr>
        <td>公司地址:</td>
        <td class="field_color"><input type="text" name="address" /></td>
      </tr>
      <tr>
        <td>公司电话:</td>
        <td class="field_color"><input type="text" name="phone" validType="phone" /></td>
      </tr>
      <tr>
        <td>组织机构代码:</td>
        <td class="field_color"><input type="text" name="code" /></td>
      </tr>
      <tr>
        <td>成立时间:</td>
        <td class="field_color"><input class="easyui-datetimebox" name="createDate"></td>
      </tr>

        <%--<h2 class="subfild">--%>
          <%--<span>基本信息</span>--%>
        <%--</h2>--%>
        <%--<div class="subfild-content base-info">--%>
          <%--<div class="kv-item ue-clear">--%>
            <%--<label><span class="impInfo">*</span>企业名称</label>--%>
            <%--<div class="kv-item-content">--%>
              <%--<input type="text" name="name" placeholder="文章标题" class="required">--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<div class="kv-item ue-clear">--%>
            <%--<label>公司类型</label>--%>
            <%--<div class="kv-item-content">--%>
              <%--<div id="_iSelWrap_iSel-3813" class="iselect-wrapper"><select id="iSel-3813" class="iselect">--%>
                <%--<option value="1">国企</option>--%>
                <%--<option value="2">民营</option>--%>
                <%--<option value="3">外资</option>--%>
                <%--<option value="4">合资</option>--%>
                <%--<option value="5">其他</option>--%>
              <%--</select></div>--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<div class="kv-item ue-clear">--%>
            <%--<label><span class="impInfo">*</span>公司地址</label>--%>
            <%--<div class="kv-item-content">--%>
              <%--<input type="text" name="address" placeholder="公司地址">--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<div class="kv-item ue-clear">--%>
            <%--<label><span class="impInfo">*</span>公司电话</label>--%>
            <%--<div class="kv-item-content">--%>
              <%--<input type="text" name="phone" placeholder="公司电话">--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<div class="kv-item ue-clear">--%>
            <%--<label><span class="impInfo">*</span>组织机构代码</label>--%>
            <%--<div class="kv-item-content">--%>
              <%--<input type="text" name="code" placeholder="组织机构代码">--%>
            <%--</div>--%>
          <%--</div>--%>

          <%--<div class="kv-item ue-clear time">--%>
            <%--<label><span class="impInfo">*</span>成立时间</label>--%>
            <%--<div class="kv-item-content">--%>
              <%--<input type="text" name="createTime" placeholder="成立时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">--%>
              <%--<i class="time-icon"></i>--%>
            <%--</div>--%>
          <%--</div>--%>
        <%--</div>--%>


    </table>
    <input type="hidden" value="0" name="id" id="id" />
  </form>
</div>
</body>
</html>