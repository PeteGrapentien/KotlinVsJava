package com.kotlinexamples.pete.kotlinexamples

import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.*

class Nullability {
    /**
     * For nullable types, you can use the safe call operator
     * to call methods and access properties on a potentially null
     * object. If the object is null, the resulting expression will
     * return null.
     */
    @Test
    fun `safe call operator`() {
        val nothing: List<String>? = null
        val firstItem = nothing?.first()

        assertThat(firstItem).isNull()
    }

    /**
     * The Elvis operator will provide a default value
     * to be used if the preceding expression results in a null
     * value.
     *
     * It is the same as doing:
     * var firstItem = "N/A"
     * if (nothing != null) {
     *      firstItem = nothing.first()
     * }
     */
    @Test
    fun `the Elvis operator`() {
        val nothing: List<String>? = null
        val firstItem = nothing?.first() ?: "N/A"

        assertThat(firstItem).isEqualTo("N/A")
    }

    /**
     * If you have a nullable type, you can use the !! operator
     * to return a non-null value.
     *
     * Be Warned: the !! operator essentially undoes the null safety
     * provided Kotlin. If you access methods, properties on a null
     * object an NPE will be thrown.
     */
    @Test
    fun `successful unwrapping`() {
        val nothing: List<String>? = listOf("thing")
        val length = nothing!!.first()

        assertThat(length).isEqualTo("thing")
    }

    @Test(expected = KotlinNullPointerException::class)
    fun `unsuccessful unwrapping`() {
        val nothing: List<String>? = null
        val length = nothing!!.first()
    }
}
