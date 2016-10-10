package com.yeww.carbao.service.question.impl;

import com.yeww.carbao.dao.evaluation.EvaluationMapper;
import com.yeww.carbao.dao.question.QuestionMapper;
import com.yeww.carbao.domain.request.question.QueryQuestRequest;
import com.yeww.carbao.model.evaluation.EvaluationEntity;
import com.yeww.carbao.model.question.QuestionEntity;
import com.yeww.carbao.service.question.IQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/10.
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private EvaluationMapper evaluationMapper;

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @Override
    public List<QuestionEntity> queryQuestList(QueryQuestRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("start", request.getStart());
        paramMap.put("rows", request.getRows());
        return questionMapper.queryQuestList(paramMap);
    }

    /**
     * 分页查询 条数
     *
     * @param request
     * @return
     */
    @Override
    public Integer queryQuestListCount(QueryQuestRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("start", request.getStart());
        paramMap.put("rows", request.getRows());
        return questionMapper.queryQuestListCount(paramMap);
    }

    /**
     * 保存
     *
     * @param request
     */
    @Override
    public void save(QuestionEntity request) throws Exception {
        EvaluationEntity eval = evaluationMapper.selectById(request.getEvalId());
        if (eval == null) {
            return;
        }
        if (eval.getState() == 1) {//已经发布
            throw new Exception("该测评已经发布，不能增加题目");
        }
        int score = request.getScore() + eval.getScore();
        if (score > 100) {
            throw new Exception("该测评总分值不能超过100，请核查");
        }
        request.setValidSign(1);
        request.setCreateTime(new Date());
        request.setModifyTime(request.getCreateTime());
        request.setItemNum(0);
        questionMapper.insert(request);
        eval.setScore(score);
        evaluationMapper.update(eval);
    }
}
