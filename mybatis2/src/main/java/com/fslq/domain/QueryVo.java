package com.fslq.domain;
/*用于包装查询条件*/
public class QueryVo {
    private User user;

    public QueryVo(User user) {
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}
