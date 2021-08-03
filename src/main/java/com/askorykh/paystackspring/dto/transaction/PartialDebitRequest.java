package com.askorykh.paystackspring.dto.transaction;

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
public class PartialDebitRequest
{
    /**
     * Valid authorization code
     */
    @JsonProperty("authorization_code")
    private String authorization_code;
    /**
     * Specify the currency you want to debit. Allowed values are NGN, GHS, ZAR or USD.
     */
    private Currency currency;
    /**
     * Amount should be in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR
     */
    private String amount;
    /**
     * Customer's email address (attached to the authorization code)
     */
    private String email;
    /**
     * Optional - Unique transaction reference. Only -, ., = and alphanumeric characters allowed.
     */
    private String reference;
    /**
     * Minimum amount to charge
     */
    @JsonProperty("at_least")
    private String atLeast;
}
