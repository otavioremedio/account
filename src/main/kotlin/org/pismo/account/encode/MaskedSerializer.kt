package org.pismo.account.encode

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class MaskedSerializer : JsonSerializer<String>() {
    override fun serialize(value: String, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeString("${value.take(4)}${"*".repeat(value.length - 4)}")
    }
}
