<%--
  Created by IntelliJ IDEA.
  User: Cloud
  Date: 2017/6/7
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="avatar-container">
  <div>
    <img src="/img/add_img_icon.png" id="avatarImg"/>
    <input type="file" id="avatarUpload" accept="image/gif, image/jpeg, image/jpg, image/png" name="file"/>
  </div>
</div>
<script>
  $('#avatarUpload').fileupload({
    url: '<%=basePath%>admin/common/fileUpload',
    dataType: 'text',
    done: function (e, data) {
      $('#avatar').val(data.result);
      $('#avatarImg').attr('src', data.result);
    }
  });

  function resetAvatar(src) {
    if(src) {
      $('#avatarImg').attr('src', src);
    } else {
      $('#avatarImg').attr('src', '/img/add_img_icon.png');
    }
  }
</script>
