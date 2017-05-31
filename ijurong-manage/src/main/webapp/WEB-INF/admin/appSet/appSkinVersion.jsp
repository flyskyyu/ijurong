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
      var appSkinsVersion = {};
      appSkinsVersion.name = $('#name').val();
      $('#appSkinsVersion_grid').datagrid('load', appSkinsVersion);
    }
    function doSubmit() {
      $('#appSkinsVersion_form').form('submit', {
        success : function(data) {
          if (data == "had") {
            $.messager.alert('提示', '皮肤版本名称已存在!');
            return;
          }
          if (data == "success") {
            $('#appSkinsVersion_dialog').dialog('close');
            $('#appSkinsVersion_grid').datagrid('reload');
          } else {
            $.messager.alert('提示', '提交失败!');
          }
        }
      });
    }
    $(function() {
      $('#btn_add').bind('click', function() {
        appSkinsVersion_form.reset();
        appSkinsVersion_form.action = 'addAppSkinsVersion';
        $('#appSkinsVersion_dialog').dialog('setTitle', '添加皮肤版本');
        $('#level').combobox('clear');
        $('#appSkinsVersion_dialog').dialog('open');
      });
    });

    $(function() {
      $('#btn_remove').bind('click', function() {
        var rowData = $('#appSkinsVersion_grid').datagrid('getSelected');
        if (rowData == null) {
          return;
        }
        var url = 'delectAppSkinsVersion/' + rowData.id;
        $.post(url, function(data) {
          if (data == 'success') {
            $('#appSkinsVersion_grid').datagrid('reload');
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


    function openDialog(id) {
      appSkinsVersion_form.reset();
      $('#appSkinsVersion_grid').datagrid('selectRow', id);
      var rowData = $('#appSkinsVersion_grid').datagrid('getSelected');
      if (rowData != null) {
        $('#appSkinsVersion_form').form('load', rowData);
      }
      appSkinsVersion_form.action = "updateAppSkinsVersion";
      $('#appSkinsVersion_dialog').dialog('setTitle', '皮肤版本');
      $('#appSkinsVersion_dialog').dialog('open');
    }

  </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="appSkinsVersion_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      皮肤版本名：<input type="text" id="name">&nbsp;
      <a href="#" class="easyui-linkbutton" id="btn_Search"
         data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      <a ref="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
    </div>
  </div>
  <table id="appSkinsVersion_grid"
         class="easyui-datagrid" fitColumns="true" pagination="true"
         url="findAppSkinsVersions" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
    <thead>
    <tr>
      <th field="id" hidden="true"></th>
      <th data-options="field:'name',align:'center'" width="20">皮肤版本名称</th>
      <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
      <th data-options="field:'startTime',align:'center'"  width="20">生效时间</th>
      <th data-options="field:'version',align:'center'"  width="20">版本号</th>
      <th
              data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
              width="25">操作</th>
    </tr>
    </thead>
  </table>
</div>

<div id="appSkinsVersion_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'皮肤版本管理',
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
                        $('#appSkinsVersion_dialog').dialog('close');
                    }  
                }]"
     style="width: 660px; height: 350px; padding: 10px;">


  <form id="appSkinsVersion_form" name="appSkinsVersion_form"
        method="post" enctype="multipart/form-data">
    <div class="container">
      <div class="content">
        <div title="" data-options="closable:false"
             class="basic-info panel-body panel-body-noheader panel-body-noborder"
             style="width: 100%;">
          <div class="column"><span class="current">皮肤版本管理</span></div>
          <table class="kv-table">
            <tbody>
            <tr>
              <td class="kv-label">版本号</td>
              <td class="kv-content" colspan="3"><input type="text" name="version"/></td>
            </tr>
            <tr>
              <td class="kv-label">说明</td>
              <td class="kv-content" colspan="3"><input type="text" name="introduce"/></td>
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