package com.askorykh.paystackspring.model;

import com.askorykh.paystackspring.model.support.Channel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
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
public class Log
{
    @JsonProperty("start_time")
    private Long startTime;
    @JsonProperty("time_spent")
    private Long timeSpent;
    private Long attempts;
    private Object authentication;
    private Long errors;
    private boolean success;
    private boolean mobile;
    private Channel channels;
    private ArrayList<Object> input;
    private ArrayList<History> history;

}
