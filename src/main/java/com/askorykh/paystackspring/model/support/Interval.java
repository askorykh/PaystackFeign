package com.askorykh.paystackspring.model.support;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * @author o.skorykh
 * @version 1.0
 */
public enum Interval
{
    hourly, daily, weekly, monthly, biannually, annually,
    @JsonEnumDefaultValue unknown
}
