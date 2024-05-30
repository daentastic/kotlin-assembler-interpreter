package interpreter.command

import de.volkswagen.interpreter.command.Mul
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MulTest {

    @Test
    fun `multiplies two variables`() {
        // Given
        val memory = Memory()
        memory.set("a", 10)
        memory.set("b", 2)
        // When
        Mul("a b").execute(memory)
        // Then
        assertEquals(20, memory.content["a"])
    }
}