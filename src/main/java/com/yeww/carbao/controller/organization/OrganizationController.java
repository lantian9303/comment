package com.yeww.carbao.controller.organization;

import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.organization.QueryOrganizationResponse;
import com.yeww.carbao.model.organization.OrganizationEntity;
import com.yeww.carbao.service.organization.IOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/1.
 */
@Controller
@RequestMapping(value = "/org/")
public class OrganizationController {

    private static final Logger Logs = LoggerFactory.getLogger(OrganizationController.class);

    @Resource
    private IOrganizationService organizationService;


    @RequestMapping(value = "to-page")
    public String topage() {
        return "organization";
    }

    /**
     * 查询组织架构
     *
     * @return
     */
    @RequestMapping(value = "query-tree")
    @ResponseBody
    public List<OrganizationEntity> queryOrgList(Long id) {
        Logs.info("queryOrgList参数信息：", id);
        try {
            List<OrganizationEntity> responseList = organizationService.queryOrgList(id);
            Logs.info("queryOrgList返回信息：" + responseList);
            return responseList;
        } catch (Exception e) {
            Logs.error("操作失败：", e);
        }
        return null;
    }

    /**
     * 查询组织架构
     *
     * @return
     */
    @RequestMapping(value = "combo-tree")
    @ResponseBody
    public List<QueryOrganizationResponse> queryComboTree(Long id) {
        Logs.info("queryComboTree参数信息：", id);
        try {
            List<QueryOrganizationResponse> responseList = organizationService.queryComboTree(id);
            Logs.info("queryComboTree返回信息：" + responseList);
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
    public AppResponse save(OrganizationEntity request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            organizationService.save(request);
            Logs.info("save返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
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
    public AppResponse delete(OrganizationEntity request) {
        Logs.info("delete参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            organizationService.delete(request);
            Logs.info("delete返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
