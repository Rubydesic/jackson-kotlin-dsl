# Jackson Kotlin DSL

A project that makes constructing [Jackson](https://github.com/FasterXML/jackson-databind) 
objects using the tree API (`JsonNode`, `ObjectNode`, etc.) an absolute breeze.

*inspired by [Koson](https://github.com/lectra-tech/koson)*

## Install

Install from JitPack

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.Rubydesic:jackson-kotlin-dsl:1.2.0'
}
```

## Examples

### Construct a Basic Object / Array

Code:

```kotlin
val json: ObjectNode = obj {
    "test" to "a"
    "blah" to arr[1, 2]
}

println(json.toPrettyString())
```

Result:

```json
{
  "test" : "a",
  "blah" : [ 1, 2 ]
}
```

### Use any Java Object (POJO)

```kotlin
data class MyPojo(val ea: String)

val json: ObjectNode = obj {
    "test" to MyPojo("sports")
}

println(json.toPrettyString())
```


Result: 
```json
{
  "test" : {
    "ea" : "sports"
  }
}
```

### Use your own `JsonNodeFactory`

*This library uses `JsonNodeFactory.instance`by default*

```kotlin
val myNodeFactory: JsonNodeFactory = TODO()

val jsonObj: ObjectNode = myNodeFactory.obj { 
    "a" to "b"
}

val jsonArr: ArrayNode = myNodeFactory.arr[1, 2, 3, 4]

```
