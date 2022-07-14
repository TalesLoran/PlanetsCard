package me.dio.planetscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanetsCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val distancia: String,
    val atmosfera: String,
    val caracteristica: String,
    val fundoPersonalizado: String
)