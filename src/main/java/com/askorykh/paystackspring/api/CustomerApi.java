package com.askorykh.paystackspring.api;

import com.askorykh.paystackspring.dto.customer.CustomerCreationRequest;
import com.askorykh.paystackspring.dto.customer.CustomerCreationResponse;
import feign.Headers;
import feign.RequestLine;

/**
 * The Customers API allows you create and manage customers on your integration.
 *
 * @author o.skorykh
 * @version 1.0
 */
@Headers("Content-Type: application/json")
public interface CustomerApi
{
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
