package com.yeww.carbao.controller.organization;

import com.yeww.carbao.domain.request.organization.QueryEmployeeRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.PageResponseBean;
import com.yeww.carbao.domain.response.organization.QueryEmployeeResponse;
import com.yeww.carbao.model.organization.EmployeeEntity;
import com.yeww.carbao.service.organization.IEmployeeService;
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
@RequestMapping(value = "/employee/")
public class EmployeeController {

    private static final Logger Logs = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private IEmployeeService employeeService;

    @RequestMapping(value = "to-page")
    public String topage() {
        return "employee";
    }

    /**
     * 查询组织架构
     *
     * @return
     */
    @RequestMapping(value = "query-list")
    @ResponseBody
    public PageResponseBean queryEmployeeList(QueryEmployeeRequest request) {
        Logs.info("queryEmployeeList参数信息：", request);
        try {
            PageResponseBean pageResponseBean=new PageResponseBean();
            List<QueryEmployeeResponse> responseList = employeeService.queryEmployeeList(request);
            Integer count = employeeService.queryEmployeeListCount(request);
            pageResponseBean.setRows(responseList);
            pageResponseBean.setTotal(count);
            Logs.info("queryEmployeeList返回信息：" + pageResponseBean);
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
    public AppResponse save(EmployeeEntity request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            employeeService.save(request);
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
    public AppResponse delete(EmployeeEntity request) {
        Logs.info("delete参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            employeeService.delete(request);
            Logs.info("delete返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
