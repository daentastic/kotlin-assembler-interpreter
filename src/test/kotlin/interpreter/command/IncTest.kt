package interpreter.command

import de.volkswagen.interpreter.computer.Memory
import de.volkswagen.interpreter.command.Inc
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IncTest {

    @Test
    fun `increases previously declared value by 1`() {
        // Given
        val memory = Memory()
        memory.set("a", 5)
        // When
        Inc("inc a").execute(memory)
        // Then
        assertEquals(mapOf("a" to 6), memory.content)
    }
}