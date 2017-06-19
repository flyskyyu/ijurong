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
                <input type="hidden" name="isAgree" id="isAgree" data_no_disabled/>
                <input type="hidden" name="id" data_no_disabled/>
                <input type="hidden" name="facility" data_no_disabled id="uploadObjInput"/>

                <div class="column"><span class="current">会议室预约</span></div>
                <table class="kv-table">
                    <tbody>
                    <tr>
                        <td class="kv-label">申请人姓名</td>
                        <td class="kv-content" id="editUserNameTd">
                            <jsp:include page="../common/staffCombogrid.jsp"/>
                        </td>
                        <td class="kv-label">会议室</td>
                        <td class="kv-content">
                            <jsp:include page="../common/meetingRoomCombogrid.jsp"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">预约时间</td>
                        <td class="kv-content"><input class="easyui-datetimebox" name="startTime" required="true"></td>
                        <td class="kv-label">结束时间</td>
                        <td class="kv-content"><input class="easyui-datetimebox" name="endTime" required="true"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">设施</td>
                        <td class="kv-content" colspan="3">
                            <img id="addObjImage" src="<%=basePath%>img/add_img_icon.png"
                                 style="width: 40px;height:40px;cursor:pointer;"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">会议内容</td>
                        <td class="kv-content" colspan="3">
                            <textarea name="content" rows="4"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">会议描述/主要参会人员</td>
                        <td class="kv-content" colspan="3">
                            <textarea name="people" rows="4"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">备注</td>
                        <td class="kv-content" colspan="3">
                            <textarea name="remark" rows="4"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">回复</td>
                        <td class="kv-content" colspan="3">
                            <textarea name="reply" rows="4" id="replyInput"></textarea>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <div style="text-align: center;" id="editBtnGroup"></div>
        </div>
    </div>
</div>
<jsp:include page="../common/selectFacility.jsp">
    <jsp:param name="type" value="1"/>
</jsp:include>
<script type="text/javascript">
    $('#editContainer').on('click', '#edit_btn_no', function () {
        $('#isAgree').val(0);
        onSubmit();
    });

    $('#editContainer').on('click', '#edit_btn_yes', function () {
        $('#isAgree').val(1);
        onSubmit();
    });

    $('#editContainer').on('click', '#edit_btn_cancel', function () {
        $("#editWindow").window('close');
    });

    $('#editContainer').on('click', '#edit_btn_ok', function () {
        onSubmit();
    });

    $('#editUserName').click(function () {
        $('#selectorWindow').window({
            onLoad: function () {
                $('#selectorTableList').datagrid({
                    onClickRow: function (rowIndex, rowData) {
                        $('#editUserId').val(rowData.staffId);
                        $('#editUserName').val(rowData.staffName);
                        $('#selectorWindow').window('close');
                    }
                });
            }
        }).window('open');
    });

    function onSubmit() {
        if ($('#editContainer').data('disabled')) return;
        if(!$('#editForm').form('validate')) return;
        TT.disabledAllBtns('editContainer');
        $('#editForm').form('submit', {
            success: function (data) {
                if (data == "success") {
                    $('#editWindow').dialog('close');
                    if ($('#tableList').length > 0) {
                        $('#tableList').datagrid('reload');
                    }
                    if ($('#calendar').length > 0) {
                        $('#calendar').fullCalendar('refetchEvents');
                    }
                } else if (data == 'reservation_already') {
                    $.messager.alert('提示', '该会议室在选定时间段内已被预约!');
                } else {
                    $.messager.alert('提示', '提交失败!');
                }
            }
        });
    }
</script>