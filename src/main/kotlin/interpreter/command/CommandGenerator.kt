package de.volkswagen.interpreter.command

fun String.commandFunction(): (String) -> Command = when (this) {
    "mov" -> ::Mov
    "inc" -> ::Inc
    "dec" -> ::Dec
    "jnz" -> ::Jnz
    "msg" -> ::Msg
    "call" -> ::Call
    "ret" -> { _ -> Ret() }
    "end" -> { _ -> End() }
    "div" -> ::Div
    "mul" -> ::Mul
    "cmp" -> ::Cmp
    "jne" -> ::Jne
    "jle" -> ::Jle
    else -> { _ -> Skip() }
}
