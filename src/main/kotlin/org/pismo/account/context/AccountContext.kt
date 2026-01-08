package org.pismo.account.context

import org.pismo.account.domain.Account
import org.pismo.account.dto.AccountResponse

abstract class AccountContext<out T : AccountContext<T>> {
    abstract val account: Account?
    abstract val accountResponse: AccountResponse?
    abstract fun addAccount(account: Account): T
    abstract fun addAccountResponse(accountResponse: AccountResponse): T
}