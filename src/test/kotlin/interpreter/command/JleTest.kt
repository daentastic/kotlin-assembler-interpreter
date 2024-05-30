package interpreter.command

import de.volkswagen.interpreter.command.Jle
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Test

class JleTest {

    @Test
    fun `sets pointer if last compare is -1`() {
        //Given
        val memory = Memory()
        memory.lastCompare = -1
        //When
        Jle("2").execute(memory)
        //Then
        kotlin.test.assertEquals(2, memory.commandPointer.current)
    }

    @Test
    fun `sets pointer if last compare is  0`() {
        //Given
        val memory = Memory()
        memory.lastCompare = 0
        //When
        Jle("2").execute(memory)
        //Then
        kotlin.test.assertEquals(2, memory.commandPointer.current)
    }

    @Test
    fun `does not set pointer last compare is 1`() {
        //Given
        val memory = Memory()
        memory.lastCompare = 1
        //When
        Jle("2").execute(memory)
        //Then
        kotlin.test.assertEquals(0, memory.commandPointer.current)
    }
}