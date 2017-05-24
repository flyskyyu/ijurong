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
        <input type="hidden" name="isAgree" id="isAgree" data_no_disabled/>
        <input type="hidden" name="id" data_no_disabled/>
        <div class="column"><span class="current">困难党员申请信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">困难党员姓名</td>
            <td class="kv-content"><input type="text" name="staffName"></td>
            <td class="kv-label">是否困难党员</td>
            <td class="kv-content">
              <input type="radio" name="isHardMember" value="1"/>是&nbsp;&nbsp;
              <input type="radio" name="isHardMember" value="0"/>否
            </td>
            <td class="kv-label">是否建国前入党老党员</td>
            <td class="kv-content">
              <input type="radio" name="isOldMember" value="1"/>是&nbsp;&nbsp;
              <input type="radio" name="isOldMember" value="0"/>否
            </td>
          </tr>
          <tr>
            <td class="kv-label">生活困难类型</td>
            <td class="kv-content">
              <select name="hardType" class="easyui-combobox">
                <option value="0"></option>
                <option value="1">生活困难</option>
                <option value="2">经济困难</option>
              </select>
            </td>
            <td class="kv-label">是否享受低保</td>
            <td class="kv-content">
              <input type="radio" name="isEnjoyMla" value="1"/>是&nbsp;&nbsp;
              <input type="radio" name="isEnjoyMla" value="0"/>否
            </td>
            <td class="kv-label">是否享受优抚优恤补助</td>
            <td class="kv-content">
              <input type="radio" name="isEnjoySubsidy" value="1"/>是&nbsp;&nbsp;
              <input type="radio" name="isEnjoySubsidy" value="0"/>否
            </td>
          </tr>
          <tr>
            <td class="kv-label">健康状况</td>
            <td class="kv-content" colspan="2">
              <select name="healthStatus" class="easyui-combobox">
                <option value="0"></option>
                <option value="1">身体健康</option>
                <option value="2">身体不健康</option>
              </select>
            </td>
            <td class="kv-label">户口所在派出所</td>
            <td class="kv-content" colspan="2"><input type="text" name="policeStation"/> </td>
          </tr>
          <tr>
            <td class="kv-label">困难情况补充</td>
            <td class="kv-content" colspan="5"><textarea name="hardDesc" rows="5"></textarea></td>
          </tr>
          <tr>
            <td class="kv-label">回复</td>
            <td class="kv-content" colspan="5"><textarea name="reply" rows="5" data_no_disabled id="replyInput"></textarea></td>
          </tr>
          </tbody>
        </table>
      </form>
      <div style="text-align: center;"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                                          id="edit_btn_add">同意</a>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-no'" id="edit_btn_no">不同意</a>
        &nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" id="edit_btn_cancel">返回</a>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  $('#edit_btn_no').click(function () {
    $('#isAgree').val(0);
    onSubmit();
  });

  $('#edit_btn_cancel').click(function () {
    $("#editWindow").window('close');
  });

  $('#edit_btn_add').click(function () {
    if($(this).attr('aria-disabled')) return;
    TT.disabledAllBtns();
    $('#isAgree').val(1);
    onSubmit();
  });

  function onSubmit() {
    if($(this).attr('aria-disabled')) return;
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