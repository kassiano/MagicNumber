package br.com.honeyinvestimentos.numeromagico

import java.util.*


fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start

fun guessThinkNumber(max:Int, min:Int):Int =

    if(min > 0){

        min + ((max - min) / 2)

    }else{

        (max - min) / 2

    }


