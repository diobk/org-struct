package com.webapp.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority
{
    GEN_DIR,

    DIR,

    WORKER;

    @Override
    public String getAuthority()
    {
        return name();
    }
}