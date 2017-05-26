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
          <input type="hidden" name="staffId" id="editUserId"/>
        <div class="column"><span class="current">困难党员申请信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">困难党员姓名</td>
            <td class="kv-content"><input type="text" name="staffName" id="editUserName" readonly style="cursor:pointer;"></td>
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
      <div style="text-align: center;" id="editBtnGroup"></div>
    </div>
  </div>
</div>
<div id="selectorWindow" class="easyui-window" title="选择人员"
     data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/common/userSelectorPage'"
     style="width:60%;height:80%;padding:10px;">
</div>
<script type="text/javascript">
    $('#editContainer').on('click', '#edit_btn_no', function() {
        $('#isAgree').val(0);
        onSubmit();
    });

    $('#editContainer').on('click', '#edit_btn_yes', function() {
        $('#isAgree').val(1);
        onSubmit();
    });

    $('#editContainer').on('click', '#edit_btn_cancel', function() {
        $("#editWindow").window('close');
    });

    $('#editContainer').on('click', '#edit_btn_ok', function() {
        onSubmit();
    });

    $('#editUserName').click(function() {
        $('#selectorWindow').window({
            onLoad: function() {
                $('#selectorTableList').datagrid({
                    onClickRow: function(rowIndex, rowData) {
                        $('#editUserId').val(rowData.staffId);
                        $('#editUserName').val(rowData.staffName);
                        $('#selectorWindow').window('close');
                    }
                });
            }
        }).window('open');
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