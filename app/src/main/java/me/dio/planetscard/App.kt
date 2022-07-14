package me.dio.planetscard

import android.app.Application
import me.dio.planetscard.data.AppDatabase
import me.dio.planetscard.data.PlanetsCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { PlanetsCardRepository(database.planetsDao()) }
}