package com.yeww.carbao.domain.response.organization;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.organization.OrganizationEntity;

/**
 * Created by yeweiwei1 on 2016/10/1.
 */
public class QueryOrganizationResponse extends BaseResponse<OrganizationEntity> {
    private Long id;
    private String text;
    private String state;
    private String checked;
    private String attributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public void converter(OrganizationEntity organizationEntity) {
        this.id = organizationEntity.getId();
        this.text = organizationEntity.getName();
        this.state = organizationEntity.getLeaf() == 1 ? "open" : "closed";
    }
}
