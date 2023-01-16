package com.southwind.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截读者访问管理员页面
 */
public class ReaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object reader = request.getSession().getAttribute("reader");
        String uri = request.getRequestURI();
//        if (reader != null) {
//            if (uri.contains("/book")) {
//                request.setAttribute("error_msg", "普通账号没有该权限");
//                request.getRequestDispatcher("/reader/allBookReader").forward(request, response);
//                return false;
//            }
//        }
//
        return true;
    }
}

