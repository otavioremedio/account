package org.pismo.account.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class TransactionRequest(
    @field:JsonProperty("account_id")
    val accountId: Long,
    @field:JsonProperty("operation_type_id")
    val operationTypeId: Long,
    val amount: BigDecimal
)

data class TransactionResponse(
    @field:JsonProperty("transaction_id")
    val transactionId: Long,
    @field:JsonProperty("account_id")
    val accountId: Long,
    @field:JsonProperty("operation_type_id")
    val operationTypeId: Long,
    val amount: BigDecimal
)
