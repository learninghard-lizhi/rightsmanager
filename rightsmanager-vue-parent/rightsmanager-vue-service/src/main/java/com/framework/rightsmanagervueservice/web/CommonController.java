package com.framework.rightsmanagervueservice.web;

import com.framework.rightsmanagervueservice.util.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import com.framework.rightsmanagervueservice.contants.Constant;
import com.framework.rightsmanagervueservice.model.SysAdminUser;
import com.framework.rightsmanagervueservice.service.SysAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 公共控制器
 * Created by lizhi on 2017/11/5.
 */
public class CommonController {

    @Autowired
    private SysAdminUserService sysAdminUserService;

    /**
     * 获取当前登录用户
     */
    public SysAdminUser getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String authKey = request.getHeader(Constant.AUTH_KEY);
        if(StringUtils.isNoneBlank(authKey)){
            String decryptAuthKey = EncryptUtil.decryptBase64(authKey, Constant.SECRET_KEY);
            String[]  auths = decryptAuthKey.split("\\|");
            String username = auths[0];
            String password = auths[1];
            SysAdminUser record = new SysAdminUser();
            record.setUsername(username);
            record.setPassword(password);
            return sysAdminUserService.selectOne(record);
        }

        return null;
    }
}
