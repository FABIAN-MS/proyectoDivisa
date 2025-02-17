package com.example.proyectodivisas.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface TipoCambioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTipoCambio(tipoCambio: TipoCambio): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetalles(detalles: List<TipoCambioDetalle>)
}