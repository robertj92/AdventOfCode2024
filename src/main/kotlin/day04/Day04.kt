package de.rjunklewitz.day04

import de.rjunklewitz.utils.readInput

class Day04 {

    fun partOne(input: List<String>): Int {
        val chars = input.map { it.toList() }.toList()
        val output = ArrayList<ArrayList<Char>>(input.size)
        for (line in input.indices) {
            output.add(ArrayList())
            for (i in chars[0].indices) {
                output[line].add('.')
            }
        }

        var countOfXmas = 0

        for (row in chars.indices) {
            for (col in chars[row].indices) {
                // horizontal forwards
                if (chars[row][col] == 'X' && col < chars[row].size - 3) {
                    if (chars[row][col + 1] == 'M' && chars[row][col + 2] == 'A' && chars[row][col + 3] == 'S') {
                        output[row][col] = 'X'
                        output[row][col + 1] = 'M'
                        output[row][col + 2] = 'A'
                        output[row][col + 3] = 'S'
                        countOfXmas++
                    }
                }

                // horizontal backwards
                if (chars[row][col] == 'X' && col > 2) {
                    if (chars[row][col - 3] == 'S' && chars[row][col - 2] == 'A' && chars[row][col - 1] == 'M') {
                        output[row][col] = 'X'
                        output[row][col - 1] = 'M'
                        output[row][col - 2] = 'A'
                        output[row][col - 3] = 'S'
                        countOfXmas++
                    }
                }

                // vertical forwards
                if (chars[row][col] == 'X' && row < chars.size - 3) {
                    if (chars[row + 1][col] == 'M' && chars[row + 2][col] == 'A' && chars[row + 3][col] == 'S') {
                        output[row][col] = 'X'
                        output[row + 1][col] = 'M'
                        output[row + 2][col] = 'A'
                        output[row + 3][col] = 'S'
                        countOfXmas++
                    }
                }

                // vertical backwards
                if (chars[row][col] == 'X' && row > 2) {
                    if (chars[row - 3][col] == 'S' && chars[row - 2][col] == 'A' && chars[row - 1][col] == 'M') {
                        output[row][col] = 'X'
                        output[row - 1][col] = 'M'
                        output[row - 2][col] = 'A'
                        output[row - 3][col] = 'S'
                        countOfXmas++
                    }
                }

                // diagonal downwards forwards
                if (chars[row][col] == 'X' && row < chars.size - 3 && col < chars[row].size - 3) {
                    if (chars[row + 1][col + 1] == 'M' && chars[row + 2][col + 2] == 'A' && chars[row + 3][col + 3] == 'S') {
                        output[row][col] = 'X'
                        output[row + 1][col + 1] = 'M'
                        output[row + 2][col + 2] = 'A'
                        output[row + 3][col + 3] = 'S'
                        countOfXmas++
                    }
                }

                // diagonal downwards backwards
                if (chars[row][col] == 'X' && row > 2 && col > 2) {
                    if (chars[row - 3][col - 3] == 'S' && chars[row - 2][col - 2] == 'A' && chars[row - 1][col - 1] == 'M') {
                        output[row][col] = 'X'
                        output[row - 1][col - 1] = 'M'
                        output[row - 2][col - 2] = 'A'
                        output[row - 3][col - 3] = 'S'
                        countOfXmas++
                    }
                }

                // diagonal upwards forwards
                if (chars[row][col] == 'X' && row > 2 && col < chars[row].size - 3) {
                    if (chars[row - 1][col + 1] == 'M' && chars[row - 2][col + 2] == 'A' && chars[row - 3][col + 3] == 'S') {
                        output[row][col] = 'X'
                        output[row - 1][col + 1] = 'M'
                        output[row - 2][col + 2] = 'A'
                        output[row - 3][col + 3] = 'S'
                        countOfXmas++
                    }
                }

                // diagonal upwards backwards
                if (chars[row][col] == 'X' && row < chars.size - 3 && col > 2) {
                    if (chars[row + 3][col - 3] == 'S' && chars[row + 2][col - 2] == 'A' && chars[row + 1][col - 1] == 'M') {
                        output[row][col] = 'X'
                        output[row + 1][col - 1] = 'M'
                        output[row + 2][col - 2] = 'A'
                        output[row + 3][col - 3] = 'S'
                        countOfXmas++
                    }
                }
            }
        }

        for (line in output) {
            println(line)
        }

        return countOfXmas
    }

    fun partTwo(input: List<String>): Int {
        val chars = input.map { it.toList() }.toList()
        val output = ArrayList<ArrayList<Char>>(input.size)
        for (line in input.indices) {
            output.add(ArrayList())
            for (i in chars[0].indices) {
                output[line].add('.')
            }
        }

        var countOfXmas = 0

        for (row in chars.indices) {
            for (col in chars[row].indices) {
                if (chars[row][col] == 'A' && row in 1..chars.size - 2 && col in 1 .. chars[row].size - 2) {
                    if (listOf(chars[row - 1][col - 1], chars[row + 1][col + 1]).containsAll(listOf('M', 'S')) &&
                        listOf(chars[row - 1][col + 1], chars[row + 1][col - 1]).containsAll(listOf('M', 'S'))) {
                        output[row][col] = chars[row][col]
                        output[row - 1][col - 1] = chars[row - 1][col - 1]
                        output[row - 1][col + 1] = chars[row - 1][col + 1]
                        output[row + 1][col - 1] = chars[row + 1][col - 1]
                        output[row + 1][col + 1] = chars[row + 1][col + 1]
                        countOfXmas++
                    }
                }
            }
        }

        for (line in output) {
            println(line)
        }

        return countOfXmas
    }
}

fun main() {
    val day04 = Day04()
    val input = readInput("day04/input")

    val partOneResult = day04.partOne(input)
    val partTwoResult = day04.partTwo(input)

    println("Day 04 part one result is $partOneResult")
    println("Day 04 part two result is $partTwoResult")
}