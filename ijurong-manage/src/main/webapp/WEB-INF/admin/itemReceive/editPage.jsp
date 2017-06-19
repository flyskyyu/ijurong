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
            <td class="kv-label">领取人</td>
            <td class="kv-content"><select id="editUserName" class="easyui-combogrid easyui-validatebox" name="userId" required="true"
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
				            "></select></td>
            <td class="kv-label">电话</td>
            <td class="kv-content"><input type="text" name="phoneNumber"></td>
          </tr>
          <tr>
            <td class="kv-label">领取物品</td>
            <td class="kv-content"><select id="itemCombogrid" class="easyui-combogrid easyui-validatebox" name="itemId" required="true"
                                           style="width: 230px"
                                           data-options="mode:'remote',
                            delay: 700,
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'itemName',
							url: '<%=basePath%>admin/item/listByQ',
				            columns: [[
				            {field:'itemName',title:'物品',width:100},
				                 {field:'num',title:'数量',width:100}
				            ]],
				            fitColumns: true
				            "></select></td>
            <td class="kv-label">领取数量</td>
            <td class="kv-content"><input class="easyui-validatebox" required="true" type="text" name="num"></td>
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
      <div style="text-align: center;" id="editBtnGroup">
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
  $('#editContainer').on('click', '#edit_btn_no', function() {
    $('#isAgree').val(0);
    onSubmit();
  });

  $('#editContainer').on('click', '#edit_btn_cancel', function() {
    $("#editWindow").window('close');
  });

  $('#editContainer').on('click', '#edit_btn_yes', function() {
    $('#isAgree').val(1);
    onSubmit();
  });

  $('#editContainer').on('click', '#edit_btn_ok', function() {
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
          return;
        } else if(data == 'num_lack') {
          $.messager.alert('提示', '物品数量不足!');
        } else if(data == 'integral_lack') {
          $.messager.alert('提示', '积分不足!');
        } else {
          $.messager.alert('提示', '提交失败!');
        }
        TT.enabledAllBtns('editContainer');
      }
    });
  }
</script>