package com.askorykh.paystackspring.api;

import com.askorykh.paystackspring.dto.plan.PlanCreationRequest;
import com.askorykh.paystackspring.dto.plan.PlanCreationResponse;
import feign.Headers;
import feign.RequestLine;

/**
 * The Plans API allows you create and manage installment payment options on your integration
 *
 * @author o.skorykh
 * @version 1.0
 */
@Headers("Content-Type: application/json")
public interface PlanApi
{

    /**
     * Create a plan on your integration
     *
     * @param planCreationRequest request
     * @return PlanCreationResponse
     * @see PlanCreationRequest
     * @see PlanCreationResponse
     */
    @RequestLine("POST /plan")
    PlanCreationResponse createSubscriptionPlan(PlanCreationRequest planCreationRequest);
}
