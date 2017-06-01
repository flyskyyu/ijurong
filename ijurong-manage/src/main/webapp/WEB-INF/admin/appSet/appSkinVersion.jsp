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
        appSkinsVersion_form.action = 'addAppSkinVersion';
        $("#img_uploaded_url1").hide();
        $("#img_uploaded_url2").hide();
        $("#img_uploaded_url3").hide();
        $("#img_uploaded_url4").hide();
        $("#img_uploaded_url5").hide();
        $("#img_uploaded_url6").hide();
        $("#img_uploaded_url7").hide();
        $("#img_uploaded_url8").hide();

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
        var url = 'delectAppSkinVersion/' + rowData.id;
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
        if(rowData.url1!=null&&rowData.url1!="")
        {
          $("#img_uploaded_url1").attr('src',rowData.url1);
          $("#img_uploaded_url1").show();
        }
        else
        {
          $("#img_uploaded_url1").hide();
        }
        if(rowData.url2!=null&&rowData.url2!="")
        {
          $("#img_uploaded_url2").attr('src',rowData.url2);
          $("#img_uploaded_url2").show();
        }
        else
        {
          $("#img_uploaded_url2").hide();
        }
        if(rowData.url3!=null&&rowData.url3!="")
        {
          $("#img_uploaded_url3").attr('src',rowData.url3);
          $("#img_uploaded_url3").show();
        }
        else
        {
          $("#img_uploaded_url3").hide();
        }
        if(rowData.url4!=null&&rowData.url4!="")
        {
          $("#img_uploaded_url4").attr('src',rowData.url4);
          $("#img_uploaded_url4").show();
        }
        else
        {
          $("#img_uploaded_url4").hide();
        }
        if(rowData.url5!=null&&rowData.url5!="")
        {
          $("#img_uploaded_url5").attr('src',rowData.url5);
          $("#img_uploaded_url5").show();
        }
        else
        {
          $("#img_uploaded_url5").hide();
        }
        if(rowData.url6!=null&&rowData.url6!="")
        {
          $("#img_uploaded_url6").attr('src',rowData.url6);
          $("#img_uploaded_url6").show();
        }
        else
        {
          $("#img_uploaded_url6").hide();
        }
        if(rowData.url7!=null&&rowData.url7!="")
        {
          $("#img_uploaded_url7").attr('src',rowData.url7);
          $("#img_uploaded_url7").show();
        }
        else
        {
          $("#img_uploaded_url7").hide();
        }
        if(rowData.url8!=null&&rowData.url8!="")
        {
          $("#img_uploaded_url8").attr('src',rowData.url8);
          $("#img_uploaded_url8").show();
        }
        else
        {
          $("#img_uploaded_url8").hide();
        }
      }

      appSkinsVersion_form.action = "updateAppSkinVersion";
      $('#appSkinsVersion_dialog').dialog('setTitle', '皮肤版本');
      $('#appSkinsVersion_dialog').dialog('open');
    }

    $(function() {

    });


    $(function() {
      $('#refGrid1').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url1').val(rowData.url);
          $("#img_uploaded_url1").attr('src',rowData.url);
          $("#img_uploaded_url1").show();
        }
      });
      $('#refGrid2').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url2').val(rowData.url);
          $("#img_uploaded_url2").attr('src',rowData.url);
          $("#img_uploaded_url2").show();
        }
      });
      $('#refGrid3').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url3').val(rowData.url);
          $("#img_uploaded_url3").attr('src',rowData.url);
          $("#img_uploaded_url3").show();
        }
      });
      $('#refGrid4').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url4').val(rowData.url);
          $("#img_uploaded_url4").attr('src',rowData.url);
          $("#img_uploaded_url4").show();
        }
      });
      $('#refGrid5').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url5').val(rowData.url);
          $("#img_uploaded_url5").attr('src',rowData.url);
          $("#img_uploaded_url5").show();
        }
      });
      $('#refGrid6').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url6').val(rowData.url);
          $("#img_uploaded_url6").attr('src',rowData.url);
          $("#img_uploaded_url6").show();
        }
      });
      $('#refGrid7').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url7').val(rowData.url);
          $("#img_uploaded_url7").attr('src',rowData.url);
          $("#img_uploaded_url7").show();
        }
      });
      $('#refGrid8').combogrid({
        onSelect : function(rowIndex, rowData) {
          $('#url8').val(rowData.url);
          $("#img_uploaded_url8").attr('src',rowData.url);
          $("#img_uploaded_url8").show();
        }
      });
    });

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
         url="findAppSkinVersions" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
    <thead>
    <tr>
      <th data-options="field:'name',align:'center'" width="20">名称</th>
      <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
      <th data-options="field:'startTime',align:'center'"  width="20">生效时间</th>
      <th data-options="field:'id',align:'center'"  width="20">版本号</th>
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
     style="width: 660px; height: 500px; padding: 10px;">


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
              <td class="kv-label">名称</td>
              <td class="kv-content" colspan="3"><input type="text" name="name"/></td>
            </tr>
            <tr>
              <td class="kv-label">说明</td>
              <td class="kv-content" colspan="3"><input type="text" name="introduce"/></td>
            </tr>
            <tr>
              <td class="kv-label">生效时间</td>
              <td class="kv-content" colspan="3"><input class="easyui-datetimebox" name="startTime"/></td>
            </tr>
            <tr>
              <td class="kv-label">图片1</td>
              <td class="kv-content" colspan="3"><select id="refGrid1" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片1" id ="img_uploaded_url1"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片2</td>
              <td class="kv-content" colspan="3"><select id="refGrid2" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片2" id ="img_uploaded_url2"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片3</td>
              <td class="kv-content" colspan="3"><select id="refGrid3" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片3" id ="img_uploaded_url3"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片4</td>
              <td class="kv-content" colspan="3"><select id="refGrid4" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片4" id ="img_uploaded_url4"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片5</td>
              <td class="kv-content" colspan="3"><select id="refGrid5" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片5" id ="img_uploaded_url5"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片6</td>
              <td class="kv-content" colspan="3"><select id="refGrid6" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片6" id ="img_uploaded_url6"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片7</td>
              <td class="kv-content" colspan="3"><select id="refGrid7" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片7" id ="img_uploaded_url7"style="width: 72px;height: 72px;"></td>
            </tr>
            <tr>
              <td class="kv-label">图片8</td>
              <td class="kv-content" colspan="3"><select id="refGrid8" class="easyui-combogrid"
                                                         style="width: 230px"
                                                         data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findAppSkinssByName',
				            columns: [[
				            {field:'name',title:'图片名称',width:100},
				                 {field:'createTime',title:'创建时间',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
              </select><br/>
                <img src="#" alt="已上传图片8" id ="img_uploaded_url8"style="width: 72px;height: 72px;"></td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <input type="hidden" value="0" name="id" id="id" />
    <input type="hidden" value="" name="url1" id="url1" />
    <input type="hidden" value="" name="url2" id="url2" />
    <input type="hidden" value="" name="url3" id="url3" />
    <input type="hidden" value="" name="url4" id="url4" />
    <input type="hidden" value="" name="url5" id="url5" />
    <input type="hidden" value="" name="url6" id="url6" />
    <input type="hidden" value="" name="url7" id="url7" />
    <input type="hidden" value="" name="url8" id="url8" />

  </form>
</div>
</body>
</html>