package interpreter.computer

import de.volkswagen.interpreter.computer.Pointer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PointerTest {

    @Test
    fun `goes one step forward`() {
        // Given
        val pointer = Pointer()
        // When
        pointer.goNextStep()
        // Then
        assertEquals(1, pointer.current)
    }

    @Test
    fun `goes given steps forward`() {
        // Given
        val pointer = Pointer()
        // When
        pointer.goSteps(5)
        pointer.goSteps(5)
        // Then
        assertEquals(10, pointer.current)
    }

    @Test
    fun `goes given steps backwards`() {
        // Given
        val pointer = Pointer()
        pointer.goSteps(5)
        // When
        pointer.goSteps(-2)
        // Then
        assertEquals(3, pointer.current)
    }

    @Test
    fun `jumps to index 5`() {
        // Given
        val pointer = Pointer()
        // When
        pointer.jumpTo(5)
        // Then
        assertEquals(5, pointer.current)
    }

    @Test
    fun `jumps back to origin`() {
        // Given
        val pointer = Pointer()
        pointer.jumpTo(10)
        // When
        pointer.jumpBack()
        // Then
        assertEquals(0, pointer.current)
    }

    @Test
    fun `does not jump back if there is no origin`() {
        // Given
        val pointer = Pointer()
        pointer.goSteps(10)
        // When
        pointer.jumpBack()
        // Then
        assertEquals(10, pointer.current)
    }
}