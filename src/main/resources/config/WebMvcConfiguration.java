package kr.co.openeg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.openeg.lab.common.interceptor.SessionInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Autowired
	private  SessionInterceptor sessionInterceptor;
	
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(sessionInterceptor)
	                .addPathPatterns("/**.do");
	    }
	
	
	
	
	

	
}
