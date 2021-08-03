package com.askorykh.paystackspring.dto.transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class TotalsTransactionsDataResponse
{
    @JsonProperty("total_transactions")
    private int totalTransactions;
    @JsonProperty("unique_customers")
    private int uniqueCustomers;
    @JsonProperty("total_volume")
    private Long totalVolume;
    @JsonProperty("total_volume_by_currency")
    private List<CurrencyWithAmount> totalVolumeByCurrency;
    @JsonProperty("pending_transfers")
    private Long pendingTransfers;
    @JsonProperty("pending_transfers_by_currency")
    private List<CurrencyWithAmount> pendingTransfersByCurrency;

}

@Getter
@Setter
@Builder
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
class CurrencyWithAmount
{
    private String currency;
    private int amount;
}
