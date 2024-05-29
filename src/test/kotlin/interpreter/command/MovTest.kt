package interpreter.command

import de.volkswagen.interpreter.computer.Memory
import de.volkswagen.interpreter.command.Mov
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovTest {

    @Test
    fun `moves value to correct position`() {
        // Given
        val memory = Memory()
        // When
        Mov("mov a 5").execute(memory)
        // Then
        assertEquals(mapOf("a" to 5), memory.content)

    }

    @Test
    fun `copies value of existing variable into new variable`() {
        // Given
        val memory = Memory()
        Mov("mov a 5").execute(memory)
        // When
        Mov("mov b a").execute(memory)
        // Then
        assertEquals(mapOf("a" to 5,"b" to 5), memory.content)

    }
}