package com.framework.rightsmanagervueservice.service;

import com.framework.rightsmanagervueservice.base.BaseServiceImpl;
import com.framework.rightsmanagervueservice.dao.SysSystemConfigMapper;
import com.framework.rightsmanagervueservice.model.SysAdminGroup;
import com.framework.rightsmanagervueservice.model.SysAdminRule;
import com.framework.rightsmanagervueservice.model.SysSystemConfig;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by lizhi on 2017/11/6.
 */
@Service
public class SysSystemConfigService extends BaseServiceImpl<SysSystemConfig> {
    @Autowired
    private SysSystemConfigMapper sysSystemConfigDao;

    @Override
    public Mapper<SysSystemConfig> getMapper() {

        return sysSystemConfigDao;
    }

    /**
     * 查询所有配置
     * @return
     */
    public List<SysSystemConfig> selectAll() {
        return sysSystemConfigDao.selectAll();
    }
}
