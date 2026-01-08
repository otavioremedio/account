package org.pismo.account.facade

import org.pismo.account.context.TransactionCreateContext
import org.pismo.account.dto.TransactionRequest
import org.pismo.account.dto.TransactionResponse
import org.pismo.account.mapper.TransactionMapper
import org.pismo.account.service.AccountService
import org.pismo.account.service.OperationService
import org.pismo.account.service.TransactionService
import org.springframework.stereotype.Service

@Service
class TransactionCreateFacade(
    private val operationService: OperationService,
    private val accountService: AccountService,
    private val transactionService: TransactionService,
): BaseFacade() {
    fun createTransaction(request: TransactionRequest): TransactionResponse {
        return TransactionCreateContext(request)
            .execAndLog(::findAccount)
            .execAndLog(::findOperationType)
            .execAndLog(::createTransaction)
            .execAndLog(::saveTransaction)
            .execAndLog(::createResponse)
            .let { it.transactionResponse!! }
    }

    private fun findAccount(context: TransactionCreateContext) =
        accountService.findById(context.request.accountId)
            .let(context::addAccount)

    private fun findOperationType(context: TransactionCreateContext) =
        operationService.findById(context.request.operationTypeId)
            .let(context::addOperationType)

    private fun createTransaction(context: TransactionCreateContext) =
        TransactionMapper.toEntity(context.request, context.operationType!!)
            .let(context::addTransaction)

    private fun saveTransaction(context: TransactionCreateContext) =
        transactionService.save(context.transaction!!)
            .let(context::addTransaction)

    private fun createResponse(context: TransactionCreateContext) =
        TransactionMapper.toResponse(context.transaction!!)
            .let(context::addTransactionResponse)
}