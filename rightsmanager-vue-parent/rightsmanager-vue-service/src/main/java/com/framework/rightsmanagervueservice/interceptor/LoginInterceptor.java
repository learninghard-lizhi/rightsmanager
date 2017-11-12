package com.framework.rightsmanagervueservice.interceptor;

import com.framework.rightsmanagervueservice.contants.Constant;
import com.framework.rightsmanagervueservice.model.SysAdminUser;
import com.framework.rightsmanagervueservice.service.SysAdminUserService;
import com.framework.rightsmanagervueservice.util.EncryptUtil;
import com.framework.rightsmanagervueservice.util.FastJsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by lizhi on 2017/11/8.
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter  {

    @Autowired
    private SysAdminUserService sysAdminUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("请求url:" + request.getRequestURI());
        System.out.println("header auth key:" + request.getHeader(Constant.AUTH_KEY));
        String authKey = request.getHeader(Constant.AUTH_KEY);
        String sessionId = request.getHeader(Constant.SESSION_ID);
        HttpSession session = request.getSession();
        // 校验sessionid和authKey
        if(StringUtils.isEmpty(authKey) || StringUtils.isEmpty(sessionId)) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(FastJsonUtils.resultError(-100, "authKey或sessionId不能为空！", null));
            writer.flush();
            return false;
        }

        //检查账号有效性
        SysAdminUser sessionAdminUser = (SysAdminUser)session.getAttribute(Constant.LOGIN_ADMIN_USER);
        if(sessionAdminUser == null) {
            String decryptAuthKey = EncryptUtil.decryptBase64(authKey, Constant.SECRET_KEY);
            String[]  auths = decryptAuthKey.split("\\|");
            String username = auths[0];
            String password = auths[1];
            SysAdminUser record = new SysAdminUser();
            record.setUsername(username);
            record.setPassword(password);
            sessionAdminUser = sysAdminUserService.selectOne(record);
            //设置登录用户id
            session.setAttribute(Constant.LOGIN_ADMIN_USER, sessionAdminUser);
        }

        if(sessionAdminUser == null || sessionAdminUser.getStatus().equals(0)) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(FastJsonUtils.resultError(-101, "账号已被删除或禁用", null));
            writer.flush();
            return false;
        }

        return true;
    }
}
