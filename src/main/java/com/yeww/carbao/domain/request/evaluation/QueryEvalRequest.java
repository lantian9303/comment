package com.yeww.carbao.domain.request.evaluation;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
public class QueryEvalRequest extends BaseRequest {
    private Integer validSign;
    private Integer state;

    public Integer getValidSign() {
        return validSign;
    }

    public void setValidSign(Integer validSign) {
        this.validSign = validSign;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
