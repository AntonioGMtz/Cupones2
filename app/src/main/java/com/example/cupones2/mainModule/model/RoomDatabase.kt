package com.example.cupones2.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.example.cupones2.CouponsApplication
import com.example.cupones2.common.dataAcces.CouponDao
import com.example.cupones2.common.entities.CouponEntity
import com.example.cupones2.common.utils.Constans
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.withContext


//Clase auxiliar para acceso a Datos
//Enlaza con la fuente de datos y procesar los datos con esta api
class RoomDatabase {

    /*
    La propiedad dao se inicializa solo cuando se accede por primera vez. Esto significa que el bloque de inicialización
    { CouponsApplication.database.couponDao() } no se ejecuta hasta que dao se utiliza por primera vez.
     */
    private val dao : CouponDao by lazy { CouponsApplication.database.couponDao()}


    suspend fun consultCouponByCode(code : String) = dao.consultCouponByCode(code)


    /*  Dispatchers.IO, que es adecuado para operaciones de I/O.
    Esto asegura que el trabajo de guardar el cupón se realice en un hilo de fondo, evitando bloquear el hilo principal.*/
    suspend fun saveCoupon(couponEntity : CouponEntity) = withContext(Dispatchers.IO){
        try{
            //dao.addCoupon(couponEntity) es una llamada a un método que realiza una inserción en la base de datos.
            dao.addCoupon(couponEntity)
        }
        catch (e:Exception){
            //Verifica si la excepción capturada es una SQLiteConstraintException, que se lanza en caso
            // de violación de restricciones en la base de datos (como una restricción de unicidad).
            (e as? SQLiteConstraintException)?.let { throw Exception(Constans.ERROR_EXIST) }
            throw Exception(e.message ?: Constans.ERROR_UNKNOW)

        }
    }
}