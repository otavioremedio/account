package org.pismo.account.exception

data class ErrorResponse(
    val status: Int,
    val message: String,
    val timestamp: Long = System.currentTimeMillis()
)
