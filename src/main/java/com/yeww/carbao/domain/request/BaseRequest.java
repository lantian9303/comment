package com.yeww.carbao.domain.request;

import java.io.Serializable;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class BaseRequest implements Serializable {

    /**
     * 模糊查询
     */
    protected String q;
    /**
     * 排序方式
     */
    protected String order;
    /**
     * 所查询的页数
     */
    protected Integer page;
    /**
     * 每页显示的记录数
     */
    protected Integer rows = 30;
    /**
     * 排序的列
     */
    protected String sort;
    /**
     * 查询开始索引
     */
    protected Integer start = 0;

    private String userId;

    /**
     * 加密:simple
     * 不加密:none
     */
    private String encrypt;

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getStart() {
        if (page == null || rows == null) {
            return 0;
        }
        return (page - 1) * rows;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    @Override
    public String toString() {
        return "BaseRequest{" +
                "encrypt='" + encrypt + '\'' +
                "userId='" + userId + '\'' +
                '}';
    }
}
