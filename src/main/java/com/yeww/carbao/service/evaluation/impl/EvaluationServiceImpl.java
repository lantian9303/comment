package com.yeww.carbao.service.evaluation.impl;

import com.yeww.carbao.dao.evaluation.EvaluationMapper;
import com.yeww.carbao.domain.request.evaluation.QueryEvalRequest;
import com.yeww.carbao.model.evaluation.EvaluationEntity;
import com.yeww.carbao.service.evaluation.IEvaluationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
@Service
public class EvaluationServiceImpl implements IEvaluationService {

    @Resource
    private EvaluationMapper evaluationMapper;

    /**
     * 查询列表
     *
     * @param request
     * @return
     */
    @Override
    public List<EvaluationEntity> queryEvalList(QueryEvalRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("start", request.getStart());
        paramMap.put("rows", request.getRows());
        if (request.getValidSign() != null) {
            paramMap.put("validSign", request.getValidSign());
        }
        if (request.getState() != null) {
            paramMap.put("state", request.getState());
        }
        return evaluationMapper.queryEvalList(paramMap);
    }

    /**
     * 查询条数
     *
     * @param request
     * @return
     */
    @Override
    public Integer queryEvalListCount(QueryEvalRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("start", request.getStart());
        paramMap.put("rows", request.getRows());
        if (request.getValidSign() != null) {
            paramMap.put("validSign", request.getValidSign());
        }
        if (request.getState() != null) {
            paramMap.put("state", request.getState());
        }
        return evaluationMapper.queryEvalListCount(paramMap);
    }

    /**
     * 保存
     *
     * @param request
     */
    @Override
    public void save(EvaluationEntity request) {
        request.setValidSign(1);
        request.setCreateTime(new Date());
        request.setModifyTime(request.getCreateTime());
        request.setState(0);
        request.setQuestNum(0);
        request.setScore(0);
        evaluationMapper.insert(request);
    }

    /**
     * 删除
     *
     * @param request
     */
    @Override
    public void delete(EvaluationEntity request) {
        EvaluationEntity temp = evaluationMapper.selectById(request.getId());
        if (temp == null) {
            return;
        }
        temp.setValidSign(0);
        evaluationMapper.update(temp);
    }
}
