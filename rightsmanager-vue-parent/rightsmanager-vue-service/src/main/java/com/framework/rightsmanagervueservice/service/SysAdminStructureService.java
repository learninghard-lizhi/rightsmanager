package com.framework.rightsmanagervueservice.service;

import com.framework.rightsmanagervueservice.base.BaseServiceImpl;
import com.framework.rightsmanagervueservice.dao.SysAdminStructureMapper;
import com.framework.rightsmanagervueservice.model.SysAdminStructure;
import com.framework.rightsmanagervueservice.util.BeanToMapUtil;
import com.framework.rightsmanagervueservice.util.Category;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by lizhi on 2017/11/6.
 */
@Service
public class SysAdminStructureService extends BaseServiceImpl<SysAdminStructure> {

    @Autowired
    private SysAdminStructureMapper sysAdminStructureDao;

    @Override
    public Mapper<SysAdminStructure> getMapper() {
        return sysAdminStructureDao;
    }

    public List<Map<String, Object>> getDataList() {
        Example example = new Example(SysAdminStructure.class);
        example.setOrderByClause(" id asc");
        List<SysAdminStructure> rootSysAdminStructure = sysAdminStructureDao.selectByExample(example);
        Map<String, String> fields = Maps.newHashMap();
        fields.put("cid", "id");
        fields.put("fid", "pid");
        fields.put("name", "name");
        fields.put("fullname", "title");
        List<Map<String, Object>> rawList = Lists.newArrayList();
        rootSysAdminStructure.forEach((m)->{
            rawList.add(BeanToMapUtil.convertBean(m));
        });
        Category cate = new Category(fields, rawList);
        return cate.getList(Integer.valueOf("0"));
    }
}
