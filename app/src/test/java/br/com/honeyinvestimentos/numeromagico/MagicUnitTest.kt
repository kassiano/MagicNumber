package br.com.honeyinvestimentos.numeromagico

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MagicUnitTest {


    @Test
    fun middle_is_correct_when_min0_max_1000(){

        val min = 0
        val max = 1000

        val result = guessThinkNumber(max, min)

        assertEquals(500, result)

    }

    @Test
    fun middle_is_correct_when_min250_max_500(){

        val min = 250
        val max = 500

        val result = guessThinkNumber(max, min)

        assertEquals(375, result)

    }


    @Test
    fun middle_is_correct_when_min375_max_500(){

        val min = 375
        val max = 500

        val result = guessThinkNumber(max, min)

        assertEquals(437, result)

    }


    @Test
    fun middle_is_correct_when_min375_max_437(){

        val min = 375
        val max = 437

        val result = guessThinkNumber(max, min)

        assertEquals(406, result)

    }


    @Test
    fun middle_is_correct_when_min406_max_437(){

        val min = 406
        val max = 437

        val result = guessThinkNumber(max, min)

        assertEquals(421, result)

    }

    @Test
    fun middle_is_correct_when_min421_max_437(){

        val min = 421
        val max = 437

        val result = guessThinkNumber(max, min)

        assertEquals(429, result)

    }

    @Test
    fun middle_is_correct_when_min429_max_437(){

        val min = 429
        val max = 437

        val result = guessThinkNumber(max, min)

        assertEquals(433, result)

    }


    @Test
    fun middle_is_correct_when_min429_max_433(){

        val min = 429
        val max = 433

        val result = guessThinkNumber(max, min)

        assertEquals(431, result)

    }

    @Test
    fun middle_is_correct_when_min431_max_433(){

        val min = 431
        val max = 433

        val result = guessThinkNumber(max, min)

        assertEquals(432, result)

    }
}
