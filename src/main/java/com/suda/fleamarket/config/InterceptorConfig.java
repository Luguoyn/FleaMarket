package com.suda.fleamarket.config;

import com.suda.fleamarket.anno.CurrentUserIdHandlerMethodArgResolver;
import com.suda.fleamarket.enums.Authority;
import com.suda.fleamarket.interceptors.AuthorityInterceptor;
import com.suda.fleamarket.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public JWTInterceptor jwtInterceptor() {
        return new JWTInterceptor();
    }

    @Bean
    public AuthorityInterceptor adminInterceptor() {
        return new AuthorityInterceptor(Authority.ADMIN);
    }

    @Bean
    public AuthorityInterceptor sellerInterceptor() {
        return new AuthorityInterceptor(Authority.SELLER);
    }

    @Bean
    public AuthorityInterceptor customerInterceptor() {
        return new AuthorityInterceptor(Authority.CUSTOMER);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // token 拦截器
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**") //拦截
                .excludePathPatterns(
                        "/security/register", "/security/login",
                        "/goods/list/**", "/goods/list-u/*", "/goods/info/**", "/goods/select",
                        "/user/info/*"
                );

        // 管理员拦截器
        registry.addInterceptor(adminInterceptor())
                .addPathPatterns("/admin/**");

        // 商家拦截器
        registry.addInterceptor(sellerInterceptor())
                .addPathPatterns("/goods/publish");

        // 客户拦截器
        registry.addInterceptor(customerInterceptor())
                .addPathPatterns("/order/**");
    }

    /**
     * 实现请求跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Bean
    public CurrentUserIdHandlerMethodArgResolver currentUserIdHandlerMethodArgResolver() {
        return new CurrentUserIdHandlerMethodArgResolver();
    }

    /**
     * 注册注解实现类
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserIdHandlerMethodArgResolver());
    }
}
