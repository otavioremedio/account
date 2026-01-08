package org.pismo.account.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import org.pismo.account.domain.Transaction

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

fun Transaction.toResponse() = TransactionResponse(
    transactionId = this.transactionId!!,
    accountId = this.accountId,
    operationTypeId = this.operationTypeId,
    amount = this.amount
)
