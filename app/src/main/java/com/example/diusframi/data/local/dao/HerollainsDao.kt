package com.example.diusframi.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData

@Dao
interface HerollainsDao {

    //TODO Mirar el get
    @Transaction
    @Query("SELECT * FROM herollain")
    fun getHerollainList(): List<HerollainWithData>

}