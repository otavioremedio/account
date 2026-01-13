package org.pismo.transaction.service

import org.pismo.transaction.domain.Transaction
import org.pismo.transaction.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(private val transactionRepository: TransactionRepository) {

    fun save(transaction: Transaction): Transaction = transactionRepository.save(transaction)

}