package com.z4knight.bugmanagement.security;

import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.GeneralMsg;
import com.z4knight.bugmanagement.enums.LoggerMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Author Z4knight
 * @Date 2018/1/29 13:34
 *
 * jwt 认证工具类
 */
@Slf4j
public class JwtUtil {

    final static long TOKEN_EXP = 10000 * 360;//过期时间,测试使用一个小时

    private static String curUserName;

    private static String curUserRole;

    public static String getToken(String userName, String userRole) {
        String token =  Jwts.builder()
                .setSubject(userName)
                .claim(GeneralMsg.AUTH_USER_NAME.getMsg(), userName)
                .claim(GeneralMsg.AUTH_ROLE.getMsg(), userRole)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP)) /*过期时间*/
                .signWith(SignatureAlgorithm.HS256, GeneralMsg.SECRET_KEY.getMsg())
                .compact();
        log.info(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", Token={}", token);
        return token;
    }


    public static void checkToken(String token) throws ServletException {
        try {
            final Claims claims = Jwts.parser().setSigningKey(GeneralMsg.SECRET_KEY.getMsg()).parseClaimsJws(token).getBody();
            curUserName = (String) claims.get(GeneralMsg.AUTH_USER_NAME.getMsg());
            curUserRole = (String) claims.get(GeneralMsg.AUTH_ROLE.getMsg());

        } catch (ExpiredJwtException e1) {
            log.error(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", ErrorMsg={}", ErrorMsg.TOKEN_EXPIRED.getMsg());
            throw new ServletException(ErrorMsg.TOKEN_EXPIRED.getMsg());
        } catch (Exception e) {
            log.error(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", ErrorMsg={}", ErrorMsg.OTHER_TOKEN_EXCEPTION.getMsg());
            throw new ServletException(ErrorMsg.OTHER_TOKEN_EXCEPTION.getMsg());
        }
    }

    public static String getCurrentUserName() {
        log.info(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", curLoginUser={}", curUserName);
        if (StringUtils.isEmpty(curUserName)) {
            log.error(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", ErrorMsg={}", ErrorMsg.CUR_USER_NAME_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.CUR_USER_NAME_NOT_EXIST.getMsg());
        }
        return curUserName;
    }

    public static String getCurUserRole() {
        log.info(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", curUserRole={}", curUserRole);
        if (StringUtils.isEmpty(curUserRole)) {
            log.error(LoggerMsg.USER_MANAGER_AUTH_TOKEN.getMsg() + ", ErrorMsg={}", ErrorMsg.CUR_USER_NAME_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.CUR_USER_NAME_NOT_EXIST.getMsg());
        }
        return curUserRole;
    }

}
