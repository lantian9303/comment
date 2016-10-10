package com.yeww.carbao.model.evaluation;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
public class EvaluationEntity extends BaseEntity {
    private String name;
    private Integer score;
    private Integer state;
    private Integer questNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getQuestNum() {
        return questNum;
    }

    public void setQuestNum(Integer questNum) {
        this.questNum = questNum;
    }
}
