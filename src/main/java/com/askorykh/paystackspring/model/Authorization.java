package com.askorykh.paystackspring.model;

import com.askorykh.paystackspring.model.support.Channels;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Authorization
{
    @JsonProperty("authorization_code")
    private String authorizationCode;
    @JsonProperty("card_type")
    private String cardType;
    private String last4;
    @JsonProperty("exp_month")
    private String expMonth;
    @JsonProperty("exp_year")
    private String expYear;
    private String bin;
    private String bank;
    private Channels channel;
    private String signature;
    private boolean reusable;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("account_name")
    private String accountName;

}