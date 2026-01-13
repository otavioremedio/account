package org.pismo.transaction.org.pismo.transaction.service

import org.pismo.transaction.exception.AccountNotFoundException
import org.pismo.transaction.integration.AccountClient
import org.springframework.stereotype.Service

@Service
class IntegrationService(private val accountClient: AccountClient) {

    fun getAccount(accountId: Long) =
        runCatching { accountClient.getAccount(accountId) }
            .getOrElse { throw AccountNotFoundException("Account $accountId not found") }

}