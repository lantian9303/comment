package com.yeww.carbao.service.evaluation;

import com.yeww.carbao.domain.request.evaluation.QueryEvalRequest;
import com.yeww.carbao.model.evaluation.EvaluationEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
public interface IEvaluationService {
    /**
     * 查询列表
     *
     * @param request
     * @return
     */
    List<EvaluationEntity> queryEvalList(QueryEvalRequest request);

    /**
     * 查询条数
     *
     * @param request
     * @return
     */
    Integer queryEvalListCount(QueryEvalRequest request);

    /**
     * 保存
     *
     * @param request
     */
    void save(EvaluationEntity request);

    /**
     * 删除
     *
     * @param request
     */
    void delete(EvaluationEntity request);
}
