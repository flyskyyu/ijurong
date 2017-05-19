package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "party_due")
public class PartyDue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pay_id")
    private Integer payId;

    private String date;

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
     * @return pay_id
     */
    public Integer getPayId() {
        return payId;
    }

    /**
     * @param payId
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}