package com.askorykh.paystackspring.dto.transaction;

import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author o.skorykh
 * @version 1.0
 */
@Getter
@Setter
@Builder
public class ListTransactionsRequest
{
    /**
     * Specify how many records you want to retrieve per page. If not specify we use a default value of 50.
     */
    public int perPage;
    /**
     * Specify exactly what page you want to retrieve. If not specify we use a default value of 1.
     */
    public int page;
    /**
     * Specify an ID for the customer whose transactions you want to retrieve
     */
    public int customer;
    /**
     * Filter transactions by status ('failed', 'success', 'abandoned')
     */
    public String status;
    /**
     * A timestamp from which to start listing transaction e.g. 2016-09-24T00:00:05.000Z, 2016-09-21
     */
    public ZonedDateTime from;
    /**
     * A timestamp at which to stop listing transaction e.g. 2016-09-24T00:00:05.000Z, 2016-09-21
     */
    public ZonedDateTime to;
    /**
     * Filter transactions by amount.
     * Specify the amount (in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR)
     */
    public Long amount;
}
