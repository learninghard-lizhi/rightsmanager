package com.framework.rightsmanagervueservice.service;

import com.framework.rightsmanagervueservice.base.BaseServiceImpl;
import com.framework.rightsmanagervueservice.dao.SysAdminPostMapper;
import com.framework.rightsmanagervueservice.model.SysAdminPost;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lizhi on 2017/11/6.
 */
@Service
public class SysAdminPostService extends BaseServiceImpl<SysAdminPost> {

    @Autowired
    private SysAdminPostMapper sysAdminPostDao;

    @Override
    public Mapper<SysAdminPost> getMapper() {
        return sysAdminPostDao;
    }

    public List<SysAdminPost> getDataList(String name) {
        Example example = new Example(SysAdminPost.class,false);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andLike("name", name);
        }
        return sysAdminPostDao.selectByExample(example);
    }

}
