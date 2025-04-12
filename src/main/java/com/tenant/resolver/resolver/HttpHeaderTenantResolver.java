package com.tenant.resolver.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class HttpHeaderTenantResolver implements TenantResolver<HttpServletRequest> {


    @Override
    public String resolveTenantId(HttpServletRequest request) {
        return request.getHeader("X-TenantId");
    }
}
