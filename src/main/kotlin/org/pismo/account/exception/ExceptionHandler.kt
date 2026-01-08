package org.pismo.account.exception

import jakarta.persistence.EntityNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail.forStatusAndDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrity(): ResponseEntity<Any> {
        val problemDetail = forStatusAndDetail(
            HttpStatus.CONFLICT,
            "Already have a account with that document."
        )
        problemDetail.title = "Create conflict"
        return ResponseEntity.of(problemDetail).build()
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex: EntityNotFoundException): ResponseEntity<Any> {
        val problemDetail = forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            ex.message ?: ex.localizedMessage
        )
        problemDetail.title = "Not Found"
        return ResponseEntity.of(problemDetail).build()
    }

}