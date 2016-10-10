package com.yeww.carbao.service.question;

import com.yeww.carbao.domain.request.question.QueryQuestRequest;
import com.yeww.carbao.model.question.QuestionEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
public interface IQuestionService {
    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    List<QuestionEntity> queryQuestList(QueryQuestRequest request);

    /**
     * 分页查询 条数
     *
     * @param request
     * @return
     */
    Integer queryQuestListCount(QueryQuestRequest request);

    /**
     * 保存
     *
     * @param request
     */
    void save(QuestionEntity request) throws Exception;
}
