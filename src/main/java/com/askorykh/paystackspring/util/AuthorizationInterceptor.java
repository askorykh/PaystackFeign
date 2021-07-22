package com.askorykh.paystackspring.util;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthorizationInterceptor implements RequestInterceptor
{
    private final String headerValue;


    public AuthorizationInterceptor(String token)
    {
        this.headerValue = "Bearer " + token;
    }


    public void apply(final RequestTemplate requestTemplate)
    {
        requestTemplate.header("Authorization", headerValue);
    }
}
