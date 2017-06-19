package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "sys_manage")
public class SysManage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sys_name")
    private String sysName;

    @Column(name = "sys_value")
    private String sysValue;

    @Column(name = "sys_mark")
    private String sysMark;

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
     * @return sys_name
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * @param sysName
     */
    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    /**
     * @return sys_value
     */
    public String getSysValue() {
        return sysValue;
    }

    /**
     * @param sysValue
     */
    public void setSysValue(String sysValue) {
        this.sysValue = sysValue == null ? null : sysValue.trim();
    }

    /**
     * @return sys_mark
     */
    public String getSysMark() {
        return sysMark;
    }

    /**
     * @param sysMark
     */
    public void setSysMark(String sysMark) {
        this.sysMark = sysMark == null ? null : sysMark.trim();
    }
}