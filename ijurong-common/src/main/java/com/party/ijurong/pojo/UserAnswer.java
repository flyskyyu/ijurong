package com.party.ijurong.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user_answer")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "answer_id")
    private Integer answerId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "answer_time")
    private Date answerTime;

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
     * @return question_id
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * @return answer_id
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId
     */
    public void setAnswerId(Integer answerId) {
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
}