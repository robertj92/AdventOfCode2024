package de.rjunklewitz.day02

import de.rjunklewitz.utils.readInput
import kotlin.math.abs

class Day02 {
    fun partOne(input: List<String>): Int {
        return input.count { reactorLevels -> isReactorLevelSafe(reactorLevels, false) }
    }

    fun partTwo(input: List<String>): Int {
        return input.count { reactorLevels -> isReactorLevelSafe(reactorLevels, true) }
    }

    private fun isReactorLevelSafe(reactorLevelsAsString: String, tolerateBadLevel: Boolean): Boolean {
        val reactorLevels = reactorLevelsAsString.split(Regex("\\s+")).map { it.toInt() }

        if (!tolerateBadLevel) {
            return isSafe(reactorLevels)
        } else {
            var hasSafeOption = isSafe(reactorLevels)
            if (hasSafeOption) {
                return true
            }

            for (i in reactorLevels.indices) {
                val subList = reactorLevels.filterIndexed { index, _ -> index != i }
                hasSafeOption = isSafe(subList)

                if (hasSafeOption) {
                    return true
                }
            }

            return false
        }
    }

    private fun isSafe(reactorLevels: List<Int>): Boolean {
        val ascending = reactorLevels[0] < reactorLevels[1]

        for (i in 0..(reactorLevels.size - 2)) {
            val firstNumber = reactorLevels[i]
            val secondNumber = reactorLevels[i + 1]

            if (isBadLevel(ascending, firstNumber, secondNumber)) {
                return false
            }
        }

        return true
    }

    private fun isBadLevel(
        ascending: Boolean,
        firstNumber: Int,
        secondNumber: Int
    ): Boolean {
        val difference = abs(firstNumber - secondNumber)
        return difference < 1
                || difference > 3
                || (ascending && firstNumber >= secondNumber)
                || (!ascending && firstNumber <= secondNumber)
    }
}

fun main() {
    val day02 = Day02()
    val input = readInput("day02/input")

    val partOneResult = day02.partOne(input)
    println("Result of part one is $partOneResult")

    val partTwoResult = day02.partTwo(input)
    println("Result of part two is $partTwoResult")
}