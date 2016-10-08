package com.yeww.carbao.service.organization;

import com.yeww.carbao.domain.request.organization.QueryEmployeeRequest;
import com.yeww.carbao.domain.response.organization.QueryEmployeeResponse;
import com.yeww.carbao.model.organization.EmployeeEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/10/2.
 */
public interface IEmployeeService {
    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    List<QueryEmployeeResponse> queryEmployeeList(QueryEmployeeRequest request);

    /**
     * 分页查询条数
     *
     * @param request
     * @return
     */
    Integer queryEmployeeListCount(QueryEmployeeRequest request);

    /**
     * @param request
     */
    void save(EmployeeEntity request) throws Exception;

    /**
     * 删除
     *
     * @param request
     */
    void delete(EmployeeEntity request);
}
