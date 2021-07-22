package com.askorykh.paystackspring.util;

import feign.RequestInterceptor;
import feign.RequestTemplate;
/**
 * @author o.skorykh
 * @version 1.0
 */
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
