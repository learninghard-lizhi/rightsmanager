package com.framework.rightsmanagervueservice.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by lizhi on 2017/11/4.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
