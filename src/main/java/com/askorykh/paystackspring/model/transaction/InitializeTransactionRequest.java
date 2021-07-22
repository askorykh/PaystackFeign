package com.askorykh.paystackspring.model.transaction;

import com.askorykh.paystackspring.model.support.Channels;
import com.askorykh.paystackspring.model.support.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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

    private String split_code;

    private String subaccount;

    @JsonProperty("transaction_charge")
    private Long transactionCharge;
}

//    plan
//    string
//    If transaction is to create a subscription to a predefined plan, provide plan code here. This would invalidate the value provided in amount
//    invoice_limit
//    integer
//    Number of times to charge customer during subscription to plan
//    metadata
//    string
//    Stringified JSON object of custom data. Kindly check the Metadata page for more information.
//    channels
//    array
//    An array of payment channels to control what channels you want to make available to the user to make a payment with. Available channels include: ['card', 'bank', 'ussd', 'qr', 'mobile_money', 'bank_transfer']
//    split_code
//    string
//    The split code of the transaction split. e.g. SPL_98WF13Eb3w
//    subaccount
//    string
//    The code for the subaccount that owns the payment. e.g. ACCT_8f4s1eq7ml6rlzj
//    transaction_charge
//    integer
//    A flat fee to charge the subaccount for this transaction (). This overrides the split percentage set when the subaccount was created. Ideally, you will need to use this if you are splitting in flat rates (since subaccount creation only allows for percentage split). e.g. 7000 for a 70 naira flat fee.
//    bearer
//    string
//    Who bears Paystack charges? account or subaccount (defaults to account).