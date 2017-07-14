package com.xiaoyulaoshishuo.app.kq.model;

import java.util.Date;

public class Role {
    private Long id;

    private String roleName;

    private String permitions;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getPermitions() {
        return permitions;
    }

    public void setPermitions(String permitions) {
        this.permitions = permitions == null ? null : permitions.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}