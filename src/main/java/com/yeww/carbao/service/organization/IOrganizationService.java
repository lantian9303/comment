package com.yeww.carbao.service.organization;

import com.yeww.carbao.domain.response.organization.QueryOrganizationResponse;
import com.yeww.carbao.model.organization.OrganizationEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/1.
 */
public interface IOrganizationService {
    /**
     * 查询组织架构
     *
     * @param id
     * @return
     */
    List<OrganizationEntity> queryOrgList(Long id);

    /**
     * 保存
     *
     * @param entity
     */
    void save(OrganizationEntity entity);

    /**
     * 删除
     *
     * @param request
     */
    void delete(OrganizationEntity request);

    /**
     * 查询combo tree
     *
     * @param id
     * @return
     */
    List<QueryOrganizationResponse> queryComboTree(Long id);
}
