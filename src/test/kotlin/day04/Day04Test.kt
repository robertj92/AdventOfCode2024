package day04

import de.rjunklewitz.day04.Day04
import de.rjunklewitz.utils.readInput
import kotlin.test.Test
import kotlin.test.assertEquals


class Day04Test {

    @Test
    fun testPartOne() {
        val day04 = Day04()
        val input = listOf(
            "MMMSXXMASM",
            "MSAMXMSMSA"
        )
        val result = day04.partOne(input)

        assertEquals(2, result)
    }

    @Test
    fun testPartOneHorizontalBackwards() {
        val day04 = Day04()
        val input = listOf(
            "MMSAMXSS",
        )
        val result = day04.partOne(input)

        assertEquals(1, result)
    }

    @Test
    fun testPartOneVerticalForwards() {
        val day04 = Day04()
        val input = listOf(
            "SBXC",
            "SBMC",
            "MBAC",
            "XBSC"
        )

        val result = day04.partOne(input)

        assertEquals(1, result)
    }

    @Test
    fun testPartOneVerticalBackwards() {
        val day04 = Day04()
        val input = listOf(
            "SBXC",
            "ABSC",
            "MBAC",
            "XBSC"
        )

        val result = day04.partOne(input)

        assertEquals(1, result)
    }

    @Test
    fun testPartOneDiagonalDownwards() {
        val day04 = Day04()
        val input = listOf(
            "XS BCT",
            "AMASC",
            "ABAMC",
            "ABCSX"
        )

        val result = day04.partOne(input)

        assertEquals(2, result)
    }

    @Test
    fun testPartOneDiagonalUpwards() {
        val day04 = Day04()
        val input = listOf(
            "XFBSX",
            "AMAMC",
            "AMAMC",
            "XSCCX"
        )

        val result = day04.partOne(input)

        assertEquals(2, result)
    }

    @Test
    fun testPartOneCompleteInput() {
        val day04 = Day04()
        val input = readInput("day04/input_test")

        val result = day04.partOne(input)

        assertEquals(18, result)
    }
}