<%--
  Created by IntelliJ IDEA.
  User: Cloud
  Date: 2017/6/1
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="loading_mask">
  <div class="progress">
    <div class="progress-bar progress-bar-success"></div>
  </div>
</div>
<div class="add_upload_img_container" id="add_upload_img_container">
  <img src="<%=basePath%>img/add_img_icon.png"/>
  <input id="fileupload" type="file" name="file" multiple accept="image/gif, image/jpeg, image/jpg, image/png"/>
</div>
<script>
  $('#editForm').on('click', '.delete_icon', function() {
    $(this).parent().remove();
    setImagesInput();
  });

  $('#fileupload').fileupload({
    url: '<%=basePath%>admin/common/fileUpload',
    dataType: 'text',
    add: function(e, data) {
      if(!allowPicUpload()) return;
      $('.loading_mask').show();
      data.submit();
    },
    done: function (e, data) {
      if(!allowPicUpload()) return;
      var srcs = [];
      srcs.push(data.result);
      generateUploadImg(srcs);
    },
    progressall: function (e, data) {
      var progress = data.loaded / data.total * 100 + '%';
      $('.progress-bar').width(progress);
      if(data.loaded == data.total) {
        $('.loading_mask').hide();
        $('.progress-bar').width('0%');
      }
    }
  }).prop('disabled', !$.support.fileInput)
          .parent().addClass($.support.fileInput ? undefined : 'disabled');

  function allowPicUpload() {
    var parent = $('#add_upload_img_container').parent();
    var imgs = parent.find('.upload_img');
    var dataNum = parent.attr('data_num');
    if(dataNum) {
      return imgs.length < dataNum;
    }
    return true;
  }

  function generateUploadImg(srcs) {
    var template = '';
    for(var i = 0; i < srcs.length; i++) {
      template += '<div class="upload_img_container">' +
              '<a href="' + srcs[i] +  '" target="_blank"><img src="' + srcs[i] +  '" class="upload_img"/></a>' +
              '<img src="<%=basePath%>img/delete_icon.png" class="delete_icon"/>' +
              '</div>';
    }
    $('#add_upload_img_container').parent().append(template);
    setImagesInput();
  }

  function setImagesInput() {
    var imgs = $('#add_upload_img_container').parent().find('.upload_img');
    var array = [];
    for(var i = 0; i < imgs.length; i++) {
      array.push(imgs.get(i).src);
    }
    var id = $('#add_upload_img_container').parent().attr('data_id') || 'uploadImagesInput';
    $('#' + id).val(array.join(','));
  }
</script>
