package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "excellent_member")
public class ExcellentMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 评选时间
     */
    @Column(name = "selection_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date selectionDate;

    @Column(name = "meritorious_deeds")
    private String meritoriousDeeds;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取评选时间
     *
     * @return selection_date - 评选时间
     */
    public Date getSelectionDate() {
        return selectionDate;
    }

    /**
     * 设置评选时间
     *
     * @param selectionDate 评选时间
     */
    public void setSelectionDate(Date selectionDate) {
        this.selectionDate = selectionDate;
    }

    /**
     * @return meritorious_deeds
     */
    public String getMeritoriousDeeds() {
        return meritoriousDeeds;
    }

    /**
     * @param meritoriousDeeds
     */
    public void setMeritoriousDeeds(String meritoriousDeeds) {
        this.meritoriousDeeds = meritoriousDeeds == null ? null : meritoriousDeeds.trim();
    }
}