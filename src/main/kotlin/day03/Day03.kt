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
        return calculateSumOfMultiplicationsWithDosAndDonts(input.joinToString())
    }

    private fun calculateSumOfMultiplicationsWithDosAndDonts(line: String): Int {
        val allDos = Regex(DO_PATTERN).findAll(line).toList()
        val allDonts = Regex(DONT_PATTERN).findAll(line).toList()

        return Regex(MULTIPLY_PATTERN).findAll(line).filter { multiplication ->
            shouldMultiplicationBeConsidered(multiplication, allDos, allDonts)
        }.map { it.value }.sumOf { multiplyNumbers(it) }
    }

    private fun shouldMultiplicationBeConsidered(
        multiplication: MatchResult,
        allDos: List<MatchResult>,
        allDonts: List<MatchResult>
    ): Boolean {
        val range = multiplication.range

        val start = range.first

        val latestDoBefore = allDos.lastOrNull { doStmt -> doStmt.range.first in 0..<start }?.range?.first ?: -1
        val latestDontBefore = allDonts.lastOrNull { dontStmt -> dontStmt.range.first in 0..<start }?.range?.first ?: -1

        return (latestDoBefore == -1 && latestDontBefore == -1) || latestDoBefore > latestDontBefore
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
    val partTwoResult = day03.partTwo(input)

    println("Day 03 part one result is $partOneResult")
    println("Day 03 part two result is $partTwoResult")
}