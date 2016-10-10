package com.yeww.carbao.controller.evaluation;

import com.yeww.carbao.domain.request.evaluation.QueryEvalRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.PageResponseBean;
import com.yeww.carbao.model.evaluation.EvaluationEntity;
import com.yeww.carbao.service.evaluation.IEvaluationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/2.
 */
@Controller
@RequestMapping(value = "/eval/")
public class EvaluationController {

    private static final Logger Logs = LoggerFactory.getLogger(EvaluationController.class);

    @Resource
    private IEvaluationService evaluationService;

    @RequestMapping(value = "to-page")
    public String topage() {
        return "evaluation";
    }

    /**
     * 分页查询评测器
     *
     * @return
     */
    @RequestMapping(value = "query-list")
    @ResponseBody
    public PageResponseBean queryEvalList(QueryEvalRequest request) {
        Logs.info("queryEvalList参数信息：", request);
        try {
            PageResponseBean pageResponseBean = new PageResponseBean();
            List<EvaluationEntity> responseList = evaluationService.queryEvalList(request);
            Integer count = evaluationService.queryEvalListCount(request);
            pageResponseBean.setRows(responseList);
            pageResponseBean.setTotal(count);
            Logs.info("queryEvalList返回信息：" + pageResponseBean);
            return pageResponseBean;
        } catch (Exception e) {
            Logs.error("操作失败：", e);
        }
        return null;
    }

    /**
     * 查询未发布的评测器
     *
     * @return
     */
    @RequestMapping(value = "query-combox-list")
    @ResponseBody
    public List<EvaluationEntity> queryComboxList(QueryEvalRequest request) {
        Logs.info("queryComboxList参数信息：", request);
        try {
            List<EvaluationEntity> responseList = evaluationService.queryEvalList(request);
            Logs.info("queryComboxList返回信息：" + responseList);
            return responseList;
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
    public AppResponse save(EvaluationEntity request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            evaluationService.save(request);
            Logs.info("save返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
            response.setRetinfo(e.getMessage());
        }
        return response;
    }

    /**
     * 删除
     *
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public AppResponse delete(EvaluationEntity request) {
        Logs.info("delete参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            evaluationService.delete(request);
            Logs.info("delete返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
