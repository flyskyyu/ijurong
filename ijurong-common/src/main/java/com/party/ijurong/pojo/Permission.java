package com.party.ijurong.pojo;

import javax.persistence.*;

public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限编码
     */
    @Column(name = "permission_code")
    private String permissionCode;

    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 区分系统权限
     */
    @Column(name = "class_code")
    private String classCode;

    /**
     * 操作的url
     */
    private String url;

    /**
     * 菜单图标url
     */
    @Column(name = "icon_url")
    private String iconUrl;

    /**
     * 菜单显示顺序
     */
    @Column(name = "show_order")
    private Integer showOrder;

    /**
     * 父类
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 是否生成菜单
     */
    @Column(name = "generate_menu")
    private Byte generateMenu;

    private String remark;

    @Transient
    private Boolean checked;

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
     * 获取权限编码
     *
     * @return permission_code - 权限编码
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * 设置权限编码
     *
     * @param permissionCode 权限编码
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * @return permission_name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    /**
     * 获取区分系统权限
     *
     * @return class_code - 区分系统权限
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * 设置区分系统权限
     *
     * @param classCode 区分系统权限
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    /**
     * 获取操作的url
     *
     * @return url - 操作的url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置操作的url
     *
     * @param url 操作的url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取菜单图标url
     *
     * @return icon_url - 菜单图标url
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 设置菜单图标url
     *
     * @param iconUrl 菜单图标url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    /**
     * 获取菜单显示顺序
     *
     * @return show_order - 菜单显示顺序
     */
    public Integer getShowOrder() {
        return showOrder;
    }

    /**
     * 设置菜单显示顺序
     *
     * @param showOrder 菜单显示顺序
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * 获取父类
     *
     * @return parent_id - 父类
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父类
     *
     * @param parentId 父类
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取是否生成菜单
     *
     * @return generate_menu - 是否生成菜单
     */
    public Byte getGenerateMenu() {
        return generateMenu;
    }

    /**
     * 设置是否生成菜单
     *
     * @param generateMenu 是否生成菜单
     */
    public void setGenerateMenu(Byte generateMenu) {
        this.generateMenu = generateMenu;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}