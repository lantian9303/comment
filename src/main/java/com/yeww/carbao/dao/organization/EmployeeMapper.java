package com.yeww.carbao.dao.organization;

import com.yeww.carbao.domain.response.organization.QueryEmployeeResponse;
import com.yeww.carbao.model.organization.EmployeeEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/2.
 */
public interface EmployeeMapper {
    Integer update(EmployeeEntity carEntity);

    Integer insert(EmployeeEntity entity);

    EmployeeEntity selectById(Long id);

    /**
     * 分页查询
     *
     * @param paramMap
     * @return
     */
    List<QueryEmployeeResponse> queryEmployeeList(Map paramMap);

    /**
     * 分页查询 条数
     *
     * @param paramMap
     * @return
     */
    Integer queryEmployeeListCount(Map paramMap);

    /**
     * 按照工号查询
     *
     * @param code
     * @return
     */
    EmployeeEntity selectEntityByCode(String code);
}
