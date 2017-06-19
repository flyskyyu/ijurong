<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/21 0021
  Time: 下午 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="column"><span class="current">党内职务信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">党内职务</td>
            <td class="kv-content"><input type="text" name="name" class="easyui-validatebox" required="true"></td>
          </tr>
          </tbody>
        </table>
      </form>
      <div style="text-align: center;"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                                          id="edit_btn_add">保存</a>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" id="edit_btn_cancel">返回</a>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  $('#edit_btn_cancel').click(function () {
    $("#editWindow").window('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function onSubmit() {
    if($('#editContainer').data('disabled')) return;
    if(!$('#editForm').form('validate')) return;
    TT.disabledAllBtns('editContainer');
    $('#editForm').form('submit', {
      success: function (data) {
        if (data == "success") {
          $('#editWindow').dialog('close');
          $('#tableList').datagrid('reload');
        } else {
          $.messager.alert('提示', '提交失败!');
        }
      }
    });
  }
</script>