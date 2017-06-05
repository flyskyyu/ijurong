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
      var news = {};
      news.title = $('#title').val();
      $('#news_grid').datagrid('load', news);
    }
    function doSubmit() {
      $('#news_form').form('submit', {
        success : function(data) {
          if (data == "success") {
            $('#news_dialog').dialog('close');
            $('#news_grid').datagrid('reload');
          } else {
            $.newsr.alert('提示', '提交失败!');
          }
        }
      });
    }
    $(function() {
      $('#btn_add').bind('click', function() {
        news_form.reset();
        news_form.action = 'addNews';
        $('#news_dialog').dialog('setTitle', '添加新闻');
        $('#level').combobox('clear');
        $('#news_dialog').dialog('open');
      });
    });

    $(function() {
      $('#btn_remove').bind('click', function() {
        var rowData = $('#news_grid').datagrid('getSelected');
        if (rowData == null) {
          return;
        }
        var url = 'delectNews/' + rowData.id;
        $.post(url, function(data) {
          if (data == 'success') {
            $('#news_grid').datagrid('reload');
          } else {
            $.newsr.alert('提示', '删除失败：消息发布中或系统异常');
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
              +'    <a href="#" onclick="doSubmitPost(' + rowIndex
              + ')" style="color:red;text-decoration:none;">发布</a>';
//      }
      return result;
    }

    function formatterStatus(value, rowData, rowIndex) {
      var result = "";
      if (rowData.status == '0') {
        result = '<a style="color:red;text-decoration:none;">已删除</a>';
      }
      else if (rowData.status == '1') {
        result = '<a style="color:green;text-decoration:none;">未发布</a>';
      }else {
        result = '<a style="color:grey;text-decoration:none;">已发布</a>';
      }
      return result;
    }





    function doSubmitPost(id) {
        $.messager.confirm('是否发布!', '请确认您的操作!', function(r){
            if (r){
                $('#news_grid').datagrid('selectRow', id);
                var rowData = $('#news_grid').datagrid('getSelected');
                  $.ajax({
                    type:"POST",
                    url:"sendNews/"+rowData.id,
                    success:function(data)
                        {
                          if (data == "success") {
                            $('#news_grid').datagrid('reload');
                          } else {
                            $.newsr.alert('提示', '提交失败!');
                          }
                        }
                  });
            }
            else
            {
              return;
            }
      });
    }

    function openDialog(id) {
      $('#news_grid').datagrid('selectRow', id);
      var rowData = $('#news_grid').datagrid('getSelected');
      if (rowData != null) {

        $('#news_form').form('load', rowData);

      }
      news_form.action = "updateNews";
      $('#news_dialog').dialog('setTitle', '新闻管理');
      $('#news_dialog').dialog('open');
    }


  </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
  <div id="news_toolbar" style="padding: 5px; height: auto">
    <div style="padding: 5px;">
      新闻名：<input type="text" id="title">&nbsp;
      <a href="#" class="easyui-linkbutton" id="btn_Search"
         data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
      <a href="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
      <a ref="#" class="easyui-linkbutton"
         data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
    </div>
  </div>
  <table id="news_grid"
         class="easyui-datagrid" fitColumns="true" pagination="true"
         url="findNewss" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;" singleSelect="true" >
    <thead>
    <tr>
      <th field="id" hidden="true"></th>
      <th data-options="field:'title',align:'center'" width="30">新闻名称</th>
      <th data-options="field:'createTime',align:'center'"  width="20">创建时间</th>
      <th data-options="field:'status',align:'center',formatter:formatterStatus"  width="20">状态</th>
      <th
              data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
              width="20">操作</th>
    </tr>
    </thead>
  </table>
</div>

<div id="news_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'新闻管理',
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
                        $('#news_dialog').dialog('close');
                    }  
                }]"
     style="width: 980px; height: 480px; padding: 10px;">


  <form id="news_form" name="news_form"
        method="post">
    <div class="container">
      <div class="content">
        <div title="" data-options="closable:false"
             class="basic-info panel-body panel-body-noheader panel-body-noborder"
             style="width: 100%;;">
          <div class="column"><span class="current">新闻管理</span></div>
          <table class="kv-table">
            <tbody>
            <tr>
              <td class="kv-label">新闻主标题</td>
              <td class="kv-content" colspan="3"><input type="text" name="title"/></td>
            </tr>
            <tr>
                <td class="kv-label">新闻副标题</td>
                <td class="kv-content" colspan="3"><input type="text" name="subtitle"/></td>
            </tr>
            <tr>
              <td class="kv-label" >新闻所属栏目:</td>
              <td class="kv-content">
                <input id="cc" class="easyui-combobox" name="programaId"
                       data-options="valueField:'id',textField:'name',url:'findAllProgramas'">
              </td>
                <td class="kv-label" >新闻所属专题:</td>
                <td class="kv-content">
                    <input id="cc2" class="easyui-combobox" name="specialId"
                           data-options="valueField:'id',textField:'name',url:'findAllNewsSpecials'">
                </td>
            </tr>
            <tr>
                <td class="kv-label">来源</td>
                <td class="kv-content" colspan="3"><input type="text" name="origin"/></td>
            </tr>
            <%--<tr>--%>
                <%--<td class="kv-label">点击数</td>--%>
                <%--<td class="kv-content"><input type="text" name="checkNum"/></td>--%>
            <%--</tr>--%>
            </tbody>
          </table>
          <div class="column"><span class="current">新闻内容</span></div>
          <!-- 加载编辑器的容器 -->
          <script id="editor" name="newsContent" type="text/plain" style="width:890px;height:400px;"></script>

        </div>
      </div>
    </div>
    <input type="hidden" value="0" name="id"/>
  </form>
</div>

</body>
</html>