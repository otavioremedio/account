package org.pismo.transaction.repository

import org.pismo.transaction.domain.OperationType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperationTypeRepository : JpaRepository<OperationType, Long>