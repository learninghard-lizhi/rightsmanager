package com.framework.rightsmanagervueservice.dao;

import com.framework.rightsmanagervueservice.model.SysAdminRule;
import com.framework.rightsmanagervueservice.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAdminRuleMapper extends MyMapper<SysAdminRule> {

    List<SysAdminRule> selectInIds(@Param("ruleIds") String ruleIds, @Param("status") Integer status);

    List<SysAdminRule> selectByStatus(@Param("status") Integer status);
}