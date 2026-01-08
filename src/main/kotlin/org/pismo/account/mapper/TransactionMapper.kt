package org.pismo.account.mapper

import org.pismo.account.domain.Transaction
import org.pismo.account.dto.TransactionRequest
import org.pismo.account.enum.OperationType
import org.pismo.account.enum.TransactionType

object TransactionMapper {

    fun toEntity(dto: TransactionRequest): Transaction {
        val operation = OperationType.fromId(dto.operationTypeId)

        val finalAmount = when(operation.type) {
            TransactionType.DEBIT -> dto.amount.abs().negate()
            else -> dto.amount.abs()
        }

        return Transaction(
            accountId = dto.accountId,
            operationTypeId = operation.id,
            amount = finalAmount
        )
    }
}