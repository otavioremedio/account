package org.pismo.account.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.pismo.account.domain.Account
import org.pismo.account.encode.MaskedSerializer

data class AccountRequest(
    @field:JsonProperty("document_number")
    val documentNumber: String
)

data class AccountResponse(
    @field:JsonProperty("account_id")
    val accountId: Long,
    @field:JsonProperty("document_number")
    val documentNumber: String
)

fun Account.toResponse() = AccountResponse(accountId = this.accountId!!, documentNumber = this.documentNumber)
