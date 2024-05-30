package interpreter.command

import de.volkswagen.interpreter.command.Call
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CallTest {
    @Test
    fun `sets pointer correctly`() {
        // Given
        val memory = Memory()
        // When
        Call("5").execute(memory)
        // Then
        assertEquals(5, memory.commandPointer.current)
    }
}