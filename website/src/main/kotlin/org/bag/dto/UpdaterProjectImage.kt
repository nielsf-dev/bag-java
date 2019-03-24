package org.bag.dto

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import java.io.IOException
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

// kennelijk als ik ze niet via de constructor doe gaat het fout met jackson?
class UpdaterProjectImage(
    var id: Int,
    var url: String,

    var isFrontend: Boolean,

    var isBanner: Boolean)

class NumericBooleanDeserializer : JsonDeserializer<Boolean>() {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(parser: JsonParser, context: DeserializationContext): Boolean? {
        return "0" != parser.getText()
    }
}