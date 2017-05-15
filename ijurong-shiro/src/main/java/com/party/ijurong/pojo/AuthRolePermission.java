package com.party.ijurong.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "auth_role_permission")
public class AuthRolePermission implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色Id
     */
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return permission_id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}