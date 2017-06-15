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
<style>
  .authorization a {
    color: #454545 !important;
  }
</style>
<div class="container" id="editContainer">
  <div class="content">
    <div title="" data-options="closable:false"
         class="basic-info panel-body panel-body-noheader panel-body-noborder"
         style="width: 100%;;">
      <form method="post" id="editForm">
        <input type="hidden" name="id" id="idInput"/>
        <input type="hidden" id="oldObjs"/>
        <input type="hidden" name="addPermissions" id="addObjs"/>
        <input type="hidden" name="deletePermissions" id="deleteObjs"/>
        <div class="column"><span class="current">角色信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">角色名称</td>
            <td class="kv-content"><input type="text" name="roleName"></td>
            <td class="kv-label">备注</td>
            <td class="kv-content" style="width:50%;"><input type="text" name="remark"></td>
          </tr>
          </tbody>
        </table>
        <div class="column"><span class="current">授权信息</span></div>
        <table class="kv-table">
          <tbody>
          <tr>
            <td class="kv-label">授权</td>
            <td class="kv-content authorization"><ul id="permissionTree" class="ztree"></ul></td>
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
  // 授权树初始化
  var treeSetting = {
    data : {
      key : {
        name : 'permissionName',
        url: ''
      },
      simpleData : {//使用简单json数据构造节点数据
        enable : true,
        pIdKey: 'parentId'
      }
    },
    check : {//使用ztree勾选效果
      enable : true
    }
  };

  function getPermission() {
    //发送ajax请求，获取节点数据
    $.ajax({
      url : '<%=basePath%>admin/permission/listAll',
      data: {roleId: $('#idInput').val()},
      type : 'POST',
      dataType : 'json',
      success : function(data) {
        var permissions = data.permissions;
        var rolePermissions = data.rolePermissions;
        if(rolePermissions) {
          var map = {};
          for(var i = 0; i < permissions.length; i++) {
            map[permissions[i].id] = permissions[i];
          }
          var oldObjs = [];
          for(var i = 0; i < rolePermissions.length; i++) {
            map[rolePermissions[i].permissionId].checked = true;
            oldObjs.push(rolePermissions[i].permissionId);
          }
          $('#oldObjs').val(oldObjs.join(','));
        }
        $.fn.zTree.init($("#permissionTree"), treeSetting, permissions);
        $.fn.zTree.getZTreeObj("permissionTree").expandAll(true);
      },
      error : function(msg) {
        alert('树加载异常!');
      }
    });
  }

  $('#edit_btn_cancel').click(function () {
    $('#editDialog').dialog('close');
  });

  $('#edit_btn_add').click(function () {
    onSubmit();
  });

  function onSubmit() {
    if($('#editContainer').data('disabled')) return;
    var treeObj = $.fn.zTree.getZTreeObj("permissionTree");//获得页面中的ztree对象
    var nodes = treeObj.getCheckedNodes(true);//在提交表单之前将选中的checkbox收集
    var newObjs = new Array();
    for(var i=0;i<nodes.length;i++){
      var id = nodes[i].id;//权限id
      newObjs.push(id);
    }

    var oldObjs = $('#oldObjs').val().split(',');
    var addObjs = array_difference(newObjs, oldObjs);
    $('#addObjs').val(addObjs);
    var deleteObjs = array_difference(oldObjs, newObjs);
    $('#deleteObjs').val(deleteObjs);
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