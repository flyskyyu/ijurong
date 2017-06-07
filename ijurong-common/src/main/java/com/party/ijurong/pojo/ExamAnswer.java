package com.party.ijurong.pojo;

import javax.persistence.*;

@Table(name = "exam_answer")
public class ExamAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "option_content")
    private String optionContent;

    @Column(name = "option_num")
    private Integer optionNum;

    @Column(name = "is_correct")
    private Integer isCorrect;


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
     * @return option_content
     */
    public String getOptionContent() {
        return optionContent;
    }

    /**
     * @param optionContent
     */
    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent == null ? null : optionContent.trim();
    }

    /**
     * @return option_num
     */
    public Integer getOptionNum() {
        return optionNum;
    }

    /**
     * @param optionNum
     */
    public void setOptionNum(Integer optionNum) {
        this.optionNum = optionNum;
    }

    /**
     * @return is_correct
     */
    public Integer getIsCorrect() {
        return isCorrect;
    }

    /**
     * @param isCorrect
     */
    public void setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
    }


}