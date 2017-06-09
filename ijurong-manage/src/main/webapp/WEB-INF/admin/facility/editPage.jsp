<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <input type="hidden" name="avatar" id="avatar"/>
        <div class="column"><span class="current">设施信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">所属支部</td>
            <td class="kv-content">
              <select name="partyBranchId">
                <c:forEach var="branch" items="${sessionScope.USER_KEY.branchInfos}">
                  <option value="${branch.id}">${branch.organizationName}</option>
                </c:forEach>
              </select>
            </td>
            <td class="kv-label">设施类型</td>
            <td class="kv-content">
              <select name="type">
                <option value="1">会议室设施</option>
                <option value="2">随车物品</option>
              </select>
            </td>
            <td class="kv-label" rowspan="2">图片</td>
            <td class="kv-content" rowspan="2">
              <jsp:include page="../common/avatarUpload.jsp"/>
            </td>
          </tr>
          <tr>
            <td class="kv-label">设施名称</td>
            <td class="kv-content"><input type="text" name="name"></td>
            <td class="kv-label">设施数量</td>
            <td class="kv-content"><input type="text" name="num"></td>
          </tr>
          <tr>
            <td class="kv-label">备注</td>
            <td class="kv-content" colspan="5">
              <textarea name="remark" rows="4"></textarea>
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