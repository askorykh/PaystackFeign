package com.askorykh.paystackspring.api;

import com.askorykh.paystackspring.dto.transaction.ExportTransactionsRequest;
import com.askorykh.paystackspring.dto.transaction.ExportTransactionsResponse;
import com.askorykh.paystackspring.dto.transaction.FetchTransactionResponse;
import com.askorykh.paystackspring.dto.transaction.InitializeTransactionRequest;
import com.askorykh.paystackspring.dto.transaction.InitializeTransactionResponse;
import com.askorykh.paystackspring.dto.transaction.ListTransactionsRequest;
import com.askorykh.paystackspring.dto.transaction.ListTransactionsResponse;
import com.askorykh.paystackspring.dto.transaction.PartialDebitRequest;
import com.askorykh.paystackspring.dto.transaction.PartialDebitResponse;
import com.askorykh.paystackspring.dto.transaction.TotalsTransactionsRequest;
import com.askorykh.paystackspring.dto.transaction.TotalsTransactionsResponse;
import com.askorykh.paystackspring.dto.transaction.TransactionTimelineResponse;
import com.askorykh.paystackspring.dto.transaction.VerifyTransactionResponse;
import com.askorykh.paystackspring.dto.transaction.authorization.ChargeAuthorizationRequest;
import com.askorykh.paystackspring.dto.transaction.authorization.ChargeAuthorizationResponse;
import com.askorykh.paystackspring.dto.transaction.authorization.CheckAuthorizationRequest;
import com.askorykh.paystackspring.dto.transaction.authorization.CheckAuthorizationResponse;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

/**
 * The Transactions API allows you create and manage payments on your integration
 *
 * @author o.skorykh
 * @version 1.0
 */
@Headers("Content-Type: application/json")
interface TransactionApi
{
    /**
     * Initialize a transaction from your backend
     *
     * @param initializeTransactionRequest request
     * @return InitializeTransactionResponse with authorization information about transaction
     * @see InitializeTransactionRequest
     * @see InitializeTransactionResponse
     */
    @RequestLine("POST /transaction/initialize")
    InitializeTransactionResponse initializeTransaction(InitializeTransactionRequest initializeTransactionRequest);

    /**
     * Confirm the status of a transaction
     *
     * @param reference The transaction reference used to initiate the transaction
     * @return VerifyTransactionResponse with Transaction information
     * @see VerifyTransactionResponse
     */
    @RequestLine("GET /transaction/verify/{reference}")
    VerifyTransactionResponse verifyTransaction(@Param("reference") String reference);

    /**
     * List transactions carried out on your integration.
     *
     * @param request request
     * @return ListTransactionsResponse with list of transactions
     * @see ListTransactionsResponse
     * @see ListTransactionsRequest
     */
    @RequestLine("GET /transaction")
    ListTransactionsResponse getTransactionsList(@QueryMap ListTransactionsRequest request);

    /**
     * Get details of a transaction carried out on your integration.
     *
     * @param id An ID for the transaction to fetch
     * @return FetchTransactionResponse with Transaction information
     * @see FetchTransactionResponse
     */
    @RequestLine("GET /transaction/{id}")
    FetchTransactionResponse fetchTransaction(@Param("id") String id);

    /**
     * All authorizations marked as reusable can be charged with this endpoint whenever you need to receive payments.
     *
     * @param chargeAuthorizationRequest ChargeAuthorizationRequest
     * @return ChargeAuthorizationResponse
     * @see ChargeAuthorizationResponse
     * @see ChargeAuthorizationRequest
     */
    @RequestLine("POST /transaction/charge_authorization")
    ChargeAuthorizationResponse chargeAuthorization(ChargeAuthorizationRequest chargeAuthorizationRequest);

    /**
     * All mastercard and visa authorizations can be checked with this endpoint to know if they have funds for the payment you seek.
     * <p>
     * This endpoint should be used when you do not know the exact amount to charge a card when rendering a service. It should be used to check if a card has enough funds based on a maximum range value. It is well suited for:
     * <p>
     * - Ride hailing services
     * - Logistics services
     * <p>
     * !!!
     * Warning
     * You shouldn't use this endpoint to check a card for sufficient funds if you are going to charge the user immediately.
     * This is because we hold funds when this endpoint is called which can lead to an insufficient funds error.
     * !!!
     *
     * @param planCreationRequest request
     * @return CheckAuthorizationResponse
     * @see CheckAuthorizationRequest
     * @see CheckAuthorizationResponse
     */
    @RequestLine("POST /transaction/check_authorization")
    CheckAuthorizationResponse checkAuthorization(CheckAuthorizationRequest planCreationRequest);

    /**
     * Get details of a transaction carried out on your integration.
     *
     * @param idOrReference The ID or the reference of the transaction
     * @return TransactionTimelineResponse with the timeline of a transaction
     * @see TransactionTimelineResponse
     */
    @RequestLine("GET /transaction/timeline/{idOrReference}")
    TransactionTimelineResponse viewTimelineOfTransaction(@Param("idOrReference") String idOrReference);

    /**
     * Total amount received on your account
     *
     * @param request TotalsTransactionsRequest
     * @return TotalsTransactionsResponse
     * @see TotalsTransactionsResponse
     * @see TotalsTransactionsRequest
     */
    @RequestLine("GET /transaction/totals")
    TotalsTransactionsResponse getTotalsTransactions(@QueryMap TotalsTransactionsRequest request);

    /**
     * Export a List of transactions carried out on your integration as csv
     *
     * @param request ExportTransactionsRequest
     * @return ExportTransactionsResponse  with path to csv
     * @see ExportTransactionsResponse
     * @see ExportTransactionsRequest
     */
    @RequestLine("GET /transaction/export")
    ExportTransactionsResponse exportTransactions(@QueryMap ExportTransactionsRequest request);

    /**
     * Retrieve part of a payment from a customer
     *
     * @param partialDebitRequest PartialDebitRequest
     * @return PartialDebitResponse
     * @see PartialDebitResponse
     * @see PartialDebitRequest
     */
    @RequestLine("POST /transaction/partial_debit")
    PartialDebitResponse doPartialDebit(PartialDebitRequest partialDebitRequest);
}
