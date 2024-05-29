package interpreter.command

import de.volkswagen.interpreter.computer.Memory
import de.volkswagen.interpreter.command.End
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EndTest {
    @Test
    fun `prints output if end is executed`() {
        // Given
        val memory = Memory()
        memory.output.add("hallo")
        // When
        End().execute(memory)
        // Then
        assertTrue(memory.output.isValid)
    }

    @Test
    fun `sets pointer to invalid position to stop program`() {
        // Given
        val memory = Memory()
        memory.output.add("hallo")
        // When
        End().execute(memory)
        // Then
        assertTrue(memory.commandPointer.current<-2)
    }

    @Test
    fun `prints null if end is not executed`() {
        // Given
        val memory = Memory()
        memory.output.add("hallo")
        // When
        // Then
        assertFalse(memory.output.isValid)
    }
}