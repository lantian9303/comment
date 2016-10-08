package com.yeww.carbao.model.organization;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/10/1.
 */
public class OrganizationEntity  extends BaseEntity{
    private String code;
    private String name;
    private Long pid;
    private Integer leaf;
    private String state;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getState() {
        this.state = getLeaf() == 1 ? "open" : "closed";
        return state;
    }
}
