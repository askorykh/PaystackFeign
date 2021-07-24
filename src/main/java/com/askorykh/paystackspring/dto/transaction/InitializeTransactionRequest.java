package com.askorykh.paystackspring.dto.transaction;

import com.askorykh.paystackspring.model.support.Channels;
import com.askorykh.paystackspring.model.support.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;
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
public class InitializeTransactionRequest
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
     * Optional - The transaction currency (NGN, GHS, ZAR or USD). Defaults to your integration currency.
     */
    private Currency currency;
    /**
     * Optional - Unique transaction reference. Only -, ., = and alphanumeric characters allowed.
     */
    private String reference;
    /**
     * Optional - Fully qualified url, e.g. https://example.com/ .
     * Use this to override the callback url provided on the dashboard for this transaction
     */
    @JsonProperty("callback_url")
    private String callbackUrl;

    /**
     * Optional - If transaction is to create a subscription to a predefined plan, provide plan code here.
     * This would invalidate the value provided in `amount`
     */
    private String plan;

    /**
     * Optional - Number of times to charge customer during subscription to plan
     */
    @JsonProperty("invoice_limit")
    private Long invoiceLimit;

    /**
     * Optional - Stringified JSON object of custom data. Kindly check the Metadata page for more information.
     */
    private Map<String, String> metadata;

    /**
     * Optional - An array of payment channels to control what channels you want
     * to make available to the user to make a payment with.
     * Available channels include: ['card', 'bank', 'ussd', 'qr', 'mobile_money', 'bank_transfer']
     */
    private ArrayList<Channels> channels;

    /**
     * Optional - The split code of the transaction split. e.g. SPL_98WF13Eb3w
     */
    private String split_code;

    /**
     * Optional - The code for the subaccount that owns the payment. e.g. ACCT_8f4s1eq7ml6rlzj
     */
    @JsonProperty("subaccount")
    private String subAccount;

    /**
     * Optional - A flat fee to charge the sub-account for this transaction ().
     * This overrides the split percentage set when the sub-account was created.
     * Ideally, you will need to use this if you are splitting in flat rates
     * (since sub-account creation only allows for percentage split). e.g. 7000 for a 70 naira flat fee.
     */
    @JsonProperty("transaction_charge")
    private Long transactionCharge;

    /**
     * Optional - Who bears Paystack charges? account or sub-account (defaults to account).
     */
    private String bearer;
}