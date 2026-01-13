package org.pismo.transaction.facade

import org.pismo.account.service.AccountService
import org.pismo.commons.facade.BaseFacade
import org.pismo.transaction.dto.TransactionRequest
import org.pismo.transaction.dto.TransactionResponse
import org.pismo.transaction.mapper.TransactionMapper
import org.springframework.stereotype.Service

@Service
class TransactionCreateFacade(
    private val operationService: org.pismo.transaction.service.OperationService,
    private val accountService: AccountService,
    private val transactionService: org.pismo.transaction.service.TransactionService,
): BaseFacade() {
    fun createTransaction(request: TransactionRequest): TransactionResponse {
        return _root_ide_package_.org.pismo.transaction.context.TransactionCreateContext(request)
            .execAndLog(::findAccount)
            .execAndLog(::findOperationType)
            .execAndLog(::createTransaction)
            .execAndLog(::saveTransaction)
            .execAndLog(::createResponse)
            .let { it.transactionResponse!! }
    }

    private fun findAccount(context: _root_ide_package_.org.pismo.transaction.context.TransactionCreateContext) =
        accountService.findById(context.request.accountId)
            .let(context::addAccount)

    private fun findOperationType(context: _root_ide_package_.org.pismo.transaction.context.TransactionCreateContext) =
        operationService.findById(context.request.operationTypeId)
            .let(context::addOperationType)

    private fun createTransaction(context: _root_ide_package_.org.pismo.transaction.context.TransactionCreateContext) =
        TransactionMapper.toEntity(context.request, context.operationType!!)
            .let(context::addTransaction)

    private fun saveTransaction(context: _root_ide_package_.org.pismo.transaction.context.TransactionCreateContext) =
        transactionService.save(context.transaction!!)
            .let(context::addTransaction)

    private fun createResponse(context: _root_ide_package_.org.pismo.transaction.context.TransactionCreateContext) =
        TransactionMapper.toResponse(context.transaction!!)
            .let(context::addTransactionResponse)
}