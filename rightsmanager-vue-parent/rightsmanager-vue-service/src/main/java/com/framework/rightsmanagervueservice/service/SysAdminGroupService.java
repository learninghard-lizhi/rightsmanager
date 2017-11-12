package com.framework.rightsmanagervueservice.service;

import com.framework.rightsmanagervueservice.base.BaseServiceImpl;
import com.framework.rightsmanagervueservice.dao.SysAdminGroupMapper;
import com.framework.rightsmanagervueservice.model.SysAdminGroup;
import com.framework.rightsmanagervueservice.util.BeanToMapUtil;
import com.framework.rightsmanagervueservice.util.Category;
import com.google.common.collect.Interner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by lizhi on 2017/11/5.
 */
@Service
public class SysAdminGroupService extends BaseServiceImpl<SysAdminGroup>{

    @Autowired
    private SysAdminGroupMapper sysAdminGroupMapper;

    @Override
    public Mapper<SysAdminGroup> getMapper() {
        return sysAdminGroupMapper;
    }

    public List<Map<String,Object>> getDataList(){
        Example example = new Example(SysAdminGroup.class);
        List<SysAdminGroup> rootSysAdminGroups  = sysAdminGroupMapper.selectByExample(example);
        Map<String, String> fields = Maps.newHashMap();
        fields.put("cid", "id");
        fields.put("fid", "pid");
        fields.put("name", "title");
        fields.put("fullname", "title");
        List<Map<String, Object>> rawList = Lists.newArrayList();
        rootSysAdminGroups.forEach(m->{
            rawList.add(BeanToMapUtil.convertBean(m));
        });
        Category cate = new Category(fields, rawList);
        return cate.getList(Integer.valueOf("0"));
    }
}
