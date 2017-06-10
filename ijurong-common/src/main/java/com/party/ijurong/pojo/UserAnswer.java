package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_answer")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="research_id")
    private Integer researchId;

    @Column(name = "research_exam_id")
    private Integer researchExamId;

    @Column(name = "answer_id")
    private String answerId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "answer_time")
    @JsonSerialize(using = DateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date answerTime;

    /**
     * 所得分值
     */
    @Column(name = "answer_score")
    private Integer answerScore;

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

    public Integer getResearchId() {
        return researchId;
    }

    public void setResearchId(Integer researchId) {
        this.researchId = researchId;
    }

    /**
     * @return research_exam_id
     */
    public Integer getResearchExamId() {
        return researchExamId;
    }

    /**
     * @param researchExamId
     */
    public void setResearchExamId(Integer researchExamId) {
        this.researchExamId = researchExamId;
    }

    /**
     * @return answer_id
     */
    public String getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId
     */
    public void setAnswerId(String answerId) {
        this.answerId = answerId;
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
     * @return answer_time
     */
    public Date getAnswerTime() {
        return answerTime;
    }

    /**
     * @param answerTime
     */
    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    /**
     * 获取所得分值
     *
     * @return answer_score - 所得分值
     */
    public Integer getAnswerScore() {
        return answerScore;
    }

    /**
     * 设置所得分值
     *
     * @param answerScore 所得分值
     */
    public void setAnswerScore(Integer answerScore) {
        this.answerScore = answerScore;
    }
}