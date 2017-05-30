package com.party.ijurong.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.party.ijurong.pojo.DateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class CalendarDto {
    private Integer id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializer.class)
    private Date end;
    private String color;
    private boolean editable;
    @JsonIgnore
    private int typeFilter;
    private String data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTypeFilter() {
        return typeFilter;
    }

    public void setTypeFilter(int typeFilter) {
        this.typeFilter = typeFilter;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
