package de.rjunklewitz.day03

import de.rjunklewitz.utils.readInput

private const val MULTIPLY_PATTERN = """mul\(\d{1,3},\d{1,3}\)"""
private const val DO_PATTERN = """do\(\)"""
private const val DONT_PATTERN = """don't\(\)"""
private const val NUMBER_PATTERN = "\\d+"

class Day03 {
    fun partOne(input: List<String>): Int {
        return input.sumOf { line -> calculateSumOfMultiplications(line) }
    }

    fun partTwo(input: List<String>): Int {
        return input.sumOf { line -> calculateSumOfMultiplicationsWithDosAndDonts(line) }
    }

    private fun calculateSumOfMultiplicationsWithDosAndDonts(line: String): Int {
        val allMultiplications = Regex(MULTIPLY_PATTERN).findAll(line).toList()
        val allDos = Regex(DO_PATTERN).findAll(line).toList()
        val allDonts = Regex(DONT_PATTERN).findAll(line).toList()

        var lastStartOfMultiplication = 0

        for (multiplication in allMultiplications) {
            val value = multiplication.value
            val range = multiplication.range

            val start = range.first

            val allDosBefore = allDos.filter { doStmt -> doStmt.range.first in (lastStartOfMultiplication + 1)..<start }
            val allDontsBefore = allDonts.filter { dontStmt -> dontStmt.range.first in (lastStartOfMultiplication + 1)..<start }



            lastStartOfMultiplication = start
        }

        return 0
    }

    private fun calculateSumOfMultiplications(line: String): Int {
        val multiplyMatches = Regex(MULTIPLY_PATTERN).findAll(line).map { it.value }.toList()

        return multiplyMatches.sumOf {
            multiplication ->
            multiplyNumbers(multiplication)
        }
    }

    private fun multiplyNumbers(multiplication: String) = Regex(NUMBER_PATTERN)
        .findAll(multiplication)
        .map { it.value.toInt() }
        .reduce { acc, num -> acc * num }
}

fun main() {
    val day03 = Day03()
    val input = readInput("day03/input")
    val partOneResult = day03.partOne(input)

    println("Day 03 part one result is $partOneResult")
}