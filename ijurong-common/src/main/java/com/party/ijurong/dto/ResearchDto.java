package com.party.ijurong.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.party.ijurong.pojo.DateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Copyright ©, 2016-2056
 * FileName:  ResearchDto
 *
 * @author CS-711701-00027
 * @version 1.0
 * @Date: 2017/6/8
 * Description:
 * Function List:
 * 1. -------
 * History:
 * maurice 16/02/12 1.0 build this moudle
 */
public class ResearchDto {
    private int id;
    private int researchId;
    private int questionId;
    private int questionSort;
    private int questionScore;
    private String questionContent;
    private int questionType;
    private String explains;

    private String researchName;
    private String researchGoal;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date stopTime;
    private int isOpen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionSort() {
        return questionSort;
    }

    public void setQuestionSort(int questionSort) {
        this.questionSort = questionSort;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getResearchGoal() {
        return researchGoal;
    }

    public void setResearchGoal(String researchGoal) {
        this.researchGoal = researchGoal;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }
}
