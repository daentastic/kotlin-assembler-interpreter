package interpreter

import de.volkswagen.interpreter.interpret
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InterpretTest {

    @Test
    fun `interprets program correctly`() {
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

    @Test
    fun `daniels test`() {
        // Given
        val program = """
; My first program
mov  a 5
inc  a
call function
msg  '(5+1)/2 = ', a    ; output message
end

function:
    div  a 2
    ret
"""
        // When // Then
        assertEquals("(5+1)/2 = 3", interpret(program))
    }

    @Test
    fun `prints faculty`() {
        val program = """
mov a 5
mov b a
mov c a
call proc_fact
call print
end

proc_fact:
    dec b
    mul c b
    cmp b 1
    jne proc_fact
    ret

print:
    msg a, '! = ', c ; output text
    ret
            """

        // When // Then
        assertEquals("5! = 120", interpret(program))
    }
}