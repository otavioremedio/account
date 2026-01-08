package org.pismo.account.facade

import org.pismo.account.context.AccountCreateContext
import org.pismo.account.dto.AccountRequest
import org.pismo.account.mapper.AccountMapper
import org.pismo.account.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountCreateFacade(
    private val accountService: AccountService,
): BaseFacade() {

    fun createAccount(request: AccountRequest): AccountCreateContext {
        return AccountCreateContext(request)
            .execAndLog(::createAccount)
            .execAndLog(::saveAccount)
            .execAndLog(::createResponse)
    }

    private fun createAccount(context: AccountCreateContext) =
        AccountMapper.toEntity(context.request)
            .let(context::addAccount)

    private fun saveAccount(context: AccountCreateContext) =
        accountService.save(context.account!!)
            .let(context::addAccount)

    private fun createResponse(context: AccountCreateContext) =
        AccountMapper.toResponse(context.account!!)
            .let(context::addAccountResponse)
}