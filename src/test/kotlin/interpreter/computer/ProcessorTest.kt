package interpreter.computer

import de.volkswagen.interpreter.computer.Processor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNull

class ProcessorTest {

    @Test
    fun `uses jnz correctly`() {
        // Given // When
        val result = Processor().process(arrayOf("mov a -10", "mov b a", "inc a", "dec b", "jnz a -2", "end"))
        // Then
        assertEquals(mapOf("a" to 0, "b" to -20), result)
    }

    @Test
    fun `prints out value a`() {
        // Given
        val processor = Processor()
        // When
        processor.process(arrayOf("mov a 5", "msg a","end"))
        // Then
        assertEquals("5",processor.print())
    }

    @Test
    fun `executes commands and prints results`() {
        // Given
        val processor = Processor()
        // When
        processor.process(
            arrayOf(
                "mov a -10",
                "msg 'a is: ',a",
                ";mov b a",
                "inc a ; asdfgyt",
                "msg '\na is: ',a",
                "end"
            )
        )
        // Then
        kotlin.test.assertEquals("a is: -10\na is: -9", processor.print())
    }

    @Test
    fun `gives null if no end is in program`() {
        // Given
        val processor=Processor()
        // When
        processor.process(
            arrayOf(
                "mov a -10",
                "msg 'a is: ',a",
            )
        )
        // Then
        assertNull(processor.print())
    }

    @Test
    fun `executes commands until first end`() {
        // Given
        val processor =Processor()
        // When
        processor.process(
            arrayOf(
                "mov a -10",
                "msg 'a is: ',a",
                "end",
                ";mov b a",
                "inc a ; asdfgyt",
                "msg '\na is: ',a",
                "end"
            )
        )
        // Then
        kotlin.test.assertEquals("a is: -10", processor.print())
    }

}
