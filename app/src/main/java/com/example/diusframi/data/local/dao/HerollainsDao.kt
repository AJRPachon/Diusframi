package com.example.diusframi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
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

    @Transaction
    @Query("SELECT * FROM herollain WHERE id =:id")
    fun getHerollain(id: Int): HerollainWithData


    ////////// INSERT ////////////////////////////////////////////////////////////////////////////

    @Transaction
    @Insert(onConflict = IGNORE)
    fun insertHerollains(herollainListDbo: List<HerollainDbo>,
                         appearanceList: List<AppearanceDbo?>,
                         biographyList: List<BiographyDbo?>,
                         powerStatList: List<PowerStatsDbo?>,
                         imageList: List<ImageDbo?>)


    ////////// UPDATE ////////////////////////////////////////////////////////////////////////////

    @Query("UPDATE herollain SET isFavorite = NOT isFavorite WHERE id = :id")
    fun setHerollainFavorite(id: Int)


}