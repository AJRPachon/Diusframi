package com.example.diusframi.data.local.repository

import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.entities.dbo.AppearanceDbo
import com.example.diusframi.data.entities.dbo.BiographyDbo
import com.example.diusframi.data.entities.dbo.ImageDbo
import com.example.diusframi.data.entities.dbo.PowerStatsDbo
import com.example.diusframi.data.local.AppApplication
import com.example.diusframi.data.local.AppDatabase
import com.example.diusframi.data.utils.toDbo
import com.example.diusframi.data.utils.toBo

object HerollainLocalRepository {

    private val database = AppDatabase.getInstance(AppApplication.instance)
    private val herollainDao = database.herollainsDao()

    ///////// SELECT /////////////////////////////////////////////////////////////////////////////

    fun getHerollainList() : List<HerollainBo> {
        return herollainDao.getHerollainList().map { herollainWithImage -> herollainWithImage.toBo() }
    }



    ///////// INSERT /////////////////////////////////////////////////////////////////////////////

    fun insertHerollainList(herollainList: List<HerollainBo>) {

        val appearanceList = arrayListOf<AppearanceDbo?>()
        val biographyList = arrayListOf<BiographyDbo?>()
        val powerStatList = arrayListOf<PowerStatsDbo?>()
        val imageList = arrayListOf<ImageDbo?>()

        val herollainListDbo = herollainList.map { herollainBo -> herollainBo.toDbo() }

        herollainList.forEach {
            appearanceList.add(it.id?.let { id -> it.appearances?.toDbo(id) })
            biographyList.add(it.id?.let { id -> it.biography?.toDbo(id) })
            powerStatList.add(it.id?.let { id -> it.powerstats?.toDbo(id) })
            imageList.add(it.id?.let { id -> it.images?.toDbo(id) })

        }

        database.herollainsDao().insertHerollains(herollainListDbo, appearanceList, biographyList, powerStatList, imageList)
    }
}