package com.cssl.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cssl.mvc.MyIntercepter;

@Component
public class MymvcCofnig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("添加自己定义拦截器");
		registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**").excludePathPatterns("/js/**", "/images/**");

	}

//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		// 没有添加默认也是这个视图解析器
//		// 默认配置:org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
//		registry.viewResolver(new InternalResourceViewResolver("/", ".jsp"));
//	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter sh = new StringHttpMessageConverter(Charset.forName("utf-8"));
		// 没有添加默认也有该消息转换器
		converters.add(sh);
	}

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路由
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(3600);
        
    }

}
