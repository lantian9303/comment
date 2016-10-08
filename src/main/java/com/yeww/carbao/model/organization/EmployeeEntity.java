package com.yeww.carbao.model.organization;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/10/2.
 */
public class EmployeeEntity extends BaseEntity {
    private String code;
    private String name;
    private String email;
    private String orgId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
