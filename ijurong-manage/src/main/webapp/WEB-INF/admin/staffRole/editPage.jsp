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
        <input type="hidden" name="roles" id="uploadObjInput"/>
        <div class="column"><span class="current">权限信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">姓名</td>
            <td class="kv-content">
              <jsp:include page="../common/staffCombogrid.jsp"/>
            </td>
          </tr>
          <tr>
            <td class="kv-label">角色</td>
            <td class="kv-content"><img id="addObjImage" src="<%=basePath%>img/add_img_icon.png"
                                        style="width: 40px;height:40px;cursor:pointer;"/></td>
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
<div id="selectDataDialog" class="easyui-dialog" style="width:70%;height:160px;padding:15px;" data-options="modal:true,title:'添加角色',closed:true,buttons: [{
					id:'btn_submit',
                    text:'提交',
                    iconCls:'icon-ok',
                    handler:function(){
                        selectDataObj.selectDataDialogSubmit();
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#selectDataDialog').dialog('close');
                    }
                }]">
  <form id="selectDataDialogForm" action="#">
    <table class="kv-table">
      <tr>
        <td class="kv-label">角色</td>
        <td class="kv-content">
          <select id="roleCombogrid" class="easyui-combogrid"
                  style="width: 230px"
                  data-options="mode:'remote',
                                                        delay: 700,
                                                        panelWidth: 350,
                                                        loadMsg: '正在搜索，请稍等...',
                                                        pagination : true,
                                                        idField: 'id',
                                                        textField: 'roleName',
                                                        url: '<%=basePath%>admin/role/listByQ',
                                                        columns: [[
                                                        {field:'roleName',title:'角色',width:100},
                                                             {field:'roleCode',title:'编码',width:100}
                                                        ]],
                                                        fitColumns: true
                                                        "/>
        </td>
      </tr>
    </table>
  </form>
</div>
<jsp:include page="../common/selectData.jsp"/>
<script type="text/javascript">
  selectDataObj.init({
    nameKey: 'roleName'
  });
  $('#edit_btn_cancel').click(function () {
    $('#editDialog').dialog('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function generateRole() {
    var staffId = $('#editUserName').combogrid('getValue');
    if(!staffId) {
      $('#addObjImage').parent().find('.upload_obj_container').remove();
      return;
    }
    $.get('listRole', {staffId: staffId}, function(data) {
      var srcs = [];
      for(var i = 0; i < data.length; i++) {
        var src = {};
        src.id = data[i].roleId;
        src.name = data[i].roleName;
        srcs.push(src);
      }
      selectDataObj.reloadUPloadObjs(srcs);
    });
  }

  function onSubmit() {
    if($('#editContainer').data('disabled')) return;
    TT.disabledAllBtns('editContainer');
    var roles = $('#uploadObjInput').val();
    roles = roles.split(',');
    roles = array_remove_repeat(roles);
    $('#uploadObjInput').val(roles.join(','));
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