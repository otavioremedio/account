package org.pismo.account.encode

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.pismo.commons.encode.MaskedSerializer

abstract class AccountLogMixin {
    @get:JsonSerialize(using = MaskedSerializer::class)
    abstract val documentNumber: String
}