package com.gyb.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 登录校验，肯定是在前置拦截
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 顺序设置为1
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // 返回true，代表过滤器生效。
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 登录校验逻辑。
        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest request = ctx.getRequest();
        // 3) 从请求中获取ticket
        String s = request.getParameter("service-ticket");
        // 4) 判断（在这里推荐使用：StringUtils.isBlank(ticket)）
        if(StringUtils.isBlank(s)){
            // 没有ticket，登录校验失败，拦截
            ctx.setSendZuulResponse(false);
            // 返回403状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        }
        return null;
    }
}
