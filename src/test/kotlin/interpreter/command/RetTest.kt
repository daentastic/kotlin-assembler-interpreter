package interpreter.command

import de.volkswagen.interpreter.command.Ret
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RetTest {
    @Test
    fun `sets pointer correctly`() {
        // Given
        val memory = Memory()
        memory.commandPointer.jumpTo(5)
        // When
        Ret().execute(memory)
        // Then
        assertEquals(0, memory.commandPointer.current)
    }
}