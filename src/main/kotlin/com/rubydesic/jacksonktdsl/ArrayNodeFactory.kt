package com.rubydesic.jacksonktdsl

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode

interface ArrayNodeFactory {
    operator fun get(vararg elements: Any): ArrayNode
    operator fun get(elements: List<JsonNode>): ArrayNode
    operator fun get(vararg elements: JsonNode): ArrayNode = get(elements.asList())
    operator fun get(elements: Iterable<JsonNode>): ArrayNode = get(elements.toList())
}