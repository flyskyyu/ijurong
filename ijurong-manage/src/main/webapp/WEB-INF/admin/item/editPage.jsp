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
        <div class="column"><span class="current">物品信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">物品名称</td>
            <td class="kv-content"><input type="text" name="itemName" class="easyui-validatebox" required="true"></td>
            <td class="kv-label">物品数量</td>
            <td class="kv-content"><input type="text" name="num" class="easyui-validatebox" required="true"></td>
            <td class="kv-label">所需积分</td>
            <td class="kv-content"><input type="text" name="integral"></td>
          </tr>
          <tr>
            <td class="kv-label">物品类型</td>
            <td class="kv-content">
              <select name="type" class="easyui-combobox easyui-validatebox" required="true">
                <option value="1">实物</option>
                <option value="2">虚拟物品</option>
                <option value="3">其它</option>
              </select>
            </td>
            <td class="kv-label">物品所属</td>
            <td class="kv-content" colspan="3">
              <select name="belong" class="easyui-combobox easyui-validatebox" required="true">
                <option value="0">请选择</option>
                <option value="1">党员回馈</option>
                <option value="2">员工物品</option>
              </select> <span class="white_space"></span>提示：员工物品所需积分为0
            </td>
          </tr>
          <tr>
            <td class="kv-label">领取条件</td>
            <td class="kv-content" colspan="5"><textarea name="conditions" rows="3"></textarea></td>
          </tr>
          </tbody>
        </table>
        <div class="column"><span class="current">物品介绍</span></div>
        <!-- 加载编辑器的容器 -->
        <script id="ueditor" name="introduce" type="text/plain" style="width: 95%;height:200px;"></script>
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
    $('#editDialog').dialog('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function onSubmit() {
    if($('#editContainer').data('disabled')) return;
    if(!$('#editForm').form('validate')) return;
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