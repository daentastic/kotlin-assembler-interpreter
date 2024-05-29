package interpreter.command

import de.volkswagen.interpreter.computer.Memory
import de.volkswagen.interpreter.command.Dec
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecTest {

    @Test
    fun `decreases previously declared value by 1`() {
        // Given
        val memory = Memory()
        memory.set("a", 5)
        // When
        Dec("dec a").execute(memory)
        // Then
        assertEquals(mapOf("a" to 4), memory.content)
    }
}