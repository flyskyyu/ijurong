<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/26 0026
  Time: 下午 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<select id="${carComogridId == null? 'carComogrid':carComogridId}" class="easyui-combogrid" name="carId" required="true"
        style="width: 230px"
        data-options="mode:'remote',
                            delay: 700,
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'carNum',
							url: '<%=basePath%>admin/car/listByQ',
				            columns: [[
				            {field:'carNum',title:'车牌',width:100},
				                 {field:'introduce',title:'介绍',width:120}
				            ]],
				            fitColumns: true
				            ">
</select>
