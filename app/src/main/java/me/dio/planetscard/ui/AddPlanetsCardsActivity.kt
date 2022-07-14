package me.dio.planetscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.dio.planetscard.App
import me.dio.planetscard.R
import me.dio.planetscard.data.PlanetsCard
import me.dio.planetscard.databinding.ActivityAddPlanetsCardsBinding

class AddPlanetsCardsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddPlanetsCardsBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener{
            finish()
        }
        //Recebe os valores que o usuário digitar na tela
        binding.btnConfirm.setOnClickListener{
            val planetsCard = PlanetsCard(
                nome = binding.tilNome.editText?.text.toString(),
                distancia = binding.tilDistancia.editText?.text.toString(),
                atmosfera = binding.tilAtmosfera.editText?.text.toString(),
                caracteristica = binding.tilCaracterStica.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString(),
            )
            mainViewModel.insert(planetsCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}