package com.example.diusframi.data.local.repository

import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.entities.dbo.*
import com.example.diusframi.data.entities.dbo.relations.HerollainWithData
import com.example.diusframi.data.local.AppApplication
import com.example.diusframi.data.local.AppDatabase
import com.example.diusframi.data.remote.repository.LocalDataSource
import com.example.diusframi.data.utils.toDbo
import com.example.diusframi.data.utils.toBo
import com.example.diusframi.data.utils.toDBO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object LocalRepository : LocalDataSource {

    private val database = AppDatabase.getInstance(AppApplication.instance)
    private val herollainDao = database.herollainsDao()

    ///////// SELECT /////////////////////////////////////////////////////////////////////////////

    override suspend fun getHerollainListL(): Flow<List<HerollainBo>> =
        herollainDao.getHerollainList().map { it.map { herollainWithData -> herollainWithData.toBo()} }

    fun getHerollain(id: Int): HerollainBo {
        return herollainDao.getHerollain(id).toBo()
    }

    fun getHerollain(name: String): HerollainBo {
        return herollainDao.getHerollain(name).toBo()
    }

    override suspend fun isEmpty(): Boolean = herollainDao.getHerollainCount() <= 0


    ///////// INSERT /////////////////////////////////////////////////////////////////////////////

    override suspend fun saveHerollains(herollainList: List<HerollainBo>) {

        val appearanceList = mutableListOf<AppearanceDbo?>()
        val biographyList = mutableListOf<BiographyDbo?>()
        val powerStatList = mutableListOf<PowerStatsDbo?>()
        val imageList = mutableListOf<ImageDbo?>()

        val herollainListDbo = herollainList.map { herollainBo -> herollainBo.toDBO() }

        herollainList.forEach {
            appearanceList.add(it.id?.let { id -> it.appearances?.toDbo(id) })
            biographyList.add(it.id?.let { id -> it.biography?.toDbo(id) })
            powerStatList.add(it.id?.let { id -> it.powerstats?.toDbo(id) })
            imageList.add(it.id?.let { id -> it.images?.toDbo(id) })
        }

        database.herollainsDao().insertHerollains(herollainListDbo, appearanceList, biographyList, powerStatList, imageList)
    }


    ///////// UPDATE /////////////////////////////////////////////////////////////////////////////

    fun updateHerollainFavorite(id: Int) {
        herollainDao.setHerollainFavorite(id)
    }

}