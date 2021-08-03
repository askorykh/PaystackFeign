package com.askorykh.paystackspring.dto.transaction;

import com.askorykh.paystackspring.model.Authorization;
import com.askorykh.paystackspring.model.Customer;
import com.askorykh.paystackspring.model.Metadata;
import com.askorykh.paystackspring.model.PaginationMeta;
import com.askorykh.paystackspring.model.support.Channels;
import com.askorykh.paystackspring.model.support.Currency;
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
import lombok.ToString;

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
@ToString
public class Transaction
{
    private int id;
    private String domain;
    private String status;
    private String reference;
    private Long amount;
    private String message;
    @JsonProperty("gateway_response")
    private String gatewayResponse;
    @JsonProperty("paid_at")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime paidAt;
    @JsonProperty("created_at")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime createdAt;
    private Channels channel;
    private Currency currency;
    @JsonProperty("ip_address")
    private String ipAddress;
    private Metadata metadata;
    private String timeline;
    private Customer customer;
    private Authorization authorization;
    private Object plan;
    @JsonProperty("requested_amount")
    private Long requestedAmount;
    private PaginationMeta meta;

}
