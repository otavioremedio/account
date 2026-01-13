package org.pismo.transaction.service

import jakarta.persistence.EntityNotFoundException
import org.pismo.transaction.repository.OperationTypeRepository
import org.springframework.stereotype.Service

@Service
class OperationService(private val operationTypeRepository: OperationTypeRepository) {

    fun findById(id: Long): org.pismo.transaction.domain.OperationType = operationTypeRepository.findById(id)
        .orElseThrow { EntityNotFoundException("Operation Type $id is invalid") }

}