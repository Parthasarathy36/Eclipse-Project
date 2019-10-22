package com.hcl;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
 

public class SpringFilterConfig extends AbstractSecurityWebApplicationInitializer {
 
    public SpringFilterConfig() {
        super(FilterSecurityImplementation.class);
    }
 
}