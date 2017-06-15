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
        <input type="hidden" name="id" id="idInput"/>
        <input type="hidden" name="iconUrl" id="avatar"/>
        <div class="column"><span class="current">权限信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">权限名称</td>
            <td class="kv-content"><input type="text" name="permissionName"></td>
            <td class="kv-label">权限编码</td>
            <td class="kv-content"><input type="text" name="permissionCode"></td>
            <td class="kv-label">父权限</td>
            <td class="kv-content">
              <select id="permissionCombogridId" class="easyui-combogrid" name="parentId"
                      style="width: 230px"
                      data-options="mode:'remote',
                            delay: 700,
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'permissionName',
							url: '<%=basePath%>admin/permission/listByQ',
				            columns: [[
				            {field:'permissionName',title:'权限',width:120},
				                 {field:'permissionCode',title:'编码',width:120}
				            ]],
				            fitColumns: true
				            ">
              </select>
            </td>
          </tr>
          <tr>
            <td class="kv-label">是否生成菜单</td>
            <td class="kv-content">
              <input type="radio" value="1" name="generateMenu"> 是
              <input type="radio" value="0" name="generateMenu"> 否
            </td>
            <td class="kv-label">网页URL</td>
            <td class="kv-content">
              <input type="text" name="url"/>
            </td>
            <td class="kv-label">图标URL</td>
            <td class="kv-content"><jsp:include page="../common/avatarUpload.jsp"/></td>
          </tr>
          <tr>
            <td class="kv-label">备注</td>
            <td class="kv-content" colspan="3">
              <input type="text" name="remark"/>
            </td>
            <td class="kv-label">排序</td>
            <td class="kv-content">
              <input type="text" name="showOrder"/>
            </td>
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
    $('#editDialog').dialog('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function onSubmit() {
    var parentId = $('#permissionCombogridId').combogrid('getValue');
    if(parentId && parentId == $('#idInput').val()) {
      $.messager.alert('提示', '父权限不能是自己!');
      return;
    }
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