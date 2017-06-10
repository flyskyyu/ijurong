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
        <input type="hidden" name="id" id="activityId"/>
        <input type="hidden" name="avatar" id="avatar"/>
        <input type="hidden" id="oldStaffs"/>
        <input type="hidden" id="newStaffs"/>
        <input type="hidden" name="addStaffs" id="addStaffs"/>
        <input type="hidden" name="deleteStaffs" id="deleteStaffs"/>
        <div class="column"><span class="current">活动信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">标题</td>
            <td class="kv-content" colspan="3"><input type="text" name="title"></td>
            <td class="kv-label" rowspan="2">活动图标</td>
            <td  class="kv-content" rowspan="2"><jsp:include page="../common/avatarUpload.jsp"/></td>
          </tr>
          <tr>
            <td class="kv-label">开始时间</td>
            <td class="kv-content"><input class="easyui-datetimebox" name="startTime"/></td>
            <td class="kv-label">结束时间</td>
            <td class="kv-content"><input class="easyui-datetimebox" name="endTime"/></td>
          </tr>
          <tr>
            <td class="kv-label">积分</td>
            <td class="kv-content"><input type="text" name="integral"/> </td>
            <td class="kv-label">活动类型</td>
            <td class="kv-content" colspan="3">
              <select name="type">
                <option value="1">组织活动</option>
                <option value="2">志愿者活动</option>
                <option value="3">专题讨论</option>
              </select>
            </td>
          </tr>
          <tr>
            <td class="kv-label">参与人</td>
            <td class="kv-content" colspan="5">
              <img id="addObjImage" src="<%=basePath%>img/add_img_icon.png" style="width: 40px;height:40px;cursor:pointer;"/>
            </td>
          </tr>
          </tbody>
        </table>
        <div class="column"><span class="current">活动详情</span></div>
        <!-- 加载编辑器的容器 -->
        <script id="ueditor" name="detail" type="text/plain" style="width: 95%;height:200px;"></script>
      </form>
      <div style="text-align: center;"><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
                                          id="edit_btn_add">保存</a>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" id="edit_btn_cancel">返回</a>
      </div>
    </div>
  </div>
</div>
<div id="staffDialog" class="easyui-dialog" style="width:70%;height:160px;padding:15px;" data-options="modal:true,title:'添加设施',closed:true,buttons: [{
					id:'btn_submit',
                    text:'提交',
                    iconCls:'icon-ok',
                    handler:function(){
                        staffDialogSubmit();
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#staffDialog').dialog('close');
                    }
                }]">
  <form id="staffDialogForm" action="#">
    <table class="kv-table">
      <tr>
        <td class="kv-label">参与人</td>
        <td class="kv-content">
          <jsp:include page="../common/staffCombogrid.jsp"/>
        </td>
      </tr>
    </table>
  </form>
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
    TT.disabledAllBtns('editContainer');
    var oldStaffs = $('#oldStaffs').val().split(',');
    var newStaffs = $('#newStaffs').val().split(',');
    var addStaffs = array_difference(newStaffs, oldStaffs);
    $('#addStaffs').val(addStaffs);
    var deleteStaffs = array_difference(oldStaffs, newStaffs);
    $('#deleteStaffs').val(deleteStaffs);
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

  $('#addObjImage').click(function() {
    TT.resetForm('staffDialogForm');
    $('#staffDialog').dialog('open');
  });

  $('#editForm').on('click', '.delete_icon', function() {
    $(this).parent().remove();
    setUploadObjsInput();
  });

  function staffDialogSubmit() {
    var selected = $('#editUserName').combogrid('grid').datagrid('getSelected');
    if(!selected) {
      $.messager.alert('提示', '请选择人员');
      return;
    }
    var srcs = [selected];
    generateUploadObjs(srcs);
    $('#staffDialog').dialog('close');
  }


  function reloadUPloadObjs() {
    var id = $('#addObjImage').parent().attr('data_id') || 'uploadObjInput';
    var objVals = $('#' + id).val();
    if(objVals) {
      generateUploadObjs(objVals.split(','));
    }
  }

  function generateUploadObjs(srcs) {
    var template = '';
    for(var i = 0; i < srcs.length; i++) {
      template += '<div class="upload_obj_container"><span class="upload_obj" data_id="' + srcs[i].staffId + '">' + srcs[i].staffName +
              '</span><img src="<%=basePath%>img/delete_icon.png" class="delete_icon"/>' +
              '</div>';
    }
    $('#addObjImage').parent().append(template);
    setUploadObjsInput();
  }

  function setUploadObjsInput(id) {
    var objs = $('#addObjImage').parent().find('.upload_obj');
    var array = [];
    for(var i = 0; i < objs.length; i++) {
      var data = objs.get(i).getAttribute('data_id') + ':' + objs.get(i).innerHTML;
      array.push(data);
    }
    id = id || 'newStaffs';
    $('#' + id).val(array.join(','));
  }

  function initPerson() {
    var id = $('#activityId').val();
    $('.upload_obj_container').remove();
    if(id) {
      $.get("listMember?id=" + id, function(data) {
        generateUploadObjs(data);
        setUploadObjsInput('oldStaffs');
      });
    }
  }
</script>