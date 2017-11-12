package com.framework.rightsmanagervueservice.dao;

import com.framework.rightsmanagervueservice.model.SysAdminRule;
import com.framework.rightsmanagervueservice.model.SysSystemConfig;
import com.framework.rightsmanagervueservice.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysSystemConfigMapper extends MyMapper<SysSystemConfig> {

    List<SysSystemConfig> selectAll();
}