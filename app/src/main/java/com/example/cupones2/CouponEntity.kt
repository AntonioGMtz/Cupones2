package com.example.cupones2

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

 /* Index(value = ["code"], unique = true): Define un índice en la columna code
 y especifica que debe ser único. Esto significa que los valores en la columna code deben ser únicos
 en toda la tabla, evitando así la inserción de registros con el mismo valor en code.*/

@Entity(tableName = "CouponEntity" , indices = [Index(value = ["code"],unique =  true)])
data class CouponEntity(@PrimaryKey(autoGenerate = true) var id:Long = 0,
                        var code: String = "",
                        var description:String = "",
                        var isActive:Boolean = true)
