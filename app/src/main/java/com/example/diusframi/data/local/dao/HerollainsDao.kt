package com.example.diusframi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData

@Dao
interface HerollainsDao {

    ////////// GET ////////////////////////////////////////////////////////////////////////////

    //TODO Mirar el get
    @Transaction
    @Query("SELECT * FROM herollain")
    fun getHerollainList(): List<HerollainWithData>


    ////////// INSERT ////////////////////////////////////////////////////////////////////////////
    @Transaction
    @Insert(onConflict = REPLACE)
    fun insertHerollains(herollainListDbo: List<HerollainDbo>,
                         appearanceList: List<AppearanceDbo?>,
                         biographyList: List<BiographyDbo?>,
                         powerStatList: List<PowerStatsDbo?>,
                         imageList: List<ImageDbo?>)

}