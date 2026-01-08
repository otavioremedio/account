package org.pismo.account.repository

import org.pismo.account.domain.OperationType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperationTypeRepository : JpaRepository<OperationType, Long>