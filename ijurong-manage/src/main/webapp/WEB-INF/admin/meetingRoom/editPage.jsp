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
        <input type="hidden" name="imgs" id="uploadImagesInput"/>
        <div class="column"><span class="current">会议室信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">所属支部</td>
            <td class="kv-content">
              <select class="easyui-combobox" name="partyBranchId">
                <c:forEach var="branch" items="${sessionScope.USER_KEY.branchInfos}">
                  <option value="${branch.id}">${branch.organizationName}</option>
                </c:forEach>
              </select>
            </td>
            <td class="kv-label">会议室</td>
            <td class="kv-content"><input type="text" name="name"></td>
            <td class="kv-label">容纳人数</td>
            <td class="kv-content"><input type="text" name="capacity"></td>
          </tr>
          <tr>
            <td class="kv-label">管理员</td>
            <td class="kv-content"><input type="text" name="manager"></td>
            <td class="kv-label">电话</td>
            <td class="kv-content" colspan="3"><input type="text" name="phone"></td>
          </tr>
          <tr>
            <td class="kv-label">地址</td>
            <td class="kv-content" colspan="5"><input type="text" name="location"></td>
          </tr>
          <tr>
            <td class="kv-label">会议室介绍</td>
            <td class="kv-content" colspan="5"><textarea name="introduce" rows="3"></textarea></td>
          </tr>
          <tr>
            <td class="kv-label">会议室图片(最多8张)</td>
            <td class="kv-content" colspan="5" data_id="uploadImagesInput" data_num="8">
              <jsp:include page="../common/fileUpload.jsp"/>
            </td>
          </tr>
          </tbody>
        </table>
      </form>
      <div id="imgContainer"></div>
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