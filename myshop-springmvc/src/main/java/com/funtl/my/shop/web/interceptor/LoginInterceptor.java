package com.funtl.my.shop.web.interceptor;

import com.funtl.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.funtl.my.shop.commons.constant.ConstantUtils.SESSION_USER;

/**
 * 此处填写说明
 *
 * @author wuyiwen
 * @createDate 2019/5/24
 */
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    User user = (User)httpServletRequest.getSession().getAttribute(SESSION_USER);
    //未登录
    if (user == null ) {
      httpServletResponse.sendRedirect("/login");
      return false;
    }
    return true;
  }
  
  @Override
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
  
  }
  
  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
  
  }
}
