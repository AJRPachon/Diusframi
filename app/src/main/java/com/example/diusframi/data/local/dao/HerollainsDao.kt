package com.example.diusframi.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData
import kotlinx.coroutines.flow.Flow

@Dao
interface HerollainsDao {

    ////////// GET ////////////////////////////////////////////////////////////////////////////

    @Transaction
    @Query("SELECT * FROM herollain")
    fun getHerollainList(): Flow<List<HerollainWithData>>

    @Transaction
    @Query("SELECT * FROM herollain WHERE name =:name")
    fun getHerollain(name: String): HerollainWithData

    @Transaction
    @Query("SELECT * FROM herollain WHERE id =:id")
    fun getHerollain(id: Int): HerollainWithData

    @Transaction
    @Query("SELECT COUNT(id) FROM herollain")
    fun getHerollainCount(): Int

    @Transaction
    @Query("SELECT id FROM biography")
    fun getBiographyIds(): List<Int>


    ////////// INSERT ////////////////////////////////////////////////////////////////////////////

    @Transaction
    @Insert(onConflict = IGNORE)
    fun insertHerollains(herollainListDbo: List<HerollainDbo?>,
                         appearanceList: List<AppearanceDbo?>,
                         biographyList: List<BiographyDbo?>,
                         powerStatList: List<PowerStatsDbo?>,
                         imageList: List<ImageDbo?>
    )


    ////////// UPDATE ////////////////////////////////////////////////////////////////////////////

    @Query("UPDATE herollain SET isFavorite = NOT isFavorite WHERE id = :id")
    fun setHerollainFavorite(id: Int)


}