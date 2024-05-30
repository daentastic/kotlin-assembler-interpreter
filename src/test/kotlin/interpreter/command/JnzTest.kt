package interpreter.command

import de.volkswagen.interpreter.command.Jnz
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JnzTest {

    @Test
    fun `sets memory command pointer to pointer before next command to execute`() {
        // Given
        val memory = Memory()
        memory.set("a", 1)
        // When
        Jnz("a -1").execute(memory)
        // Then
        assertEquals(-2, memory.commandPointer.current)
    }
}