package org.pismo.account.facade

import org.pismo.account.dto.TransactionRequest
import org.pismo.account.dto.TransactionResponse
import org.pismo.account.dto.toResponse
import org.pismo.account.enum.OperationType
import org.pismo.account.mapper.TransactionMapper
import org.pismo.account.service.AccountService
import org.pismo.account.service.TransactionService
import org.springframework.stereotype.Service

@Service
class TransactionFacade(
    private val transactionService: TransactionService,
    private val accountService: AccountService
): BaseFacade() {
    fun createTransaction(dto: TransactionRequest): TransactionResponse {
        accountService.findById(dto.accountId)
        OperationType.fromId(dto.operationTypeId)

        val entity = TransactionMapper.toEntity(dto)
        return transactionService.save(entity).toResponse()
    }
}