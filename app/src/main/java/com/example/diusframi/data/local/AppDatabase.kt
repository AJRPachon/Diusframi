package com.example.diusframi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.BiographyWithAliases
import com.example.diusframi.data.local.dao.HerollainsDao

@Database(entities = [HerollainDbo::class, PowerStatsDbo::class, AppearanceDbo::class, BiographyDbo::class, ImageDbo::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun herollainsDao() : HerollainsDao

    companion object {

        private var APPDATABASE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return APPDATABASE ?: synchronized(AppDatabase::class) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "Herollains.db")
                    .build()
                APPDATABASE = instance
                instance
            }
        }
    }

}