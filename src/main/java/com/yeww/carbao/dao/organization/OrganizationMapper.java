package com.yeww.carbao.dao.organization;

import com.yeww.carbao.model.organization.OrganizationEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public interface OrganizationMapper {
    Integer insert(OrganizationEntity entity);

    OrganizationEntity selectById(Long id);

    Integer update(OrganizationEntity carEntity);

    List<OrganizationEntity> selectByPid(Long pid);
}
