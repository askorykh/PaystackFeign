package com.askorykh.paystackspring.model.support;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

/**
 * @author o.skorykh
 * @version 1.0
 */
public enum Channels
{
    card, bank, ussd, qr, mobile_money, bank_transfer,
    @JsonEnumDefaultValue unknown
}
