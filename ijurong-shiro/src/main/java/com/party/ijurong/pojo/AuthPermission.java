package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "auth_permission")
public class AuthPermission implements Serializable{
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    private String name;

    private String permission;

    private String description;

    private String page;

    private Integer generatemenu;

    private Integer zindex;

    private Integer pid;

    private String icon;

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

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page
     */
    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    /**
     * @return generatemenu
     */
    public Integer getGeneratemenu() {
        return generatemenu;
    }

    /**
     * @param generatemenu
     */
    public void setGeneratemenu(Integer generatemenu) {
        this.generatemenu = generatemenu;
    }

    /**
     * @return zindex
     */
    public Integer getZindex() {
        return zindex;
    }

    /**
     * @param zindex
     */
    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}