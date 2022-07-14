package me.dio.planetscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PlanetsCardRepository(private val dao: PlanetsCardDao){

    fun insert(planetsCard: PlanetsCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(planetsCard)
        }
    }
    fun getAll() = dao.getAll()
}