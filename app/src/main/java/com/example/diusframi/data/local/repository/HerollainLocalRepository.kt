package com.example.diusframi.data.local.repository

import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.local.AppApplication
import com.example.diusframi.data.local.AppDatabase
import com.example.diusframi.data.utils.toBo

object HerollainLocalRepository {

    private val database = AppDatabase.getInstance(AppApplication.instance)
    private val herollainDao = database.herollainsDao()

    ///////// SELECT /////////////////////////////////////////////////////////////////////////////

    fun getHerollainList() : List<HerollainBo> {
        return herollainDao.getHerollainList().map { herollainWithImage -> herollainWithImage.toBo() }
    }
}