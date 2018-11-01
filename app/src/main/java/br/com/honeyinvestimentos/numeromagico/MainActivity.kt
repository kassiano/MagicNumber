package br.com.honeyinvestimentos.numeromagico

import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.okButton
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    var nMax = 1000
    var nMin = 0
    var guessedNumber =0
    var qtdTentativas =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btInitGame.setOnClickListener {
            initGame()
        }

        btAcertou.setOnClickListener {
            alert("Uhull! Eu sou um genio") {
                okButton {

                initGame()
                }
            }.show()
        }

        btErrou.setOnClickListener {

            showNewTryAlert("O número que você está pensando é maior ou menor que $guessedNumber")

        }
    }


    fun initGame(){
        nMax = 1000
        nMin = 0
        qtdTentativas = 0
        guessedNumber = 0
        linearResult.visibility = View.GONE

        makeGuess()
    }

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
        linearResult.visibility = View.GONE
    }

    fun hideProgress(){
        progressBar.visibility = View.GONE
        linearResult.visibility = View.VISIBLE
    }

    fun updateTries(){
        qtdTentativas++
        tvTentativas.text = "Tentativas: $qtdTentativas"
    }

    fun makeGuess(){

        showProgress()

        doAsync {
            SystemClock.sleep(1000)

            if(qtdTentativas==0){

                guessedNumber = (nMin..nMax).random()

            }else{
                guessedNumber = guessThinkNumber(nMax, nMin)
            }


            uiThread {

                tvNumberGuessed.text = "$guessedNumber ?"

                hideProgress()
                updateTries()
            }
        }

    }


    fun numberIsHigher(){
        nMin = guessedNumber
        makeGuess()
    }

    fun numberIsLower(){
        nMax = guessedNumber
        makeGuess()
    }

    fun showNewTryAlert(msg:String){

        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setMessage(msg)

        alertBuilder.setPositiveButton("Maior") { _,_->
            numberIsHigher()
        }

        alertBuilder.setNegativeButton("Menor") { _,_->
            numberIsLower()
        }

        alertBuilder.show()
    }

}

