package org.pismo.account.mapper

import org.pismo.account.domain.Account
import org.pismo.account.dto.AccountRequest
import org.pismo.account.dto.AccountResponse

object AccountMapper {

    fun toEntity(request: AccountRequest) = Account(documentNumber = request.documentNumber)
    fun toResponse(account: Account) = AccountResponse(account.accountId!!, account.documentNumber)
}