package com.tenant.resolver.context;

public class TenantContext {

    private static final ThreadLocal<String> tenantId = new InheritableThreadLocal<>();


    public static void setTenantId(String tenant) {
        tenantId.set(tenant);
    }

    public static String getTenantId() {
        return tenantId.get();
    }

    public static void clear() {
        tenantId.remove();
    }
}
