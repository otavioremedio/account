package org.pismo.account.controller

import jakarta.validation.Valid
import org.pismo.account.dto.TransactionRequest
import org.pismo.account.dto.TransactionResponse
import org.pismo.account.facade.TransactionFacade
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transactions")
class TransactionController(private val facade: TransactionFacade) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: TransactionRequest): TransactionResponse = facade.createTransaction(request)
}