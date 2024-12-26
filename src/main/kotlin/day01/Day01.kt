package de.rjunklewitz.day01

import de.rjunklewitz.utils.readInput
import kotlin.math.abs

class Day01 {
    fun smallest(numbers: List<Int>): Int {
        if (numbers.isNotEmpty()) {
            return numbers.minOrNull()!!
        }
        return 0
    }

    fun process(input: List<String>): Int {
        var (leftSide, rightSide) = convertToLocationGroups(input)

        var completeDistance = 0

        while (leftSide.isNotEmpty()) {
            val smallestLeftSide = leftSide.first()
            val smallestRightSide = rightSide.first()

            val distance = abs(smallestLeftSide - smallestRightSide)
            completeDistance += distance

            leftSide = leftSide.drop(1)
            rightSide = rightSide.drop(1)
        }

        return completeDistance
    }

    fun convertToLocationGroups(input: List<String>): Pair<List<Int>, List<Int>> {
        val locationGroupOne = mutableListOf<Int>()
        val locationGroupTwo = mutableListOf<Int>()

        for (line in input) {
            val (left, right) = line.trim().split(Regex("\\s+")).map { it.toInt() }
            locationGroupOne.add(left)
            locationGroupTwo.add(right)
        }

        return Pair(locationGroupOne.sorted(), locationGroupTwo.sorted())
    }

    fun partTwo(input: List<String>): Int {
        val (leftSide, rightSide) = convertToLocationGroups(input)

        return leftSide.sumOf { value -> value * rightSide.count { it -> it == value } }
    }
}

fun main() {
    val day01 = Day01()
    val input = readInput("day01/input")
    val distance = day01.process(input)
    val occurrenceSums = day01.partTwo(input)

    println("The distance is $distance")
    println("The occurence sums are $occurrenceSums")
}