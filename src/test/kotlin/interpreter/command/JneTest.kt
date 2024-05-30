package interpreter.command

import de.volkswagen.interpreter.command.Jne
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JneTest {

    @Test
    fun `sets pointer if last compare not 0`() {
        //Given
        val memory = Memory()
        memory.lastCompare = -1
        //When
        Jne("2").execute(memory)
        //Then
        assertEquals(2, memory.commandPointer.current)
    }

    @Test
    fun `does not set pointer last compare is 0`() {
        //Given
        val memory = Memory()
        memory.lastCompare = 0
        //When
        Jne("2").execute(memory)
        //Then
        assertEquals(0, memory.commandPointer.current)
    }

}