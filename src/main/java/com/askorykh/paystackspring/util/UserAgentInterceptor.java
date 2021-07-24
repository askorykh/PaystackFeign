package com.askorykh.paystackspring.util;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author o.skorykh
 * @version 1.0
 */
public class UserAgentInterceptor implements RequestInterceptor
{
    private final String headerValue;


    public UserAgentInterceptor(String userAgent)
    {
        this.headerValue = userAgent;
    }


    public void apply(final RequestTemplate requestTemplate)
    {
        requestTemplate.header("User-Agent", headerValue);
    }
}
