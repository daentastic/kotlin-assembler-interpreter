package interpreter.command

import de.volkswagen.interpreter.command.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CommandGeneratorTest {

    @Test
    fun `generates Mov command`() {
        // when
        val commandName = "mov"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a b") is Mov)
    }

    @Test
    fun `generates Inc command`() {
        // when
        val commandName = "inc"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a") is Inc)
    }

    @Test
    fun `generates Dec command`() {
        // when
        val commandName = "dec"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a") is Dec)
    }

    @Test
    fun `generates Jnz command`() {
        // when
        val commandName = "jnz"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a -1") is Jnz)
    }

    @Test
    fun `generates Msg command`() {
        // when
        val commandName = "msg"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a") is Msg)
    }

    @Test
    fun `generates Call command`() {
        // when
        val commandName = "call"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("1") is Call)
    }

    @Test
    fun `generates Ret command`() {
        // when
        val commandName = "ret"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("") is Ret)
    }

    @Test
    fun `generates End command`() {
        // when
        val commandName = "end"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("") is End)
    }

    @Test
    fun `generates Div command`() {
        // when
        val commandName = "div"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a b") is Div)
    }

    @Test
    fun `generates Mul command`() {
        // when
        val commandName = "mul"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a b") is Mul)
    }

    @Test
    fun `generates Skip command if command is not known`() {
        // when
        val commandName = "randomString"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a b") is Skip)
    }

    @Test
    fun `generates Cmp command`() {
        // when
        val commandName = "cmp"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("a b") is Cmp)
    }

    @Test
    fun `generates Jne command`() {
        // when
        val commandName = "jne"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("2") is Jne)
    }

    @Test
    fun `generates Jle command`() {
        // when
        val commandName = "jle"
        //when
        val commandFunction = commandName.commandFunction()
        //then
        assertTrue(commandFunction("2") is Jle)
    }
}