package com.askorykh.paystackspring.dto.transaction;

import com.askorykh.paystackspring.model.Authorization;
import com.askorykh.paystackspring.model.Customer;
import com.askorykh.paystackspring.model.Log;
import com.askorykh.paystackspring.model.support.Channels;
import com.askorykh.paystackspring.util.ZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author o.skorykh
 * @version 1.0
 */
@Getter
@Setter
@Builder
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifyTransactionDataResponse
{
    private Long amount;
    @JsonProperty("transaction_date")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime transactionDate;
    private String status;
    private String reference;
    private String domain;
    private Long metadata;
    @JsonProperty("gateway_response")
    private String gatewayResponse;
    private String message;
    private Channels channel;
    @JsonProperty("ip_address")
    private String ipAddress;
    private Log log;
    private Object fees;
    private Authorization authorization;
    private Customer customer;
    private String plan;
    @JsonProperty("requested_amount")
    private Long requestedAmount;
}
