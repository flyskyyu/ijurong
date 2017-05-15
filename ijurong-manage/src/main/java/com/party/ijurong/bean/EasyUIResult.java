package com.party.ijurong.bean;

import java.util.List;

/**
 * Created by Cloud on 2016/6/22.
 */
public class EasyUIResult<T> {
    private Long total;
    private List<T> rows;

    public EasyUIResult() {
    }

    public EasyUIResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
