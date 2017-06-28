<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台帐号管理</title>
    <script src="http://api.map.baidu.com/api?v=1.4" type="text/javascript"></script>
    <jsp:include page="../contentHeader.jsp"/>
    <style type="text/css">
        input {
            margin: 5px 5px 5px 0px;
            font-size: 15px;
        }

        .dialog_table td {
            text-align: right;
            font-size: 15px;
            width: auto;
            background-color: #FFFFFF;
            border: 0px;
        }

        .dialog_table td input {
            width: 200px;
            height: 20px;
            font-size: 15px;
            border-width: 1px;
            border-style: solid;
            border-left-color: #c5c5c5;
            border-top-color: #c5c5c5;
            border-right-color: #e0e0e0;
            border-bottom-color: #e0e0e0;
            outline: none;
            padding: 0 10px;
        }

        .dialog_table td select {
            width: 200px;
            height: 20px;
            font-size: 15px;
            padding: 0 10px;
        }

        .combobox-item {
            font-size: 15px;
            padding: 0 10px;
        }

        .textbox .textbox-text {
            font-size: 15px;
            padding: 0 10px;
        }

        .dialog_table td select option {
            font-size: 15px;
        }

        .dialog_table .field_color {
            text-align: left;
            background-color: white;
            padding-left: 2px;
        }

    </style>
    <script type="text/javascript">
        function doSearch() {
            var partyBranchInfo = {};
            partyBranchInfo.organizationName = $('#organizationName').val();
            $('#partyBranchInfo_grid').datagrid('load', partyBranchInfo);
        }
        function doSubmit() {
            if ($("#partyBranchInfo_form").form('validate')) {
                if ($('#refGrid').combogrid('getValue') == "") {
                    $('#enterpriseId').val('0');
                }
                if ($('#refGrid1').combogrid('getValue') == "") {
                    $('#fatherId').val('0');
                }
                $.ajax({
                    url: partyBranchInfo_form.action,
                    type: partyBranchInfo_form.method,
                    data: $(partyBranchInfo_form).serialize(),
                    success: function (data) {
                        if (data == "had") {
                            $.messager.alert('提示', '支部名已存在!');
                            return;
                        }
                        if (data == "success") {
                            $('#partyBranchInfo_dialog').dialog('close');
                            $('#partyBranchInfo_grid').datagrid('reload');
                        } else {
                            $.messager.alert('提示', '提交失败!');
                        }
                    },
                    error: function () {
                        $.messager.alert('提示', '服务器内部错误!');
                    }
                });
            }

        }

        function doSubmitMap() {
            $.ajax({
                url: map_form.action,
                type: map_form.method,
                data: $(map_form).serialize(),
                success: function (data) {
                    if (data == "success") {
                        $('#map_dialog').dialog('close');
                        $('#partyBranchInfo_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '提交失败!');
                    }
                },
                error: function () {
                    $.messager.alert('提示', '服务器内部错误!');
                }
            });
        }
        $(function () {
            $('#btn_add').bind('click', function () {
                partyBranchInfo_form.reset();
                TT.resetForm('partyBranchInfo_dialog');

                $('#refGrid').combogrid('setValue', '');
                $('#refGrid1').combogrid('setValue', '');
                partyBranchInfo_form.action = 'addPartyBranchInfo';
                $('#partyBranchInfo_dialog').dialog('setTitle', '添加支部');
                $('#level').combobox('clear');
                $('#partyBranchInfo_dialog').dialog('open');
            });
        });

        $(function () {
            $('#btn_remove').bind('click', function () {
                var rowData = $('#partyBranchInfo_grid').datagrid('getSelected');
                if (rowData == null) {
                    return;
                }
                var url = 'delectPartyBranchInfo/' + rowData.id;
                $.post(url, function (data) {
                    if (data == 'success') {
                        $('#partyBranchInfo_grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', '删除失败，支部有下级支部或有其他关联信息，不允许删除！');
                    }
                });
            });
        });

        function formatOperation(value, rowData, rowIndex) {
            var result = "";
            <shiro:hasPermission name="party:update">
            result = '<a href="#" onclick="openDialog(' + rowIndex
            + ')" style="color:green;text-decoration:none;">操作</a>'
            + '  ' + '<a href="#" onclick="openMapDialog(' + rowIndex
            + ')" style="color:green;text-decoration:none;">地图</a>';
            </shiro:hasPermission>
            return result;
        }


        function formatType(value, rowData, rowIndex) {
            if (value == '1')
                return '<span>国企</span>';
            if (value == '2')
                return '<span>民营</span>';
            if (value == '3')
                return '<span>外资</span>';
            if (value == '4')
                return '<span>合资</span>';
            if (value == '5')
                return '<span>其他</span>';
        }

        function openMapDialog(id) {
            map_form.reset();
            TT.resetForm('map_dialog');
            map_form.action = 'updatePartyBranchInfo';
            $('#partyBranchInfo_grid').datagrid('selectRow', id);
            var rowData = $('#partyBranchInfo_grid').datagrid('getSelected');
            if (rowData != null) {
                $('#map_form').form('load', rowData);
                if (rowData.longitude != "" && rowData.longitude != null) {
                    setMapPoint(rowData.longitude, rowData.latitude);
                }
                else {
                    initMap();
                }
            }
            partyBranchInfo_form.action = "updatePartyBranchInfo";
            $('#map_dialog').dialog('setTitle', '支部地图');
            $('#map_dialog').dialog('open');
        }


        function openDialog(id) {
            partyBranchInfo_form.reset();
            TT.resetForm('partyBranchInfo_dialog');
            $('#refGrid').combogrid('setValue', '');
            $('#refGrid1').combogrid('setValue', '');

            $('#partyBranchInfo_grid').datagrid('selectRow', id);
            var rowData = $('#partyBranchInfo_grid').datagrid('getSelected');
            if (rowData != null) {

                $('#partyBranchInfo_form').form('load', rowData);

            }
            if (rowData.enterpriseId > 0)//加载外键信息
            {
                $.post('findEnterpriseInfoById/' + rowData.enterpriseId, function (data) {
                    $('#refGrid').combogrid('setValue', data.name);
                });
            }
            if (rowData.fatherId > 0)//加载外键信息
            {
                $.post('findPartyBranchInfoById/' + rowData.fatherId, function (data) {
                    $('#refGrid1').combogrid('setValue', data.organizationName);
                });
            }
            partyBranchInfo_form.action = "updatePartyBranchInfo";
            $('#partyBranchInfo_dialog').dialog('setTitle', '支部帐号');
            $('#partyBranchInfo_dialog').dialog('open');
        }

        $(function () {
            $('#refGrid').combogrid({
                onSelect: function (rowIndex, rowData) {
                    $('#enterpriseId').val(rowData.id);
                }
            });
            $('#refGrid1').combogrid({
                onSelect: function (rowIndex, rowData) {
                    $('#fatherId').val(rowData.id);
                }
            });
        });


    </script>
</head>
<body class="easyui-layout">
<div region="center" style="padding: 5px;">
    <div id="partyBranchInfo_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            支部名称：<input type="text" id="organizationName">&nbsp;
            <shiro:hasPermission name="party:query">
                <a href="#"
                   class="easyui-linkbutton" id="btn_Search"
                   data-options="iconCls:'icon-search'"
                   onclick="doSearch()">查找</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="party:add">
                <a href="#" class="easyui-linkbutton"
                   data-options="iconCls:'icon-add'" id="btn_add">添加</a>&nbsp;
            </shiro:hasPermission>
            <shiro:hasPermission name="party:delete"> <a
                    href="#" class="easyui-linkbutton"
                    data-options="iconCls:'icon-remove'" id="btn_remove">删除</a>
            </shiro:hasPermission>
        </div>
    </div>
    <table id="partyBranchInfo_grid"
           class="easyui-datagrid" fitColumns="true" pagination="true"
           url="findPartyBranchInfos" toolbar="#tb" rownumbers="true" pageSize="20" style="width:auto;"
           singleSelect="true">

        <%--class="easyui-datagrid"--%>
        <%--data-options="pagination:true,pageSize:20,fit:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'findPartyBranchInfos',striped:true,toolbar:'#partyBranchInfos_toolbar'">--%>
        <thead>
        <tr>
            <th field="id" hidden="true"></th>
            <th data-options="field:'organizationName',align:'center'" width="30">支部名称</th>
            <th data-options="field:'organizationType',align:'center',formatter:formatType" width="20">组织类型</th>
            <th data-options="field:'setupDate',align:'center'" width="20">成立日期</th>
            <th data-options="field:'phoneNumber',align:'center'" width="20">联系电话</th>
            <th
                    data-options="field:'id1',align:'center',width:50,formatter:formatOperation"
                    width="20">操作
            </th>
        </tr>
        </thead>
    </table>
</div>

<div id="partyBranchInfo_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'支部管理',
		modal:true,
		resizable:true,
		iconCls:'icon-save',
		buttons: [{
					id:'btn_submit',
                    text:'提交',  
                    iconCls:'icon-ok',  
                    handler:function(){  
                        doSubmit();  
                    }  
                },{  
                    text:'取消',
                    iconCls:'icon-cancel',   
                    handler:function(){  
                        $('#partyBranchInfo_dialog').dialog('close');
                    }  
                }]"
     style="width: 730px; height: 500px; padding: 10px;">
    <form id="partyBranchInfo_form" name="partyBranchInfo_form"
          method="post">
        <div class="container">
            <div class="content">
                <div title="" data-options="closable:false"
                     class="basic-info panel-body panel-body-noheader panel-body-noborder"
                     style="width: 100%;;">
                    <div class="column"><span class="current">支部管理</span></div>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">组织名称</td>
                            <td class="kv-content"><input type="text" name="organizationName" class="easyui-validatebox"
                                                          data-options="required:true"/></td>
                            <td class="kv-label">组织代码</td>
                            <td class="kv-content"><input type="text" name="organizationCode"/></td>
                        </tr>

                        <tr>
                            <td class="kv-label">组织地址</td>
                            <td class="kv-content"><input type="text" name="address" class="easyui-validatebox"
                                                          data-options="required:true"/></td>
                            <td class="kv-label">组织电话</td>
                            <td class="kv-content"><input type="text" name="phoneNumber" class="easyui-validatebox"
                                                          data-options="required:true"/></td>
                        </tr>

                        <tr>
                            <td class="kv-label">邮政编码</td>
                            <td class="kv-content"><input type="text" name="phone"/></td>
                            <td class="kv-label">组织机构代码</td>
                            <td class="kv-content"><input type="text" name="code"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">成立时间</td>
                            <td class="kv-content"><input class="easyui-datebox" name="setupDate"/></td>
                            <td class="kv-label">备注</td>
                            <td class="kv-content"><input type="text" name="remark"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">属地关系</td>
                            <td class="kv-content" colspan="3"><input type="text" name="relationship"/></td>
                        </tr>
                        <tr>
                            <td class="kv-label">所属企业选择:</td>
                            <td class="kv-content" colspan="3"><select id="refGrid" class="easyui-combogrid"
                                                                       style="width: 230px"
                                                                       data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'name',
							url: 'findEnterpriseInfoByName',
				            columns: [[
				            {field:'name',title:'企业名称',width:100},
				                 {field:'address',title:'公司地址',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
                            </select></td>

                        </tr>
                        <tr>
                            <td class="kv-label">所属支部选择:</td>
                            <td class="kv-content" colspan="3"><select id="refGrid1" class="easyui-combogrid"
                                                                       style="width: 230px"
                                                                       data-options="mode:'remote',
							panelWidth: 350,
							loadMsg: '正在搜索，请稍等...',
							pagination : true,
							idField: 'id',
							textField: 'organizationName',
							url: 'findPartyBranchInfoByName',
				            columns: [[
				            {field:'organizationName',title:'支部名称',width:100},
				                 {field:'address',title:'支部地址',width:120},
				                {field:'id',hidden:true}
				            ]],
				            fitColumns: true
				            ">
                            </select></td>

                        </tr>

                        <input type="hidden" id="fatherId" name="fatherId" value="0"/>
                        <input type="hidden" id="enterpriseId" name="enterpriseId" value="0"/>
                        <input type="hidden" value="0" name="id" id="id"/>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </form>
</div>


<div id="map_dialog" class="easyui-dialog"
     data-options="closed:true,
		title:'支部地图管理',
		modal:true,
		resizable:true,
		iconCls:'icon-save',
		buttons: [{
					id:'btn_submit',
                    text:'提交',
                    iconCls:'icon-ok',
                    handler:function(){
                        doSubmitMap();
                    }
                },{
                    text:'取消',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#map_dialog').dialog('close');
                    }
                }]"
     style="width: 700px; height: 600px; padding: 10px;">
    <div class="container">
        <div class="content">
            <div title="" data-options="closable:false"
                 class="basic-info panel-body panel-body-noheader panel-body-noborder"
                 style="width: 100%;;">
                <div class="column"><span class="current">支部地图管理</span></div>
                <form id="map_form" name="map_form"
                      method="post">
                    <div id="allmap" style="width: 620px; height: 400px;"></div>
                    <br/>
                    <table class="kv-table">
                        <tbody>
                        <tr>
                            <td class="kv-label">经度</td>
                            <td class="kv-content"><input type="text" id="longitude" name="longitude" readonly/></td>
                            <td class="kv-label">纬度</td>
                            <td class="kv-content"><input type="text" id="latitude" name="latitude" readonly/></td>
                        </tr>
                        </tbody>
                    </table>
                    <input type="hidden" value="0" name="id"/>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<script type="text/javascript">
    var map;
    var marker;
    $(document).ready(function () {
        // 百度地图API功能
        map = new BMap.Map("allmap");    // 创建Map实例
        var point = new BMap.Point(119.175093, 31.950719);//句容市政府
        map.centerAndZoom(point, 16);
        map.enableScrollWheelZoom(true);
        marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(marker);               // 将标注添加到地图中
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
        marker.enableDragging();// 可拖拽
        marker.addEventListener("dragend", attribute);

    });

    function attribute() {
        var p = marker.getPosition();
        $("#longitude").val(p.lng);
        $("#latitude").val(p.lat);
    }

    function initMap() {
        var point = new BMap.Point(119.175093, 31.950719);//句容市政府
        map.centerAndZoom(point, 16);
        map.enableScrollWheelZoom(true);
        marker.hide();
        marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(marker);               // 将标注添加到地图中
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
        marker.enableDragging();// 可拖拽
        marker.addEventListener("dragend", attribute);
    }


    function setMapPoint(longitude, latitude) {
        var point = new BMap.Point(longitude, latitude);//句容市政府119.175093, 31.950719
        map.centerAndZoom(point, 16);
        map.enableScrollWheelZoom(true);
        marker.hide();
        marker = new BMap.Marker(point);  // 创建标注
        map.addOverlay(marker);               // 将标注添加到地图中
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
        marker.enableDragging();// 可拖拽
        marker.addEventListener("dragend", attribute);
    }


</script>