package com.framework.rightsmanagervueservice.model;

import com.framework.rightsmanagervueservice.base.BaseEntity;

import javax.persistence.Transient;
import java.util.List;

public class SysAdminRule extends BaseEntity {

    private String title;

    private String name;

    private Byte level;

    private Integer pid;

    private Byte status;

    /**
     * 子权限
     */
    @Transient
    private List<SysAdminRule> child;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
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

    public List<SysAdminRule> getChild() {
        return child;
    }

    public void setChild(List<SysAdminRule> child) {
        this.child = child;
    }
}