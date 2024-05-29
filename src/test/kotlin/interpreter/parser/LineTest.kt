package interpreter.parser

import de.volkswagen.interpreter.parser.Line
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LineTest {

    @Test
    fun `recognizes comment at beginning`() {
        // Given
        val line = Line(";mov b a")
        // When
        // Then
      assertEquals("", line.get())
    }

    @Test
    fun `recognizes comment in between`() {
        // Given
        val line = Line("inc a ; inc a")
        // When
        // Then
        assertEquals("inc a", line.get())
    }
}