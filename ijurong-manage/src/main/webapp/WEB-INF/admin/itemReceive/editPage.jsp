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
        <div class="column"><span class="current">物品信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">领取人姓名</td>
            <td class="kv-content"><input type="text" name="staffName"></td>
            <td class="kv-label">电话</td>
            <td class="kv-content"><input type="text" name="phoneNumber"></td>
            <td class="kv-label">申请时间</td>
            <td class="kv-content"><input type="text" name="applyTime"></td>
          </tr>
          <tr>
            <td class="kv-label">是否同意</td>
            <td class="kv-content">
              <input type="radio" name="isAgree" value="1"/>是&nbsp;&nbsp;
              <input type="radio" name="isAgree" value="0"/>否
            </td>
            <td class="kv-label">是否领取</td>
            <td class="kv-content">
              <input type="radio" name="isReceive" value="1"/>是&nbsp;&nbsp;
              <input type="radio" name="isReceive" value="0"/>否
            </td>
            <td class="kv-label">领取时间</td>
            <td class="kv-content"><input class="easyui-datetimebox" name="receiveTime"/></td>
          </tr>
          <tr>
            <td class="kv-label">领取物品</td>
            <td class="kv-content"><input type="text" name="itemName"></td>
            <td class="kv-label">领取数量</td>
            <td class="kv-content"><input type="text" name="num"></td>
            <td class="kv-label">所需积分</td>
            <td class="kv-content"><input type="text" name="integral"></td>
          </tr>
          </tbody>
        </table>
        <div class="column"><span class="current">物流信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">收件人姓名</td>
            <td class="kv-content"><input type="text" name="name"></td>
            <td class="kv-label">收件人电话</td>
            <td class="kv-content"><input type="text" name="phone"></td>
          </tr>
          <tr>
            <td class="kv-label">快递名称</td>
            <td class="kv-content"><input type="text" name="courierName"></td>
            <td class="kv-label">快递单号</td>
            <td class="kv-content"><input type="text" name="courierNo"></td>
          </tr>
          <tr>
            <td class="kv-label">寄件地址</td>
            <td class="kv-content" colspan="3"><input type="text" name="address"/> </td>
          </tr>
          </tbody>
        </table>
        <div class="column"><span class="current">管理员回复</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">回复</td>
            <td class="kv-content" colspan="2"><textarea name="reply" data_no_disabled id="replyInput"></textarea></td>
          </tr>
          </tbody>
        </table>
      </form>
      <div style="text-align: center;">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
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
    $('#isAgree').val(1);
    onSubmit();
  });

  function onSubmit() {
    if($('#editContainer').data('disabled')) return;
    TT.disabledAllBtns('editContainer');
    $('#editForm').form('submit', {
      success: function (data) {
        if (data == "success") {
          $('#editWindow').dialog('close');
          $('#tableList').datagrid('reload');
          return;
        } else if(data == 'lack') {
          $.messager.alert('提示', '物品数量不足!');
        } else {
          $.messager.alert('提示', '提交失败!');
        }
        TT.enabledAllBtns('editContainer');
      }
    });
  }
</script>