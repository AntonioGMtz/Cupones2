package com.example.cupones2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface CouponDao {

    /* suspend fun: Indica que esta función es una función suspendida (suspend function) y puede ser llamada desde una corrutina.
    Esto permite que Room maneje la operación de I/O de manera asincrónica, evitando bloquear el hilo principal.*/

    /*CouponEntity?: La función devuelve una instancia de CouponEntity si encuentra un registro con el código especificado.
     Si no encuentra ningún registro, devuelve null.*/

    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponByCode(code: String): CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity): Long
}