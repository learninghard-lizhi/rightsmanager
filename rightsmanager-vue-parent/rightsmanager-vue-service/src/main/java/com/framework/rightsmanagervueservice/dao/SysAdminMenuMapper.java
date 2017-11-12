package com.framework.rightsmanagervueservice.dao;

import com.framework.rightsmanagervueservice.model.SysAdminMenu;
import com.framework.rightsmanagervueservice.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAdminMenuMapper extends MyMapper<SysAdminMenu> {
    /**
     * 根据ruleIds查询菜单信息
     * @param ruleIds 权限id
     * @param status 状态值
     * @return List<SysAdminMenu>
     */
    List<SysAdminMenu> selectInRuleIds(@Param("ruleIds") String ruleIds, @Param("status") int status);
}