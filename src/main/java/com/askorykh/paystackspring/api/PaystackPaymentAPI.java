package com.askorykh.paystackspring.api;

import feign.Headers;

/**
 * Interface to access all endpoints in Paystack API
 *
 * @author o.skorykh
 * @version 1.0
 */
@Headers("Content-Type: application/json")
public interface PaystackPaymentAPI extends TransactionApi, CustomerApi, PlanApi
{
}
