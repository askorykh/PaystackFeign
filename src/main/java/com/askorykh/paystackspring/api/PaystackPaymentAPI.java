package com.askorykh.paystackspring.api;

import com.askorykh.paystackspring.model.CustomerCreationRequest;
import com.askorykh.paystackspring.model.CustomerCreationResponse;
import com.askorykh.paystackspring.model.PlanCreationRequest;
import com.askorykh.paystackspring.model.PlanCreationResponse;
import com.askorykh.paystackspring.model.transaction.InitializeTransactionRequest;
import com.askorykh.paystackspring.model.transaction.InitializeTransactionResponse;
import feign.Headers;
import feign.RequestLine;

@Headers("Content-Type: application/json")

public interface PaystackPaymentAPI
{
    /**
     * Initialize a transaction from your backend
     */
    @RequestLine("POST /transaction/initialize")
    InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest);

    @RequestLine("POST /plan")
    PlanCreationResponse createSubscriptionPlan(PlanCreationRequest planCreationRequest);

    /**
     * Create a customer on your integration
     */
    @RequestLine("POST /customer")
    CustomerCreationResponse createCustomer(CustomerCreationRequest customerCreationRequest);

}
