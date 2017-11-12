package com.framework.rightsmanagervueservice.model;

import com.framework.rightsmanagervueservice.base.BaseEntity;

public class SysAdminAccess extends BaseEntity {
    private Integer userId;

    private Integer groupId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}