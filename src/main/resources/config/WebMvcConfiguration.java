import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.openeg.lab.common.interceptor.SessionInterceptor;

@Configuration
public class WebMvcConfiguration implements webMvcConfigurer {

	@Autowired
	private  SessionInterceptor sessionInterceptor;
	
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(sessionInterceptor)
	                .addPathPatterns("/**/*.do");
	    }
	
	
	
	
	

	
}
