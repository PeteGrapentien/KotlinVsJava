package com.kotlinexamples.pete.kotlinexamples

import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.*

class ExampleUnitTest {

    /*
    NOTES:

    Using org.assertj.core.api.Assertions.assertThat by including
    testImplementation "org.assertj:assertj-core:3.5.2" into the build.gradle file

    */


    /* ~~~ Variables ~~ */

    @Test
    fun `variable example`() {
        var mutableVariable:String = "I will change for you"
        val immutableVariable:String = "Stop trying to change me"
        var optionalVariable:String? = "You have options"

        mutableVariable = "I changed"
        //immutableVariable = "Compiler error"
        optionalVariable = null

        assertThat(mutableVariable).isEqualTo("I changed")
        assertNull(optionalVariable)
    }


    /* ~~~~ FUNCTIONS ~~~~ */

    //Something Cool That You've probably noticed: Functions can be sentences when you use the
    // backtick escape character.
    // Not super useful for the functional code of the app, but kind of cool for tests

    /*
        >>> Named Parameters <<<

    You can name parameters, so that the order they're entered doesn't matter.
    Maybe this could be an interesting alternative to the builder pattern?
    You cannot do this in Java.
    */

    fun namedParameters(first: String, second: String): String {
        return first + second
    }

    @Test
    fun `function example`() {
        val result: String = namedParameters("A", "B")
        assertThat(result).isEqualTo("AB")

        val sameResult1: String = namedParameters(first = "A", second = "B")
        assertThat(sameResult1).isEqualTo("AB")

        val sameResult2: String = namedParameters(second = "B", first = "A")
        assertThat(sameResult2).isEqualTo("AB")
    }


    /*
        >>> Nested Functions <<<

      You can nest functions inside other functions.
      The inner functions have access to the variables from the outer functions.
      You cannot do this in Java (maybe for good reason).
     */

    fun outerFunction(message: String) : String{
        fun innerFunction(punctuation: Char): String {
            return message + punctuation
        }
        var resultOfInnerFunction: String = innerFunction('?')
        return resultOfInnerFunction
    }

    @Test
    fun `nested function`() {
        val result = outerFunction("Kotlin")
        assertThat(result).isEqualTo("Kotlin?")
    }

    /*

    >>> Static Classes <<<

    Kotlin doesn't have static classes. It has package level classes which just exist outside of
    a class.

     */
    @Test
    fun `call package level function`() {
        val result = packageLevelFunction();
        assertThat(result).isEqualTo("I'm Free!")
    }
}

fun packageLevelFunction(): String {
    return "I'm Free!"
}