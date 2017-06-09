<%--
  Created by IntelliJ IDEA.
  User: Cloud
  Date: 2017/6/9
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div id="facilityDialog" class="easyui-dialog" style="width:70%;height:160px;padding:15px;" data-options="modal:true,title:'添加设施',closed:true,buttons: [{
					id:'btn_submit',
                    text:'提交',
                    iconCls:'icon-ok',
                    handler:function(){
                        facilityDialogSubmit();
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#facilityDialog').dialog('close');
                    }
                }]">
  <form id="facilityDialogForm" action="#">
    <table class="kv-table">
      <tr>
        <td class="kv-label">设施</td>
        <td class="kv-content">
          <select id="facilityCombogrid" class="easyui-combogrid"
                  style="width: 230px"
                  data-options="mode:'remote',
                                                        delay: 700,
                                                        panelWidth: 350,
                                                        loadMsg: '正在搜索，请稍等...',
                                                        pagination : true,
                                                        idField: 'id',
                                                        textField: 'name',
                                                        queryParams : {
                                                            type: ${param.type},
                                                        },
                                                        url: '<%=basePath%>admin/facility/listByQ',
                                                        columns: [[
                                                        {field:'name',title:'设施',width:100},
                                                             {field:'num',title:'数量',width:120}
                                                        ]],
                                                        fitColumns: true
                                                        "/>
        </td>
        <td class="kv-label">数量</td>
        <td class="kv-content">
          <input type="text" id="facilityNum"/>
        </td>
      </tr>
    </table>
  </form>
</div>
<script>
  $('#addObjImage').click(function () {
    TT.resetForm('facilityDialogForm');
    $('#facilityDialog').dialog('open');
  });

  $('#editForm').on('click', '.delete_icon', function () {
    $(this).parent().remove();
    setUploadObjsInput();
  });

  function facilityDialogSubmit() {
    var selected = $('#facilityCombogrid').combogrid('grid').datagrid('getSelected');
    var num = $('#facilityNum').val();
    if (!selected) {
      $.messager.alert('提示', '请选择设施');
      return;
    }
    if (!num) {
      $.messager.alert('提示', '请填写数量');
      return;
    }
    if (num > selected.num) {
      $.messager.alert('提示', selected.name + '的最大数量为 ' + selected.num);
      return;
    }
    var srcs = [selected.name + '*' + num];
    generateUploadObjs(srcs);
    $('#facilityDialog').dialog('close');
  }


  function reloadUPloadObjs() {
    var id = $('#addObjImage').parent().attr('data_id') || 'uploadObjInput';
    var objVals = $('#' + id).val();
    if (objVals) {
      generateUploadObjs(objVals.split(','));
    }
  }

  function generateUploadObjs(srcs) {
    var template = '';
    for (var i = 0; i < srcs.length; i++) {
      template += '<div class="upload_obj_container"><span class="upload_obj">' + srcs[i] +
              '</span><img src="<%=basePath%>img/delete_icon.png" class="delete_icon"/>' +
              '</div>';
    }
    $('#addObjImage').parent().append(template);
    setUploadObjsInput();
  }

  function setUploadObjsInput() {
    var objs = $('#addObjImage').parent().find('.upload_obj');
    var array = [];
    for (var i = 0; i < objs.length; i++) {
      array.push(objs.get(i).innerHTML);
    }
    var id = $('#addObjImage').parent().attr('data_id') || 'uploadObjInput';
    $('#' + id).val(array.join(','));
  }
</script>
