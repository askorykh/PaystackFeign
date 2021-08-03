package com.askorykh.paystackspring.dto.transaction.authorization;

import com.askorykh.paystackspring.model.Metadata;
import com.askorykh.paystackspring.model.support.Channel;
import com.askorykh.paystackspring.model.support.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class ChargeAuthorizationRequest
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
     * Optional - Unique transaction reference. Only -, ., = and alphanumeric characters allowed.
     */
    private String reference;
    /**
     * Optional - Currency in which amount should be charged. Allowed values are: NGN, GHS, ZAR or USD
     */
    private Currency currency;
    /**
     * Stringified JSON object.
     * Add a custom_fields attribute which has an array of objects
     * if you would like the fields to be added to your transaction when displayed on the dashboard.
     * Sample: {"custom_fields":[{"display_name":"Cart ID","variable_name": "cart_id","value": "8393"}]}
     */
    private Metadata metadata;
    /**
     * Send us 'card' or 'bank' or 'card','bank' as an array to specify what options to show the user paying
     */
    private List<Channel> channels;
    /**
     * The code for the subaccount that owns the payment. e.g. ACCT_8f4s1eq7ml6rlzj
     */
    private String subaccount;
    /**
     * A flat fee to charge the subaccount for this transaction
     * (in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR).
     * This overrides the split percentage set when the subaccount was created.
     * Ideally, you will need to use this if you are splitting in flat rates
     * (since subaccount creation only allows for percentage split). e.g. 7000 for a 70 naira
     */
    @JsonProperty("transaction_charge")
    private Long transactionCharge;
    /**
     * Who bears Paystack charges? account or subaccount (defaults to account).
     */
    private String bearer;
    /**
     * If you are making a scheduled charge call, it is a good idea to queue them
     * so the processing system does not get overloaded causing transaction processing errors.
     * Send queue:true to take advantage of our queued charging.
     */
    private boolean queue;
}

