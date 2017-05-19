package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "exam_question")
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "research_id")
    private Integer researchId;

    @Column(name = "question_content")
    private String questionContent;

    @Column(name = "question_type")
    private Integer questionType;

    @Column(name = "question_sort")
    private Integer questionSort;

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
     * @return research_id
     */
    public Integer getResearchId() {
        return researchId;
    }

    /**
     * @param researchId
     */
    public void setResearchId(Integer researchId) {
        this.researchId = researchId;
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
     * @return question_sort
     */
    public Integer getQuestionSort() {
        return questionSort;
    }

    /**
     * @param questionSort
     */
    public void setQuestionSort(Integer questionSort) {
        this.questionSort = questionSort;
    }
}