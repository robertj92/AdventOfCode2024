package day03

import de.rjunklewitz.day03.Day03
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {

    val day03 = Day03()

    @Test
    fun partOneTest() {
        val result = day03.partOne(
            listOf(
                "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
            )
        )

        assertEquals(161, result)
    }

    @Test
    fun partTwoTest() {
        val result = day03.partTwo(
            listOf(
                "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
            )
        )

        assertEquals(48, result)
    }
}