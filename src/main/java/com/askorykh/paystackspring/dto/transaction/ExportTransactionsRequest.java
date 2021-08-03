package com.askorykh.paystackspring.dto.transaction;

import com.askorykh.paystackspring.model.support.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ExportTransactionsRequest
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
     * Specify an ID for the customer whose transactions you want to retrieve
     */
    private int customer;
    /**
     * Filter transactions by status ('failed', 'success', 'abandoned')
     */
    private String status;
    /**
     * A timestamp from which to start listing transaction e.g. 2016-09-24T00:00:05.000Z, 2016-09-21
     */
    private ZonedDateTime from;
    /**
     * A timestamp at which to stop listing transaction e.g. 2016-09-24T00:00:05.000Z, 2016-09-21
     */
    private ZonedDateTime to;
    /**
     * Filter transactions by amount.
     * Specify the amount (in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR)
     */
    private Long amount;

    /**
     * Specify the transaction currency to export.
     * Allowed values are: in kobo if currency is NGN, pesewas, if currency is GHS, and cents, if currency is ZAR
     */
    private Currency currency;

    /**
     * Set to true to export only settled transactions. false for pending transactions. Leave undefined to export all transactions
     */
    private boolean settled;

    /**
     * An ID for the settlement whose transactions we should export
     */
    private int settlement;

    /**
     * Specify a payment page's id to export only transactions conducted on said page
     */
    @JsonProperty("payment_page")
    private int paymentPage;
}
