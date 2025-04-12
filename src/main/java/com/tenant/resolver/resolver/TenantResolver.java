package com.tenant.resolver.resolver;

import org.springframework.lang.NonNull;

@FunctionalInterface
public interface TenantResolver <T>{

    String resolveTenantId(@NonNull T t);
}
