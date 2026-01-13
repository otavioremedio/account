package org.pismo.account.repository

import java.util.Optional
import org.pismo.account.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByDocumentNumber(documentNumber: String): Optional<Account>
}