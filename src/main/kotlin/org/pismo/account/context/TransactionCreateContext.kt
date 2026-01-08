package org.pismo.account.context

import org.pismo.account.domain.Account
import org.pismo.account.domain.OperationType
import org.pismo.account.domain.Transaction
import org.pismo.account.dto.TransactionRequest
import org.pismo.account.dto.TransactionResponse

data class TransactionCreateContext(
    val request: TransactionRequest,
    val account: Account? = null,
    val operationType: OperationType? = null,
    val transaction: Transaction? = null,
    val transactionResponse: TransactionResponse? = null
): TransactionContext<TransactionCreateContext>() {
    fun addAccount(account: Account) = copy(account = account)
    fun addOperationType(operationType: OperationType) = copy(operationType = operationType)
    fun addTransaction(transaction: Transaction) = copy(transaction = transaction)
    fun addTransactionResponse(transactionResponse: TransactionResponse) = copy(transactionResponse = transactionResponse)
}