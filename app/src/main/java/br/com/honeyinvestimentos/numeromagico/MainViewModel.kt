package br.com.honeyinvestimentos.numeromagico

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import arrow.syntax.function.pipe
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainViewModel: ViewModel() {

    val nMax = MutableLiveData<Int>()
    val nMin = MutableLiveData<Int>()
    val guessedNumber = MutableLiveData<Int>()
    val tries = MutableLiveData<Int>()

    val showingProgress: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    init {
        initValues()
    }

    fun initValues(){
        nMax.value = 1000
        nMin.value =0
        guessedNumber.value=0
        tries.value=0
    }

    fun makeGuess(){

        showingProgress.value = true

        doAsync {
            SystemClock.sleep(1000)

            if(tries.value == 0){

                val ini = nMin.value
                val end = nMax.value

                (ini!!..end!!).random() pipe{

                    guessedNumber.postValue(it)
                }


            }else{

                guessThinkNumber(nMax.value!!, nMin.value!!) pipe {
                    guessedNumber.postValue(it)
                }

            }


            uiThread {

                showingProgress.value= false
                tries.value = tries.value!! + 1
            }
        }

    }

}