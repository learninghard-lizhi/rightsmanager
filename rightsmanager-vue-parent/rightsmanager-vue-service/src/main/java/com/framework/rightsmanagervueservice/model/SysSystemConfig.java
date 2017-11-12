package com.framework.rightsmanagervueservice.model;

import com.framework.rightsmanagervueservice.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`sys_system_config`")
public class SysSystemConfig extends BaseEntity {
    @Column(name = "`name`")
    private String name;

    @Column(name = "`value`")
    private String value;

    @Column(name = "`group`")
    private Byte group;

    @Column(name = "`need_auth`")
    private Byte needAuth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Byte getGroup() {
        return group;
    }

    public void setGroup(Byte group) {
        this.group = group;
    }

    public Byte getNeedAuth() {
        return needAuth;
    }

    public void setNeedAuth(Byte needAuth) {
        this.needAuth = needAuth;
    }
}