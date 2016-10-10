package com.yeww.carbao.model.question;

import com.yeww.carbao.model.BaseEntity;
import com.yeww.carbao.model.evaluation.EvaluationEntity;

/**
 * Created by yeweiwei1 on 2016/10/10.
 */
public class QuestionEntity extends BaseEntity {
    private String num;
    private String title;
    private Integer score;
    private Long evalId;
    private Integer itemNum;

    private EvaluationEntity evaluationEntity;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getEvalId() {
        return evalId;
    }

    public void setEvalId(Long evalId) {
        this.evalId = evalId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public EvaluationEntity getEvaluationEntity() {
        return evaluationEntity;
    }

    public void setEvaluationEntity(EvaluationEntity evaluationEntity) {
        this.evaluationEntity = evaluationEntity;
    }
}
