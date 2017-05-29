package com.party.ijurong.bean;

import java.util.List;

/**
 * 页面combotree返回封装类
 * Created by yu on 2017/5/29.
 */
public class CombotreeResult {

    private int id;
    private String text;
    private int fatherId;
    private List<CombotreeResult> children;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CombotreeResult> getChildren() {
        return children;
    }

    public void setChildren(List<CombotreeResult> children) {
        this.children = children;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }
}
