package com.example.Application;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    String val;
    public Role(String st){
        val = st;
    }
    @Override
    public String getAuthority() {
        return val;
    }
}
