package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "exam_question")
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_content")
    private String questionContent;

    @Column(name = "question_type")
    private Integer questionType;

    private String explain;//答案解读

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
     * @return question_content
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * @param questionContent
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    /**
     * @return question_type
     */
    public Integer getQuestionType() {
        return questionType;
    }

    /**
     * @param questionType
     */
    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    /**
     * @return explain
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param explain
     */
    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }
}