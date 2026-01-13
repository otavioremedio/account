package org.pismo.transaction.exception

import jakarta.persistence.EntityNotFoundException

class AccountNotFoundException(message: String): EntityNotFoundException(message)

