package com.askorykh.paystackspring.model;

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
public class CustomerDataResponse
{
    private String email;
    private String integration;
    private String domain;
    @JsonProperty("customer_code")
    private String customerCode;
    private Long id;
    private Boolean identified;
    private String identification;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime createdAt;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime updatedAt;
}
