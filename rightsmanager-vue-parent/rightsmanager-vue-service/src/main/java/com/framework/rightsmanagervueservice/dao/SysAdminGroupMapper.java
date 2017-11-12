package com.framework.rightsmanagervueservice.dao;

import com.framework.rightsmanagervueservice.model.SysAdminGroup;
import com.framework.rightsmanagervueservice.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAdminGroupMapper extends MyMapper<SysAdminGroup> {

    /**
     * 查询分组信息
     * @param userId 用户Id
     * @param status 状态
     * @return
     * */
    List<SysAdminGroup> selectByUserId(@Param("userId") Integer userId, @Param("status") Byte status);
}