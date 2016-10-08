package com.yeww.carbao.model;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

    private Long id;

    private Integer validSign;

    private Date createTime;

    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValidSign() {
        return validSign;
    }

    public void setValidSign(Integer validSign) {
        this.validSign = validSign;
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
}