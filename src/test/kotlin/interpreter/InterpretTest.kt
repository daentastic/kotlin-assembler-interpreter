package interpreter

import de.volkswagen.interpreter.interpret
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InterpretTest {

    @Test
    fun `interprets program correctly`(){
        // Given
        val program = """
            mov a 10
            msg a
            end
            """
        // When // Then
        assertEquals("10", interpret(program))

    }

    @Test
    fun `interprets subroutine correctly`() {
        // Given
        val program = """
            mov a 10
            call foo
            msg a
            end

            foo:
                inc a
                ret
            """
        // When // Then
        assertEquals("11", interpret(program))
    }
}