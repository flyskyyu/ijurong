package com.party.ijurong.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sys_card_type")
public class SysCardType implements Serializable{
    @Id
    @Column(name = "card_type_id")
    private Integer cardTypeId;

    @Column(name = "card_name")
    private String cardName;

    private Integer status;

    /**
     * @return card_type_id
     */
    public Integer getCardTypeId() {
        return cardTypeId;
    }

    /**
     * @param cardTypeId
     */
    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    /**
     * @return card_name
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * @param cardName
     */
    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}