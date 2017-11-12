package com.framework.rightsmanagervueservice.model;

import com.framework.rightsmanagervueservice.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

public class SysAdminMenu extends BaseEntity{
    private Integer pid;

    private String title;

    private String url;

    private String icon;

    private Byte menuType;

    private Byte sort;

    private Byte status;

    private Integer ruleId;

    private String module;

    private String menu;

    private String ruleName;

    /**
     * 子菜单
     */
    @Transient
    private List<SysAdminMenu> child;
    /**
     * 是否选中
     */
    @Transient
    private Boolean selected = false;
    /**
     * 级别
     */
    @Transient
    private Integer level;

    /**
     * 全名
     */
    @Transient
    private String fullName;

    /**
     * 关键权限
     */
    @Transient
    private SysAdminRule rule;

    /**
     * 获取上级菜单ID
     *
     * @return pid - 上级菜单ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置上级菜单ID
     *
     * @param pid 上级菜单ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Byte getMenuType() {
        return menuType;
    }

    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu == null ? null : menu.trim();
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public List<SysAdminMenu> getChild() {
        return child;
    }

    public void setChild(List<SysAdminMenu> child) {
        this.child = child;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SysAdminRule getRule() {
        return rule;
    }

    public void setRule(SysAdminRule rule) {
        this.rule = rule;
    }
}