package br.com.honeyinvestimentos.numeromagico

import java.util.*

/*
min =250
max =500

 > 500 ? N

 > 250 ? S

 >

432
 */

fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start

fun guessThinkNumber(max:Int, min:Int):Int =

    if(min > 0){

        min + ((max - min) / 2)

    }else{

        (max - min) / 2

    }


