package me.dio.planetscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlanetsCardDao {
    @Query("SELECT * FROM PlanetsCard")
    fun getAll(): LiveData<List<PlanetsCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(planetsCard: PlanetsCard)
}