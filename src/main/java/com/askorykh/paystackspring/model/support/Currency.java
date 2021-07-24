package com.askorykh.paystackspring.model.support;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * @author o.skorykh
 * @version 1.0
 */
public enum Currency
{
    NGN, GHS, ZAR, USD,
    @JsonEnumDefaultValue UNKNOWN
}
