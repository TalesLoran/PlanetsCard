package me.dio.planetscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.dio.planetscard.data.PlanetsCard
import me.dio.planetscard.data.PlanetsCardRepository
import java.lang.IllegalArgumentException

class MainViewModel (private val planetsCardRepository: PlanetsCardRepository) : ViewModel() {

    fun insert(planetsCard : PlanetsCard) {
        planetsCardRepository.insert(planetsCard)
    }

    fun getAll() : LiveData<List<PlanetsCard>> {
        return planetsCardRepository.getAll()
    }
}

//Não seria criado aqui se tivesse injeção de dependencia.
class MainViewModelFactory(private val repository: PlanetsCardRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class")

    }
}



