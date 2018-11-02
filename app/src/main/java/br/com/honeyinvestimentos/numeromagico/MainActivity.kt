package br.com.honeyinvestimentos.numeromagico

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton

class MainActivity : AppCompatActivity() {

    val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

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

            showNewTryAlert("O número que você está pensando é maior ou menor que ${viewModel.guessedNumber.value}")

        }

        observeGuessedNumber()
        observeShowingProgress()
        observeTries()
    }


    fun initGame(){
       viewModel.initValues()
        linearResult.visibility = View.GONE
        viewModel.makeGuess()
    }

    fun showProgress(){
        progressBar.visibility = View.VISIBLE
        linearResult.visibility = View.GONE
    }

    fun hideProgress(){
        progressBar.visibility = View.GONE
        linearResult.visibility = View.VISIBLE
    }

    fun observeShowingProgress(){
        viewModel.showingProgress.observe(this, Observer {
            showing->

            showing?.let {

                if(it)
                    showProgress()
                else
                    hideProgress()
            }
        })
    }

    fun observeTries(){

        viewModel.tries.observe(this, Observer{
            qtdTentativas->

            qtdTentativas?.let {
                tvTentativas.text = "Tentativas: $it"
            }

        })
    }

    fun observeGuessedNumber(){

        viewModel.guessedNumber.observe(this, Observer {
            number->

            number?.let {
                tvNumberGuessed.text = "$it ?"
            }
        })
    }


    fun numberIsHigher(){
        viewModel.nMin.value =  viewModel.guessedNumber.value
        viewModel.makeGuess()
    }

    fun numberIsLower(){
        viewModel.nMax.value = viewModel.guessedNumber.value
        viewModel.makeGuess()
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

