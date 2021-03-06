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
      <form  method="post" id="editForm">
        <input type="hidden" name="servicedUserId" id="servicedUserId"/>
        <input type="hidden" name="id"/>
        <div class="column"><span class="current">服务党员跟踪信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">组织名称</td>
            <td class="kv-content"><input type="text" name="organizationName" class="easyui-validatebox" required="true"/></td>
            <td class="kv-label">负责人姓名</td>
            <td class="kv-content"><input type="text" name="contactPersonName" class="easyui-validatebox" required="true"/></td>
          </tr>
          <tr>
            <td class="kv-label">被服务党员</td>
            <td class="kv-content"><input type="text" id="servicedUserName" readonly style="cursor:pointer;" name="staffName" class="easyui-validatebox" required="true"></td>
            <td class="kv-label">服务时间</td>
            <td class="kv-content"><input class="easyui-datebox" name="serviceDate"></td>
          </tr>
          <tr>
            <td class="kv-label">地址</td>
            <td class="kv-content" colspan="3"><input type="text" name="address"/></td>
          </tr>
          <tr>
            <td class="kv-label">跟踪情况</td>
            <td class="kv-content" colspan="3"><textarea name="situation" rows="5"></textarea></td>
          </tr>
          <tr>
            <td class="kv-label">服务结果</td>
            <td class="kv-content" colspan="3"><textarea name="result" rows="5"></textarea></td>
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
<div id="selectorWindow" class="easyui-window" title="选择人员"
     data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/common/userSelectorPage'"
     style="width:60%;height:80%;padding:10px;">
</div>
<script type="text/javascript">
  $('#edit_btn_cancel').click(function () {
    $("#editWindow").window('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  $('#servicedUserName').click(function() {
    $('#selectorWindow').window({
      onLoad: function() {
        $('#selectorTableList').datagrid({
          onClickRow: function(rowIndex, rowData) {
            $('#servicedUserId').val(rowData.staffId);
            $('#servicedUserName').val(rowData.staffName);
            $('#selectorWindow').window('close');
          }
        });
      }
    }).window('open');
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