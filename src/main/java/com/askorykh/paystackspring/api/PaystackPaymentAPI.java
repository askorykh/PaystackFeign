package com.askorykh.paystackspring.api;

import com.askorykh.paystackspring.model.CustomerCreationRequest;
import com.askorykh.paystackspring.model.CustomerCreationResponse;
import com.askorykh.paystackspring.model.PlanCreationRequest;
import com.askorykh.paystackspring.model.PlanCreationResponse;
import com.askorykh.paystackspring.model.transaction.InitializeTransactionRequest;
import com.askorykh.paystackspring.model.transaction.InitializeTransactionResponse;
import com.askorykh.paystackspring.model.transaction.VerifyTransactionResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/json")

public interface PaystackPaymentAPI
{
    /**
     * Initialize a transaction from your backend
     *
     * @param initializeTransactionRequest request
     * @return object InitializeTransactionResponse with authorization information about transaction
     * @see InitializeTransactionRequest
     * @see InitializeTransactionResponse
     */
    @RequestLine("POST /transaction/initialize")
    InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest);

    /**
     * Confirm the status of a transaction
     *
     * @param reference The transaction reference used to initiate the transaction
     * @return object VerifyTransactionResponse with Transaction information
     * @see VerifyTransactionResponse
     */
    @RequestLine("GET /transaction/verify/{reference}")
    VerifyTransactionResponse verifyTransaction(@Param("reference") String reference);

    /**
     * Create a plan on your integration
     *
     * @param planCreationRequest request
     * @return response
     * @see PlanCreationRequest
     * @see PlanCreationResponse
     */
    @RequestLine("POST /plan")
    PlanCreationResponse createSubscriptionPlan(PlanCreationRequest planCreationRequest);

    /**
     * Create a customer on your integration
     *
     * @param customerCreationRequest request
     * @return CustomerCreationResponse
     * @see CustomerCreationRequest
     * @see CustomerCreationResponse
     */
    @RequestLine("POST /customer")
    CustomerCreationResponse createCustomer(CustomerCreationRequest customerCreationRequest);

}
