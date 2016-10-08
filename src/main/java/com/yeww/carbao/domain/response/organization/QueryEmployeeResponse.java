package com.yeww.carbao.domain.response.organization;

import com.yeww.carbao.domain.response.BaseResponse;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * Created by yeweiwei1 on 2016/10/2.
 */
public class QueryEmployeeResponse extends BaseResponse {
    private Long id;
    private String code;
    private String name;
    private String email;
    private String orgId;
    private Integer validSign;
    private String orgCode;
    private String orgName;
    private Date createTime;
    private Date modifyTime;
    private String enterTimeStr;
    private String modifyTimeStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getValidSign() {
        return validSign;
    }

    public void setValidSign(Integer validSign) {
        this.validSign = validSign;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getEnterTimeStr() {
        return DateFormatUtils.format(createTime,"yyyy-MM-dd HH:mm:ss");
    }

    public void setEnterTimeStr(String enterTimeStr) {
        this.enterTimeStr = enterTimeStr;
    }

    public String getModifyTimeStr() {
        return DateFormatUtils.format(modifyTime,"yyyy-MM-dd HH:mm:ss");
    }

    public void setModifyTimeStr(String modifyTimeStr) {
        this.modifyTimeStr = modifyTimeStr;
    }
}
