package com.party.ijurong.dto;

import com.party.ijurong.pojo.ExamAnswer;
import com.party.ijurong.pojo.UserAnswer;

import java.util.List;

/**
 * Copyright ©, 2016-2056
 * FileName:  ExamPaperDto
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
public class ExamPaperDto {
    private int id;
    private int researchId;
    private int questionId;
    private int questionSort;
    private int questionScore;
    private String questionContent;
    private int questionType;
    private String explains;
    private List<ExamAnswer> items;
    private List<UserAnswer> userAnswer;

    public List<ExamAnswer> getItems() {
        return items;
    }

    public void setItems(List<ExamAnswer> items) {
        this.items = items;
    }

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

    public List<UserAnswer> getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(List<UserAnswer> userAnswer) {
        this.userAnswer = userAnswer;
    }
}
