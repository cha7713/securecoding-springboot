package kr.co.openeg.lab.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
		                                  HttpServletResponse response, Object handler) throws Exception {
		// check variable
		Object userId = request.getSession().getAttribute("userId");
		//
		if(request.getRequestURI().contains("/test/init_db.do") && "admin".equals(userId)) {
			 return true;
		}

		// pass through when access login.do, join.do
		
		if(request.getRequestURI().equals("/login.do") || request.getRequestURI().equals("/member/join.do")){
			if((userId != null) && (userId !="") ){
				response.sendRedirect(request.getContextPath() + "/board/main.do");
				return true;
			} else {
				return true;
			}
		}
		//
		// where other pages		
		if((userId == null) || (userId == "") ){
			response.sendRedirect(request.getContextPath() + "/login.do");
			HttpSession session=request.getSession();
			session.setAttribute("errCode", "4");
			return false;
		} else {
			return true;
		}
		//		
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
