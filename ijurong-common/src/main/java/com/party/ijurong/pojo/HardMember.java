package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "hard_member")
public class HardMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "staff_id")
    private Integer staffId;

    /**
     * 困难类型
     */
    private Integer type;

    /**
     * 说明
     */
    private String explain;

    @Column(name = "is_agree")
    private Integer isAgree;

    private String reply;

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
     * @return staff_id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取困难类型
     *
     * @return type - 困难类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置困难类型
     *
     * @param type 困难类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取说明
     *
     * @return explain - 说明
     */
    public String getExplain() {
        return explain;
    }

    /**
     * 设置说明
     *
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    /**
     * @return is_agree
     */
    public Integer getIsAgree() {
        return isAgree;
    }

    /**
     * @param isAgree
     */
    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }

    /**
     * @return reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * @param reply
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }
}