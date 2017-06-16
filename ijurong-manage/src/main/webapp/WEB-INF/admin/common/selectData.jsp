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
<script>
  var selectDataObj = (function() {
    var nameKey;
    var idKey;
    $('#editForm').on('click', '#addObjImage', function() {
      TT.resetForm('selectDataDialogForm');
      $('#selectDataDialog').dialog('open');
    });

    $('#editForm').on('click', '.delete_icon', function () {
      $(this).parent().remove();
      setUploadObjsInput();
    });

    function selectDataDialogSubmit() {
      var selected = $('#roleCombogrid').combogrid('grid').datagrid('getSelected');
      if (!selected) {
        $.messager.alert('提示', '请选择数据');
        return;
      }
      var src = {};
      src.name = selected[nameKey];
      src.id = selected[idKey];
      var srcs = [src];
      generateUploadObjs(srcs);
      $('#selectDataDialog').dialog('close');
    }

    function reloadUPloadObjs(srcs) {
      $('#addObjImage').parent().find('.upload_obj_container').remove();
      generateUploadObjs(srcs);
    }

    function generateUploadObjs(srcs) {
      var template = '';
      for(var i = 0; i < srcs.length; i++) {
        template += '<div class="upload_obj_container"><span class="upload_obj" data_id="' + srcs[i].id + '">' + srcs[i].name +
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
        array.push(objs.get(i).getAttribute('data_id'));
      }
      var id = $('#addObjImage').parent().attr('data_id') || 'uploadObjInput';
      $('#' + id).val(array.join(','));
    }

    return {
      init: function(setting) {
        nameKey = setting.nameKey || 'name';
        idKey = setting.idKey || 'id';
      },
      reloadUPloadObjs:reloadUPloadObjs,
      selectDataDialogSubmit:selectDataDialogSubmit
    };
  })();
</script>
