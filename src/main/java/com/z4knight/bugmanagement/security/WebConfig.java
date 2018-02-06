package com.z4knight.bugmanagement.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author Z4knight
 * @Date 2018/1/29 13:29
 *
 * 访问配置类
 * 跨域配置，拦截配置
 */

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许全部跨域访问
        registry.addMapping("/**")
                .allowedOrigins("*")
                .exposedHeaders("x-total-count","x-auth-token")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE");
    }

    // 注册拦截器，将登录排除
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new JwtInterceptor())
                .excludePathPatterns("/userManagement/login")
//                .excludePathPatterns("/groupManagement/*")
//                .excludePathPatterns("/processManagement/*")
//                .excludePathPatterns("/orderManagement/*")
//                .excludePathPatterns("/taskManagement/*")
//                .excludePathPatterns("/testSystemManagement/*")
//                .excludePathPatterns("/HistoricProcessManagement/*")
        ;
    }
}
