package com.askorykh.paystackspring.model;

import com.askorykh.paystackspring.model.support.Currency;
import com.askorykh.paystackspring.model.support.Interval;
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
public class PlanCreationRequest
{
    /**
     * Name of plan
     */
    private String name;
    /**
     * Amount should be in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR
     */
    private Long amount;
    /**
     * Interval in words. Valid intervals are: daily, weekly, monthly,biannually, annually.
     */
    private Interval interval;
    /**
     * Optional - A description for this plan
     */
    private String description;
    /**
     * Optional - Currency in which amount is set. Allowed values are NGN, GHS, ZAR or USD
     */
    private Currency currency;
    /**
     * Optional - Set to false if you don't want invoices to be sent to your customers
     */
    @JsonProperty("send_invoices")
    private Boolean sendInvoices;
    /**
     * Optional - Set to false if you don't want text messages to be sent to your customers
     */
    @JsonProperty("send_sms")
    private Boolean sendSms;
    /**
     * Optional - Number of invoices to raise during subscription to this plan.
     * Can be overridden by specifying an invoice_limit while subscribing.
     */
    @JsonProperty("invoice_limit")
    private Long invoiceLimit;
}

