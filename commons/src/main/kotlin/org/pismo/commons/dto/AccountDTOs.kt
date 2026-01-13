package org.pismo.commons.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountResponse(
    @field:JsonProperty("account_id")
    val accountId: Long,
    @field:JsonProperty("document_number")
    val documentNumber: String
)