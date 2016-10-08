/*
 * Copyright (C) 2006-2012 Tuniu All rights reserved
 * Author: yeweiwei
 * Date: 2014-01-03
 * Description
 */

package com.yeww.carbao.domain.response;

import java.util.List;

/**
 * 描述
 * <p/>
 * Author yeweiwei
 * Date: 14-1-3
 * Time: 下午3:07
 */
public class PageResponseBean {
    private int total;
    private List rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
