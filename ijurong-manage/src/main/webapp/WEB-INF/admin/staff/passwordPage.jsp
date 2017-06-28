<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>修改密码</title>
  <jsp:include page="../contentHeader.jsp"/>
</head>
<body class="easyui-layout">
<div class="container" id="editContainer">
  <div class="content">
    <div title="" data-options="closable:false"
         class="basic-info panel-body panel-body-noheader panel-body-noborder"
         style="width: 100%;;">
      <form method="post" action="changePassword" id="editForm">
        <input type="hidden" name="id"/>
        <input type="hidden" name="imgs" id="uploadImagesInput"/>
        <div class="column"><span class="current">修改密码</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">旧密码</td>
            <td class="kv-content">
              <input type="text" name="oldPassword" class="easyui-validatebox" required="true"/>
            </td>
          </tr>
          <tr>
            <td class="kv-label">新密码</td>
            <td class="kv-content">
              <input type="password" name="password" id="password" class="easyui-validatebox" required="true"/>
            </td>
          </tr>
          <tr>
            <td class="kv-label">确认新密码</td>
            <td class="kv-content">
              <input type="password" id="confirmPassword" class="easyui-validatebox" required="true"/>
            </td>
          </tr>
          </tbody>
        </table>
      </form>
      <div style="text-align: center;"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                                          id="edit_btn_add">保存</a>&nbsp;&nbsp;&nbsp;
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function onSubmit() {
    if($('#password').val() != $('#confirmPassword').val()) {
      $.messager.alert('提示', '新密码不一致!');
      return;
    }
    if($('#editContainer').data('disabled')) return;
    if(!$('#editForm').form('validate')) return;
    TT.disabledAllBtns('editContainer');
    $('#editForm').form('submit', {
      success: function (data) {
        TT.enabledAllBtns();
        if (data == "success") {
          $.messager.alert('提示', '更改成功!');
        } else if(data == 'password_recorrect') {
          $.messager.alert('提示', '旧密码不正确!');
        } else {
          $.messager.alert('提示', '提交失败!');
        }
      }
    });
  }
</script>
</body>
</html>