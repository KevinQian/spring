package com.kevin.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by kevin on 16/11/18.
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    public final static String REQUEST_URI = "requestURI";
    public final static String REQUEST_METHOD = "requestMethod";
    public final static String SESSION_ID = "sessionId";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("LogInterceptor preHandle method invoked. path {}",request.getRequestURI());
        MDC.put(REQUEST_URI, request.getRequestURI());
        MDC.put(REQUEST_METHOD, request.getMethod());
        HttpSession session = request.getSession(false);
        if(session != null) {
            MDC.put(SESSION_ID, session.getId());
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(REQUEST_URI);
        MDC.remove(REQUEST_METHOD);
        MDC.remove(SESSION_ID);
    }
}
