package interpreter.command

import de.volkswagen.interpreter.computer.Memory
import de.volkswagen.interpreter.command.Msg
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MsgTest {

    @Test
    fun `prints given variable`() {
        // Given
        val memory = Memory()
        memory.set("a", 3)
        // When
        Msg("msg a").execute(memory)
        // Then
        assertEquals("3", memory.output.get())
    }

    @Test
    fun `prints given variable and text`() {
        // Given
        val memory = Memory()
        memory.set("a", 3)
        // When
        Msg("msg 'the Result of a is: ', a").execute(memory)
        // Then
        assertEquals("the Result of a is: 3", memory.output.get())
    }
}