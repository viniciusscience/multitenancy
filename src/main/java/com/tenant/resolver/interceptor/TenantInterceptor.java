package com.tenant.resolver.interceptor;

import com.tenant.resolver.resolver.HttpHeaderTenantResolver;
import com.tenant.resolver.context.TenantContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    private final HttpHeaderTenantResolver headerTenantResolver;

    public TenantInterceptor(HttpHeaderTenantResolver headerTenantResolver) {
        this.headerTenantResolver = headerTenantResolver;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var tenantId = headerTenantResolver.resolveTenantId(request);
        TenantContext.setTenantId(tenantId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        clear();
    }

    private void clear(){
        TenantContext.clear();
    }
}
