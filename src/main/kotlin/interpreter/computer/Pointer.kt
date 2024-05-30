package de.volkswagen.interpreter.computer

class Pointer {
    private val history = mutableListOf<Int>()

    companion object {
        val end = Int.MIN_VALUE
    }

    var current = 0
        private set

    fun jumpBack() = run {
        if (history.size > 0) {
            current = history.last()
            history.removeAt(history.lastIndex)
        }
    }

    fun jumpTo(index: Int) = run {
        history.add(current)
        current = index
    }

    fun goSteps(increment: Int) = run { current += increment }

    fun goNextStep() = run { goSteps(1) }
}