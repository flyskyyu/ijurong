<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台帐号管理</title>
    <jsp:include page="../contentHeader.jsp"/>
    <link rel='stylesheet' href='<%=basePath%>resource/fullcalendar/lib/cupertino/jquery-ui.min.css'/>
    <link href='<%=basePath%>resource/fullcalendar/fullcalendar.min.css' rel='stylesheet'/>
    <link href='<%=basePath%>resource/fullcalendar/fullcalendar.print.min.css' rel='stylesheet' media='print'/>
    <script src='<%=basePath%>resource/fullcalendar/lib/moment.min.js'></script>
    <script src='<%=basePath%>resource/fullcalendar/fullcalendar.min.js'></script>
    <script src='<%=basePath%>resource/fullcalendar/locale/zh-cn.js'></script>
    <script>
        var addPermission = false;
        var checkPermission = false;
        <shiro:hasPermission name="roomOrder:add">
        addPermission = true;
        </shiro:hasPermission>
        <shiro:hasPermission name="roomOrder:check">
        checkPermission = true;
        </shiro:hasPermission>
        $(function () {
            //页面加载完初始化日历
            $('#calendar').fullCalendar({
                //设置选项和回调
                theme: true,
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay,listMonth'
                },
                defaultView: 'agendaWeek',
                events: {
                    url: 'calendarList',
                    data: function() { // a function that returns an object
                        return {
                            roomId: $('#roomComogrid1').combogrid('getValue'),
                            typeFilter:$('#typeFilter').val()
                        };
                    }
                },
                navLinks: true, // can click day/week names to navigate views
                selectable: true,
                selectHelper: true,
                select: function (start, end, resource) {
                    add(start, end);
                },
                eventDrop: function (event, delta, revertFunc) {
                    var orderDto = $.parseJSON(event.data);
                    orderDto.startTime = event.start.toISOString().replace('T', ' ');
                    orderDto.endTime = event.end.toISOString().replace('T', ' ');
                    reply(orderDto);
                },
                eventResize: function (event, delta, revertFunc) {
                    var orderDto = $.parseJSON(event.data);
                    orderDto.startTime = event.start.toISOString().replace('T', ' ');
                    orderDto.endTime = event.end.toISOString().replace('T', ' ');
                    reply(orderDto);
                },
                eventClick: function (calEvent, jsEvent, view) {
                    var orderDto = $.parseJSON(calEvent.data);
                    if(orderDto.isAgree == null) {
                        reply(orderDto);
                    } else {
                        look(orderDto);
                    }
                },
                editable: true,
                eventLimit: true, // allow "more" link when too many events
            });
        });

        function add(startTime, endTime) {
            if(!addPermission) {
                $.messager.alert('提示', '没有添加权限!');
                return;
            }
            var roomId = $('#roomComogrid1').combogrid('getValue');
            if(!roomId) {
                $.messager.alert('提示', '请选择会议室!');
                return;
            }
            var params = {};
            params.roomId = roomId;
            params.startTime = startTime.toISOString().replace('T', ' ');
            params.endTime = endTime.toISOString().replace('T', ' ');
            $("#editWindow").window({
                title: '新增会议室预约申请',
                onLoad: function() {
                    $('#editForm').attr('action', '<%=basePath%>admin/meetingRoomOrder/add')
                            .form('load', params);
                    TT.createEditBtn(['ok', 'cancel']);
                    $('#roomComogrid').combogrid('readonly');
                }
            }).window('open');
        }

        function reply(rowData) {
            if(!checkPermission) {
                $.messager.alert('提示', '没有审核权限!');
                return;
            }
            if(rowData == null) return;
            $("#editWindow").window({
                title: '审核会议室预约申请',
                onLoad: function() {
                    TT.createEditBtn(['yes', 'no', 'cancel']);
                    $('#editUserName').combogrid('readonly');
                    $('#roomComogrid').combogrid('readonly');
                    document.getElementById('replyInput').focus()
                    $('#editForm').attr('action', '<%=basePath%>admin/meetingRoomOrder/reply')
                            .form('load', rowData);
                    reloadUPloadObjs();
                }
            }).window('open');
        }

        function look(rowData) {
            if(rowData == null) return;
            $("#editWindow").window({
                title: '查看会议室预约申请',
                onLoad: function() {
                    $('#editForm').attr('action', '#').form('load', rowData);
                    reloadUPloadObjs();
                    TT.disabledAll('editForm');
                    TT.createEditBtn(['cancel']);
                }
            }).window('open');
        }
    </script>
    <style>
        #calendar {
            max-width: 1000px;
            margin-left: 20px;;
        }

    </style>
</head>
<body>
<div region="center" style="padding: 5px;">
    <div id="search_toolbar" style="padding: 5px; height: auto">
        <div style="padding: 5px;">
            <c:set var="roomCombogridId" value="roomComogrid1" scope="request"/>
            会议室：<jsp:include page="../common/meetingRoomCombogrid.jsp"/>
            查看类型：<select class="easyui-combobox" id="typeFilter">
            <option value="5">未回复及已同意</option>
            <option value="0">所有</option>
            <option value="1">未回复</option>
            <option value="2">已回复</option>
            <option value="3">同意</option>
            <option value="4">不同意</option>
        </select><span class="white_space"></span>
            <a href="#" class="easyui-linkbutton" id="btn_Search" style="margin-right: 80px;"
               data-options="iconCls:'icon-search'" onclick="doSearch()">查找</a>&nbsp;
            <select class="easyui-combobox" id="listMode">
                <option value="1">日历模式</option>
                <option value="2">列表模式</option>
            </select>
        </div>
    </div>
    <div id="calendar"></div>
    <div id="editWindow" class="easyui-window"
         data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=basePath%>admin/meetingRoomOrder/editPage'"
         style="max-width:800px;top:50px;width:90%;height:80%;padding:10px;">
    </div>
</div>

<script>
    function doSearch() {
        $('#calendar').fullCalendar('refetchEvents');
    }
    $('#listMode').combobox({
        onChange: function() {
            if($(this).val() == 2) {
                window.location.href = 'listPage';
            }
        }
    });
</script>
</body>
</html>
