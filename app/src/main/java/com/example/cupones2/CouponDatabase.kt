package com.example.cupones2

import androidx.room.Database
import androidx.room.RoomDatabase

/*
* @Database(entities = [CouponEntity::class], version = 1): Esta anotación define la clase como una base de datos Room.
*-> entities = [CouponEntity::class]: Lista de todas las entidades asociadas a esta base de datos.
Aquí, CouponEntity es la única entidad, lo que significa que esta base de datos tendrá una tabla llamada CouponEntity.
*-> version = 1: Especifica la versión de la base de datos. Room usa este número para manejar
las migraciones de la base de datos cuando cambian las estructuras de las tablas.
* */
@Database(entities = [CouponEntity::class], version = 1)

/*
Proporciona una instancia del CouponDao que contiene los métodos definidos para realizar operaciones en la base de datos.
*/


abstract class CouponDatabase : RoomDatabase() {
    abstract fun couponDao(): CouponDao
}