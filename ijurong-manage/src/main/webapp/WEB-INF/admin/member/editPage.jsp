<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/20 0020
  Time: 上午 10:08
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
            <form  method="post" id="editForm">
                <input type="hidden" name="staffId" id="staffId"/>
                <div class="column"><span class="current">基本信息</span></div>
                <table class="kv-table">
                    <tbody>
                    <tr>
                        <td class="kv-label">姓名</td>
                        <td class="kv-content"><input type="text" name="staffName"/></td>
                        <td class="kv-label">性别</td>
                        <td class="kv-content">
                            <input type="radio" name="sex" value="0"> 男
                            <input type="radio" name="sex" value="1"> 女
                        </td>
                        <td class="kv-label">生日</td>
                        <td class="kv-content"><input class="easyui-datebox" name="birthday"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">民族</td>
                        <td class="kv-content"><input type="text" name="nation"></td>
                        <td class="kv-label">学历</td>
                        <td class="kv-content">
                            <select name="education" class="easyui-combobox">
                                <option value="0">请选择</option>
                                <option value="1">小学</option>
                                <option value="2">初中</option>
                                <option value="3">中专</option>
                                <option value="4">高中</option>
                                <option value="5">大专</option>
                                <option value="6">本科</option>
                                <option value="7">硕士</option>
                                <option value="8">博士</option>
                            </select>
                        </td>
                        <td class="kv-label">email</td>
                        <td class="kv-content"><input type="text" name="email"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">身份证</td>
                        <td class="kv-content"><input type="text" name="identityId"/></td>
                        <td class="kv-label">手机号码</td>
                        <td class="kv-content"><input type="text" name="phoneNumber"/></td>
                        <td class="kv-label">备用号码</td>
                        <td class="kv-content"><input type="text" name="sparePhone"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">籍贯</td>
                        <td class="kv-content"><input type="text" name="originPlace"/></td>
                        <td class="kv-label">现居地</td>
                        <td class="kv-content" colspan="3"><input type="text" name="address"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">岗位说明</td>
                        <td class="kv-content" colspan="5"><input type="text" name="jobInfo"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">职务说明</td>
                        <td class="kv-content" colspan="5"><input type="text" name="managerInfo"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">兴趣爱好</td>
                        <td class="kv-content" colspan="5"><textarea name="hobby" rows="5"></textarea></td>
                    </tr>
                    </tbody>
                </table>
                <div class="column"><span class="current">党员信息</span></div>
                <table class="kv-table">
                    <tbody>
                    <tr>
                        <td class="kv-label">所在支部</td>
                        <td class="kv-content"><input type="text" name="partyBranchId"/></td>
                        <td class="kv-label">党内职务</td>
                        <td class="kv-content"><input type="text" name="partyPosition"/></td>
                        <td class="kv-label">月缴党费</td>
                        <td class="kv-content"><input type="text" name="payDues"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">进入支部时间</td>
                        <td class="kv-content"><input class="easyui-datebox" name="joinBranchDate"></td>
                        <td class="kv-label">列为发展对象日期</td>
                        <td class="kv-content"><input class="easyui-datebox" name="developmentDate"/></td>
                        <td class="kv-label">列为积极分子日期</td>
                        <td class="kv-content"><input class="easyui-datebox" name="positiveDate"></td>
                    </tr>
                    <tr>
                        <td class="kv-label">申请入党日期</td>
                        <td class="kv-content"><input class="easyui-datebox" name="applyDate"></td>
                        <td class="kv-label">加入中共组织日期</td>
                        <td class="kv-content"><input class="easyui-datebox" name="joinDate"></td>
                        <td class="kv-label">加入中共组织类型</td>
                        <td class="kv-content">
                            <select name="joinType" class="easyui-combobox">
                                <option value="0">请选择</option>
                                <option value="1">被吸收为预备党员</option>
                            </select>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="column"><span class="current">困难党员</span></div>
                <table class="kv-table">
                    <tbody>
                    <tr>
                        <td class="kv-label">是否困难党员</td>
                        <td class="kv-content">
                            <input type="radio" name="isHardMember" value="1"/>是&nbsp;&nbsp;
                            <input type="radio" name="isHardMember" value="0"/>否
                        </td>
                        <td class="kv-label">是否建国前入党老党员</td>
                        <td class="kv-content">
                            <input type="radio" name="isOldMember" value="1"/>是&nbsp;&nbsp;
                            <input type="radio" name="isOldMember" value="0"/>否
                        </td>
                        <td class="kv-label">是否享受低保</td>
                        <td class="kv-content">
                            <input type="radio" name="isEnjoyMla" value="1"/>是&nbsp;&nbsp;
                            <input type="radio" name="isEnjoyMla" value="0"/>否
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">是否享受优抚优恤补助</td>
                        <td class="kv-content">
                            <input type="radio" name="isEnjoySubsidy" value="1"/>是&nbsp;&nbsp;
                            <input type="radio" name="isEnjoySubsidy" value="0"/>否
                        </td>
                        <td class="kv-label">生活困难类型</td>
                        <td class="kv-content">
                            <select name="hardType" class="easyui-combobox">
                                <option value="0">请选择</option>
                                <option value="1">家庭困难</option>
                                <option value="2">经济困难</option>
                            </select>
                        </td>
                        <td class="kv-label">健康状况</td>
                        <td class="kv-content">
                            <select name="healthStatus" class="easyui-combobox">
                                <option value="0">请选择</option>
                                <option value="1">健康</option>
                                <option value="2">亚健康</option>
                                <option value="3">不健康</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="kv-label">户口所在地派出所</td>
                        <td class="kv-content" colspan="5"><input type="text" name="policeStation"/></td>
                    </tr>
                    <tr>
                        <td class="kv-label">困难情况补充</td>
                        <td class="kv-content" colspan="5"><textarea name="hardDesc" rows="8"></textarea></td>
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
    $('#edit_btn_cancel').click(function () {
        $("#editWindow").window('close');
    });

    $('#edit_btn_add').click(function () {
        onSubmit();
    });

    function onSubmit() {
        if($('#editContainer').data('disabled')) return;
        TT.disabledAllBtns('editContainer');
        $('#editForm').form('submit', {
            success: function (data) {
                if (data == "success") {
                    $('#editWindow').dialog('close');
                    $('#tableList').datagrid('reload');
                } else {
                    $.messager.alert('提示', '提交失败!');
                }
            }
        });
    }
</script>