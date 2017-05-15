package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "auth_role")
public class AuthRole implements Serializable{
    /**
     * 角色Id
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 角色名称(管理员，老师，学生)
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 获取角色Id
     *
     * @return role_id - 角色Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色Id
     *
     * @param roleId 角色Id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称(管理员，老师，学生)
     *
     * @return role_name - 角色名称(管理员，老师，学生)
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称(管理员，老师，学生)
     *
     * @param roleName 角色名称(管理员，老师，学生)
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色描述
     *
     * @return description - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}