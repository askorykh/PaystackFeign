package com.askorykh.paystackspring.dto.plan;

import com.askorykh.paystackspring.model.support.Currency;
import com.askorykh.paystackspring.model.support.Interval;
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
public class PlanDataResponse
{
    private String name;
    private Long amount;
    private Interval interval;
    private String integration;
    private String domain;
    @JsonProperty("plan_code")
    private String planCode;
    @JsonProperty("send_invoices")
    private Boolean sendInvoices;
    @JsonProperty("send_sms")
    private Boolean sendSms;
    @JsonProperty("hosted_page")
    private Boolean hostedPage;
    private Currency currency;
    private Long id;
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime createdAt;
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime updatedAt;
}

