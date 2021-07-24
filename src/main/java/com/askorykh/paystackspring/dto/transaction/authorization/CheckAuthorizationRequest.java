package com.askorykh.paystackspring.dto.transaction.authorization;

import com.askorykh.paystackspring.model.support.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author o.skorykh
 * @version 1.0
 */
@Getter
@Setter
@Builder
public class CheckAuthorizationRequest
{
    /**
     * Amount should be in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR
     */
    private String amount;

    /**
     * Customer's email address
     */
    private String email;

    /**
     * Valid authorization code to charge
     */
    @JsonProperty("authorization_code")
    private String authorizationCode;

    /**
     * Optional - Currency in which amount should be charged. Allowed values are: NGN, GHS, ZAR or USD
     */
    private Currency currency;
}
