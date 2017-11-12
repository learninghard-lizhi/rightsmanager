package com.framework.rightsmanagervueservice.service;

import com.framework.rightsmanagervueservice.base.BaseServiceImpl;
import com.framework.rightsmanagervueservice.dao.SysAdminAccessMapper;
import com.framework.rightsmanagervueservice.model.SysAdminAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by lizhi on 2017/11/5.
 */
@Service
public class SysAdminAccessService extends BaseServiceImpl<SysAdminAccess>{

    @Autowired
    private SysAdminAccessMapper sysAdminAccessMapper;

    @Override
    public Mapper<SysAdminAccess> getMapper() {
        return sysAdminAccessMapper;
    }
}
