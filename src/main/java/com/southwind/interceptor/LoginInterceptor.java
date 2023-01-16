package com.southwind.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        // 登入注册界面放行
        if (url.contains("/login") || url.contains("/signIn") || url.contains("/signUp") || url.contains("/addUser"))
            return true;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        Object reader = session.getAttribute("reader");
        if (user != null || reader != null)
            return true;

        request.setAttribute("msg", "您还没有登入，请先登入");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
