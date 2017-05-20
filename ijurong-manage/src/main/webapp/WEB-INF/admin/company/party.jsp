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
      var partyBranchInfo = {};
      partyBranchInfo.organizationName = $('#organizationName').val();
      $('#partyBranchInfo_grid').datagrid('load', partyBranchInfo);
    }
    function doSubmit() {
      $('#partyBranchInfo_form').form('submit', {
        success : function(data) {
          if (data == "had") {
            $.messager.alert('提示', '支部名已存在!');
            return;
          }
          if (data == "success") {
            $('#partyBranchInfo_dialog').dialog('close');
            $('#partyBranchInfo_grid').datagrid('reload');
          } else {
            $.messager.alert('提示', '提交失败!');
          }
        }
      });
    }
    $(function() {
      $('#btn_add').bind('click', function() {
        partyBranchInfo_form.reset();
        partyBranchInfo_form.action = 'addPartyBranchInfo';
        $('#partyBranchInfo_dialog').dialog('setTitle', '添加支部');
        $('#level').combobox('clear');
        $('#partyBranchInfo_dialog').dialog('open');
      });
    });

    $(function() {
      $('#btn_remove').bind('click', function() {
        var rowData = $('#partyBranchInfo_grid').datagrid('getSelected');
        if (rowData == null) {
          return;
        }
        var url = 'delectPartyBranchInfo/' + rowData.id;
        $.post(url, function(data) {
          if (data == 'success') {
            $('#partyBranchInfo_grid').datagrid('reload');
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
      $('#partyBranchInfo_grid').datagrid('selectRow', id);
      var rowData = $('#partyBranchInfo_grid').datagrid('getSelected');
      if (rowData != null) {

        $('#partyBranchInfo_form').form('load', rowData);

      }
      if(rowData.enterpriseId>0)
      {
        $.post('findEnterpriseInfoById/' + rowData.enterpriseId, function(data) {
          $('#refGrid').combogrid('setValue', data.name);
        });
      }
      partyBranchInfo_form.action = "updatePartyBranchInfo";
      $('#partyBranchInfo_dialog').dialog('setTitle', '支部帐号');
      $('#partyBranchInfo_dialog').dialog('open');
    }

    $(function() {
      $('#refGrid').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#enterpriseId').val(rowData.id);
        }
      });
    });


  </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="partyBranchInfo_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      支部名称：<input type="text" id="organizationName">&nbsp;<a href="#"
                                                 class="easyui-linkbutton" id="btn_Search"
                                                 data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp; <a
            href="#" class="easyui-linkbutton"
            data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
    </div>
  </div>
  <table id="partyBranchInfo_grid"
         class="easyui-datagrid" fitColumns="true" pagination="true"
         url="findPartyBranchInfos" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >

    <%--class="easyui-datagrid"--%>
    <%--data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findPartyBranchInfos',striped:true,toolbar:'#partyBranchInfos_toolbar'">--%>
    <thead>
    <tr>
      <th field="id" hidden="true"></th>
      <th data-options="field:'organizationName',align:'center'" width="30">支部名称</th>
      <th data-options="field:'organizationType',align:'center',formatter:formatType"  width="20">组织类型</th>
      <th data-options="field:'setupDate',align:'center'" width="20">成立日期</th>
      <th data-options="field:'phoneNumber',align:'center'" width="20">联系电话</th>
      <th
              data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
              width="20">操作</th>
    </tr>
    </thead>
  </table>
</div>

<div id="partyBranchInfo_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'支部管理',
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
                        $('#partyBranchInfo_dialog').dialog('close');
                    }  
                }]"
     style="width: 400px; height: 500px; padding: 10px;">
  <form id="partyBranchInfo_form" name="partyBranchInfo_form"
        method="post">
    <table
            style='font-size: 12px; padding: 2px; border-collapse: separate;border-spacing: 5px;'
            class="dialog_table" cellpadding="0">
      <tr>
        <td class="my-td">组织名称:</td>
        <td class="field_color"><input type="text" name="organizationName" required="true" /></td>
      </tr>
      <tr>
        <td class="my-td">组织代码:</td>
        <td class="field_color"><input type="text" name="organizationCode" required="true" /></td>
      </tr>
      <tr>
        <td class="my-td">上级组织:</td>
        <td class="field_color"><input type="text" name="superiorOrganization" required="true" /></td>
      </tr>
      <tr>
        <td class="my-td">属地关系:</td>
        <td class="field_color"><input type="text" name="relationship" required="true" /></td>
      </tr>
      <tr>
        <td>组织地址:</td>
        <td class="field_color"><input type="text" name="address" /></td>
      </tr>
      <tr>
        <td>组织电话:</td>
        <td class="field_color"><input type="text" name="phoneNumber" validType="phone" /></td>
      </tr>
      <tr>
        <td>邮政编码:</td>
        <td class="field_color"><input type="text" name="postalCode" validType="phone" /></td>
      </tr>
      <tr>
        <td>组织机构代码:</td>
        <td class="field_color"><input type="text" name="code" /></td>
      </tr>
      <tr>
        <td>成立时间:</td>
        <td class="field_color"><input class="easyui-datebox" name="setupDate"></td>
      </tr>
      <tr>
        <td>备注:</td>
        <td class="field_color"><input type="text"  name="remark"></td>
      </tr>


          <tr>
            <td>所属企业:</td>
            <td><select id="refGrid" class="easyui-combogrid"
                        style="width: 230px"
                        data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findEnterpriseInfoByName',
				            columns: [[
				            {field:'name',title:'企业名称',width:100},
				                 {field:'address',title:'公司地址',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
            </select></td>
          </tr>
        <input type="hidden" id="enterpriseId" name="enterpriseId" value="0" />
    </table>
    <input type="hidden" value="0" name="id" id="id" />
  </form>
</div>
</body>
</html>