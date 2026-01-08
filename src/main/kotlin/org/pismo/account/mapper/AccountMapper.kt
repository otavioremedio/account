package org.pismo.account.mapper

import org.pismo.account.domain.Account
import org.pismo.account.domain.Transaction
import org.pismo.account.dto.AccountRequest
import org.pismo.account.dto.AccountResponse
import org.pismo.account.dto.TransactionRequest
import org.pismo.account.enum.OperationType
import org.pismo.account.enum.TransactionType

object AccountMapper {

    fun toEntity(request: AccountRequest) = Account(documentNumber = request.documentNumber)

    fun toResponse(account: Account) = AccountResponse(account.accountId!!, account.documentNumber)
}