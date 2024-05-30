package interpreter.command

import de.volkswagen.interpreter.command.Cmp
import de.volkswagen.interpreter.computer.Memory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CmpTest {

    @Test
    fun `sets  last compare to 0`() {
        //Given
        val memory = Memory()
        memory.set("a", 10)
        memory.set("b", 10)
        // when
        Cmp("a b").execute(memory)
        //
        assertEquals(0, memory.lastCompare)
    }
}