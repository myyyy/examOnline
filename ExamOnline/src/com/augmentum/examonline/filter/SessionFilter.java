package com.augmentum.examonline.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.augmentum.examonline.Constants;
import com.augmentum.examonline.model.User;
import com.augmentum.examonline.until.PathUtil;
import com.augmentum.examonline.until.StringUtil;

public class SessionFilter implements Filter {
    private String notNeedLoginPages="";
    protected FilterConfig filterConfig;
    public SessionFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        String reqeusedUri = uri.substring(request.getContextPath().length() + 1);
        String [] pages = notNeedLoginPages.split(",");
        boolean isAllow = false;
        for (String page:pages) {
            if (page.equals(reqeusedUri)) {
                isAllow = true;
                break;
            }
            if (reqeusedUri.endsWith(".css") || reqeusedUri.endsWith(".png") || reqeusedUri.endsWith(".jpg") || reqeusedUri.endsWith(".js")) {
                isAllow = true;
                break;
            }
        }
        if (isAllow) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(Constants.USER);
            if(user == null) {
                if(request.getMethod().toLowerCase().equals("get")) {
                    String querystring = request.getQueryString();
                    String go = reqeusedUri;
                    if(! StringUtil.isEmpty(querystring)) {
                        go = go + "#" +request.getQueryString();
                    }
                    response.sendRedirect(PathUtil.getFullPath("user/login?go=" + go));
                } else {
                    response.sendRedirect(PathUtil.getFullPath("user/login"));
                }
            }else{
                filterChain.doFilter(request, response);
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
        this.filterConfig = fConfig;
        if (filterConfig.getInitParameter("notNeedLoginPages") != null){
            notNeedLoginPages = filterConfig.getInitParameter("notNeedLoginPages");
        }
    }

}
