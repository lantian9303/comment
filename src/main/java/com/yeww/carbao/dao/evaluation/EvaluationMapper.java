package com.yeww.carbao.dao.evaluation;

import com.yeww.carbao.model.evaluation.EvaluationEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
public interface EvaluationMapper {
    Integer update(EvaluationEntity carEntity);

    Integer insert(EvaluationEntity entity);

    EvaluationEntity selectById(Long id);

    /**
     * 分页查询
     *
     * @param paramMap
     * @return
     */
    List<EvaluationEntity> queryEvalList(Map paramMap);

    /**
     * 分页查询 条数
     *
     * @param paramMap
     * @return
     */
    Integer queryEvalListCount(Map paramMap);
}
