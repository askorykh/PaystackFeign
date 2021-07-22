package com.askorykh.paystackspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The first_name, last_name and phone are optional parameters.
 * However, when creating a customer that would be assigned a Dedicated NUBAN and
 * your business category falls under Betting, Financial services, and General Service,
 * then these parameters become compulsory.
 *
 * @author o.skorykh
 * @version 1.0
 */
@Getter
@Setter
@Builder
public class CustomerCreationRequest
{
    /**
     * Customer's email address
     */
    private String email;
    /**
     * Customer's first name
     */
    @JsonProperty("first_name")
    private String firstName;
    /**
     * Customer's last name
     */
    @JsonProperty("last_name")
    private String lastName;
    /**
     * Customer's phone number
     */
    private String phone;

    /**
     * A set of key/value pairs that you can attach to the customer.
     * It can be used to store additional information in a structured format.
     */
    private Map<String, String> metadata;
}
