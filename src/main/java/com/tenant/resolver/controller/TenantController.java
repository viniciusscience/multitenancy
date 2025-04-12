package com.tenant.resolver.controller;

import com.tenant.resolver.context.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tenant")
@RestController
public class TenantController {

    @GetMapping
    String getTenant(){
        return TenantContext.getTenantId();
    }
}
