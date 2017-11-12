package com.framework.rightsmanagervueservice.model;

import com.framework.rightsmanagervueservice.base.BaseEntity;

public class SysAdminStructure extends BaseEntity {
    private String name;

    private Integer pid;

    private Byte status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}