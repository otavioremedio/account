package org.pismo.transaction.integration

import org.pismo.commons.dto.AccountResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "account-client", url = "\${services.account.internal-url}")
interface AccountClient {

    @GetMapping("/accounts/{accountId}")
    fun getAccount(@PathVariable accountId: Long): AccountResponse
}
