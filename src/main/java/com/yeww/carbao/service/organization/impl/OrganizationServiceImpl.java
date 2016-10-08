package com.yeww.carbao.service.organization.impl;

import com.yeww.carbao.dao.organization.OrganizationMapper;
import com.yeww.carbao.domain.response.organization.QueryOrganizationResponse;
import com.yeww.carbao.model.organization.OrganizationEntity;
import com.yeww.carbao.service.organization.IOrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/1.
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    /**
     * 查询组织架构
     *
     * @param id
     * @return
     */
    @Override
    public List<OrganizationEntity> queryOrgList(Long id) {
        List<OrganizationEntity> entityList = null;
        if (id != null) {
            entityList = organizationMapper.selectByPid(id);
        } else {
            entityList = organizationMapper.selectByPid(0l);
        }
        return entityList;
    }

    /**
     * 保存
     *
     * @param entity
     */
    @Override
    public void save(OrganizationEntity entity) {
        OrganizationEntity parent = organizationMapper.selectById(entity.getPid());
        parent.setLeaf(0);
        organizationMapper.update(parent);
        entity.setCreateTime(new Date());
        organizationMapper.insert(entity);
    }

    /**
     * 删除
     *
     * @param entity
     */
    @Override
    public void delete(OrganizationEntity entity) {
        delete(entity.getId());
    }

    /**
     * 查询combo tree
     *
     * @param id
     * @return
     */
    @Override
    public List<QueryOrganizationResponse> queryComboTree(Long id) {
        List<OrganizationEntity> entityList = null;
        if (id != null) {
            entityList = organizationMapper.selectByPid(id);
        } else {
            entityList = organizationMapper.selectByPid(0l);
        }
        if(CollectionUtils.isEmpty(entityList)){
            return null;
        }
        List<QueryOrganizationResponse> responseList=new ArrayList<QueryOrganizationResponse>();
        for(OrganizationEntity entity:entityList){
            QueryOrganizationResponse response=new QueryOrganizationResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }

    private void delete(Long id) {
        OrganizationEntity temp = organizationMapper.selectById(id);
        if (temp == null) {
            return;
        }
        temp.setValidSign(0);
        organizationMapper.update(temp);
        if (temp.getLeaf() == 1) {
            return;
        }
        List<OrganizationEntity> entityList = organizationMapper.selectByPid(id);
        if (CollectionUtils.isEmpty(entityList)) {
            return;
        }
        for (OrganizationEntity entity : entityList) {
            delete(entity.getId());
        }
    }
}
