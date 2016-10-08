package com.yeww.carbao.service.organization.impl;

import com.yeww.carbao.dao.organization.EmployeeMapper;
import com.yeww.carbao.domain.request.organization.QueryEmployeeRequest;
import com.yeww.carbao.domain.response.organization.QueryEmployeeResponse;
import com.yeww.carbao.model.organization.EmployeeEntity;
import com.yeww.carbao.service.organization.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/10/2.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @Override
    public List<QueryEmployeeResponse> queryEmployeeList(QueryEmployeeRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("start", request.getStart());
        paramMap.put("rows", request.getRows());
        return employeeMapper.queryEmployeeList(paramMap);
    }

    /**
     * 分页查询条数
     *
     * @param request
     * @return
     */
    @Override
    public Integer queryEmployeeListCount(QueryEmployeeRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("start", request.getStart());
        paramMap.put("rows", request.getRows());
        return employeeMapper.queryEmployeeListCount(paramMap);
    }

    /**
     * @param request
     */
    @Override
    public void save(EmployeeEntity request) throws Exception {
        //查询是否存在
        EmployeeEntity temp = employeeMapper.selectEntityByCode(request.getCode());
        if (temp == null) {
            request.setValidSign(1);
            request.setCreateTime(new Date());
            employeeMapper.insert(request);
        } else {
            throw new Exception("该员工已存在");
        }
    }

    /**
     * 删除
     *
     * @param request
     */
    @Override
    public void delete(EmployeeEntity request) {
        EmployeeEntity temp = employeeMapper.selectById(request.getId());
        if (temp == null) {
            return;
        }
        temp.setValidSign(0);
        employeeMapper.update(temp);
    }
}
