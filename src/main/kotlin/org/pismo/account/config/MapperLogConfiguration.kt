package org.pismo.account.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.pismo.account.domain.Account
import org.pismo.account.dto.AccountRequest
import org.pismo.account.dto.AccountResponse
import org.pismo.account.encode.AccountLogMixin

object MapperLogConfiguration {
    val logMapper: ObjectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .addMixIn(AccountRequest::class.java, AccountLogMixin::class.java)
            .addMixIn(Account::class.java, AccountLogMixin::class.java)
            .addMixIn(AccountResponse::class.java, AccountLogMixin::class.java)
    }
}