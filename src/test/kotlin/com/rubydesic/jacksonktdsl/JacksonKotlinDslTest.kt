package com.rubydesic.jacksonktdsl

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class JacksonKotlinDslTest : StringSpec({

    "creates basic object" {

        val json = obj {
            "test" to "a"
            "blah" to arr[1, 2]
        }

        json.toString() shouldBe """{"test":"a","blah":[1,2]}"""

        println(json.toPrettyString())
    }

    "creates object with pojo" {
        data class MyPojo(val ea: String)

        val json = obj {
            "test" to MyPojo("sports")
        }

        json.toString() shouldBe """{"test":{"ea":"sports"}}"""

        println(json.toPrettyString())
    }

    "creates an object with null" {
        val json = obj {
            "test" to null
        }

        json.toString() shouldBe """{"test":null}"""
    }
})