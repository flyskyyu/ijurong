<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/21 0021
  Time: 下午 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="container" id="editContainer">
  <div class="content">
    <div title="" data-options="closable:false"
         class="basic-info panel-body panel-body-noheader panel-body-noborder"
         style="width: 100%;;">
      <form method="post" id="editForm">
        <input type="hidden" name="id"/>
        <div class="column"><span class="current">优秀党员信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">优秀党员姓名</td>
            <td class="kv-content">
              <select id="editUserName" class="easyui-combogrid" name="userId"
                      style="width: 230px"
                      data-options="mode:'remote',
                            delay: 700,
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'staffId',
							textField: 'staffName',
							url: '<%=basePath%>admin/staff/listByQ',
				            columns: [[
				            {field:'staffName',title:'姓名',width:100},
				                 {field:'phoneNumber',title:'电话',width:120}
				            ]],
				            fitColumns: true
				            ">
              </select>
            </td>
            <td class="kv-label">当选时间</td>
            <td class="kv-content"><input class="easyui-datebox" name="selectionDate"></td>
          </tr>
          </tbody>
        </table>
        <div class="column"><span class="current">先进事迹</span></div>
        <!-- 加载编辑器的容器 -->
        <script id="ueditor" name="meritoriousDeeds" type="text/plain" style="width: 98%;height:200px;"></script>
      </form>
      <div style="text-align: center;"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                                          id="edit_btn_add">保存</a>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" id="edit_btn_cancel">返回</a>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  var uEditor = UE.getEditor('ueditor');
  $('#edit_btn_cancel').click(function () {
    $("#editDialog").dialog('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function onSubmit() {
    if($('#editContainer').data('disabled')) return;
    TT.disabledAllBtns('editContainer');
    $.ajax({
      url: editForm.action,
      type: editForm.method,
      data: $(editForm).serialize(),
      success: function (data) {
        if (data == "success") {
          $('#editDialog').dialog('close');
          $('#tableList').datagrid('reload');
        } else {
          $.messager.alert('提示', '提交失败!');
        }
      },
      error: function() {
        $.messager.alert('提示', '服务器内部错误!');
      }
    });
  }
</script>