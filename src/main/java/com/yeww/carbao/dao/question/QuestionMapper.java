package com.yeww.carbao.dao.question;

import com.yeww.carbao.model.question.QuestionEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/10.
 */
public interface QuestionMapper {
    Integer update(QuestionEntity carEntity);

    Integer insert(QuestionEntity entity);

    QuestionEntity selectById(Long id);

    /**
     * 分页查询
     *
     * @param paramMap
     * @return
     */
    List<QuestionEntity> queryQuestList(Map paramMap);

    /**
     * 分页查询 条数
     *
     * @param paramMap
     * @return
     */
    Integer queryQuestListCount(Map paramMap);
}
