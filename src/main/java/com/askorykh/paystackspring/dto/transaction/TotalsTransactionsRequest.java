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
public class TotalsTransactionsRequest
{
    /**
     * Specify how many records you want to retrieve per page. If not specify we use a default value of 50.
     */
    private int perPage;
    /**
     * Specify exactly what page you want to retrieve. If not specify we use a default value of 1.
     */
    private int page;
    /**
     * A timestamp from which to start listing transaction e.g. 2016-09-24T00:00:05.000Z, 2016-09-21
     */
    public ZonedDateTime from;
    /**
     * A timestamp at which to stop listing transaction e.g. 2016-09-24T00:00:05.000Z, 2016-09-21
     */
    public ZonedDateTime to;
}
