package com.askorykh.paystackspring.model;

import com.askorykh.paystackspring.model.support.Currency;
import com.askorykh.paystackspring.model.support.Interval;
import com.askorykh.paystackspring.util.CustomDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime createdAt;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime updatedAt;
}

