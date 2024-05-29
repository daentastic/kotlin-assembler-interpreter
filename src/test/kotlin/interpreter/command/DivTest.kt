package interpreter.command

import de.volkswagen.interpreter.command.Div
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivTest {

    @Test
    fun `devides varibale`() {
        // Given
        val memory = Memory()
        memory.set("a", 10)
        // When
        Div("div a 2").execute(memory)
        // Then
        assertEquals(5, memory.content["a"])
    }

    @Test
    fun `devides varibale by other variable`() {
        // Given
        val memory = Memory()
        memory.set("a", 11)
        memory.set("b", 3)
        // When
        Div("div a b").execute(memory)
        // Then
        assertEquals(3, memory.content["a"])
    }

}