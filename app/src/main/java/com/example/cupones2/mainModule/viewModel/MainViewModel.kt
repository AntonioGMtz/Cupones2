package com.example.cupones2.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cupones2.R
import com.example.cupones2.common.entities.CouponEntity
import com.example.cupones2.common.utils.getMsgErrorByCode
import com.example.cupones2.mainModule.model.MainRepository
import kotlinx.coroutines.launch


class MainViewModel : ViewModel(){

    private val repository = MainRepository()

    private val result = MutableLiveData<CouponEntity>()

    fun getResult() = result

    //Recibe el recuros de cuoponsUTILS -> GETeRRORBYcODE getErrorByCode
    private val snackbaMsg = MutableLiveData<Int>()

    fun getSnackbarMsg() = snackbaMsg

    fun consultCouponByCode(code:String){
        viewModelScope.launch{
            result.value = repository.consultCouponByCode(code)
        }
    }

    fun saveCoupon(couponEntity : CouponEntity){
        viewModelScope.launch {
            try{
                repository.saveCoupon(couponEntity)
                consultCouponByCode(couponEntity.code)
                snackbaMsg.value = R.string.main_save_success
            }catch (e : Exception){
                snackbaMsg.value = getMsgErrorByCode(e.message)
            }
        }
    }


}