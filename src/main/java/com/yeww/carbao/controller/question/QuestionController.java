package com.yeww.carbao.controller.question;

import com.yeww.carbao.domain.request.question.QueryQuestRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.PageResponseBean;
import com.yeww.carbao.model.question.QuestionEntity;
import com.yeww.carbao.service.question.IQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/9.
 */
@Controller
@RequestMapping(value = "/quest/")
public class QuestionController {


    private static final Logger Logs = LoggerFactory.getLogger(QuestionController.class);

    @Resource
    private IQuestionService questionService;

    @RequestMapping(value = "to-page")
    public String topage() {
        return "question";
    }

    /**
     * 查询组织架构
     *
     * @return
     */
    @RequestMapping(value = "query-list")
    @ResponseBody
    public PageResponseBean queryQuestList(QueryQuestRequest request) {
        Logs.info("queryQuestList参数信息：", request);
        try {
            PageResponseBean pageResponseBean = new PageResponseBean();
            List<QuestionEntity> responseList = questionService.queryQuestList(request);
            Integer count = questionService.queryQuestListCount(request);
            pageResponseBean.setRows(responseList);
            pageResponseBean.setTotal(count);
            Logs.info("queryQuestList返回信息：" + pageResponseBean);
            return pageResponseBean;
        } catch (Exception e) {
            Logs.error("操作失败：", e);
        }
        return null;
    }

    /**
     * 保存
     *
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public AppResponse save(QuestionEntity request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            questionService.save(request);
            Logs.info("save返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
            response.setRetinfo(e.getMessage());
        }
        return response;
    }
}
