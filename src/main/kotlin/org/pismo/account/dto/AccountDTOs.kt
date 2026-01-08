package org.pismo.account.dto

import com.fasterxml.jackson.annotation.JsonProperty

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