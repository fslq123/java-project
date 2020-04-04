package com.fslq.pojo;

import java.util.List;

/*
* 封装JobInfo与页数到实体类，用于传递到html界面（Ajax数据）
* */
public class JobResult {
    private List<JobInfo> rows;
    private Integer pageTotal;

    public List<JobInfo> getRows() {
        return rows;
    }

    public void setRows(List<JobInfo> rows) {
        this.rows=rows;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal=pageTotal;
    }
}
