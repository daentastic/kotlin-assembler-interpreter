package interpreter

import de.volkswagen.interpreter.parse
import org.junit.jupiter.api.Test

class ParserTest {

    @Test
    fun `moves value to correct position`() {
        // Given // When
        val result = parse(arrayOf("mov a 5"))
        // Then
       kotlin.test.assertEquals(mapOf("a" to 5), result)

    }

    @Test
    fun `increases previously declared value by 1`() {
        // Given // When
        val result = parse(arrayOf("mov a 5", "inc a"))
        // Then
        kotlin.test.assertEquals(mapOf("a" to 6), result)
    }

    @Test
    fun `decreases previously declared value by 1`() {
        // Given // When
        val result = parse(arrayOf("mov a 5", "dec a"))
        // Then
        kotlin.test.assertEquals(mapOf("a" to 4), result)

    }

    @Test
    fun `copies value of existing variable into new variable`() {
        // Given // When
        val result = parse(arrayOf("mov a 5", "dec a", "mov b a"))
        // Then
        kotlin.test.assertEquals(mapOf("a" to 4,"b" to 4), result)

    }

    @Test
    fun `jumps to correct commands and executes accordingly`() {
        // Given // When
        val result = parse(arrayOf("mov a 5", "dec a", "jnz a -1", "inc a"))
        // Then
        kotlin.test.assertEquals(mapOf("a" to 1), result)
    }

    @Test
    fun `jumps to correct commands and executes accordingly2`() {
        // Given // When
        val result = parse(arrayOf("mov a 10","mov b 2","dec b", "dec a","dec a","dec a", "jnz b -4", "inc a"))
        // Then
        kotlin.test.assertEquals(mapOf("a" to 5, "b" to 0), result)
    }

    @Test
    fun `jumps to correct commands according to index`() {
        // Given // When
        val result = parse(arrayOf("mov a 7","mov b 2","dec b", "dec a","dec a","dec a", "jnz b -a", "inc a"))
        // Then
        kotlin.test.assertEquals(mapOf("a" to 2, "b" to 0), result)
    }



}