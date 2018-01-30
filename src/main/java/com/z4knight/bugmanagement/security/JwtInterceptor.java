package com.z4knight.bugmanagement.security;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.GeneralMsg;
import com.z4knight.bugmanagement.enums.LoggerMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Z4knight
 * @Date 2018/1/29 13:38
 *
 * 自定义请求拦截器
 */
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader(GeneralMsg.AUTH_HEADERS.getMsg());
        if (authHeader == null || !authHeader.startsWith(GeneralMsg.AUTH_SEGMENT.getMsg())) {
            log.error(LoggerMsg.USER_MANAGER_VERIFY_AUTH_HEADERS.getMsg() + ", ErrorMsg={}",ErrorMsg.INVALID_AUTHORIZATION_HEADER.getMsg());
            throw new ServletException(ErrorMsg.INVALID_AUTHORIZATION_HEADER.getMsg());
        }
        //取得token
        String token = authHeader.substring(7);
        try {
            JwtUtil.checkToken(token);
            return true;
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
