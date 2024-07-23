package com.example.cupones2.mainModule.model

import android.provider.SyncStateContract.Constants
import com.example.cupones2.common.entities.CouponEntity
import com.example.cupones2.common.utils.Constans
import com.example.cupones2.common.utils.validateTextCode

class MainRepository {

    //Comunica la fuente con el viewmodel
    private val roomDatabase = RoomDatabase()

    suspend fun consultCouponByCode(code:String) = roomDatabase.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) {
        if (validateTextCode(couponEntity.code)){
            roomDatabase.saveCoupon(couponEntity)
        }
        else{
            throw Exception(Constans.ERROR_LENGTH)
        }

    }    }