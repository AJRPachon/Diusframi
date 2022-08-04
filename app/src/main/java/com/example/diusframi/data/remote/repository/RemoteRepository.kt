package com.example.diusframi.data.remote.repository

import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.remote.ApiService
import com.example.diusframi.data.utils.toBo

class RemoteRepository : RemoteDataSource {
    override suspend fun getHerollainListR(): List<HerollainBo>? =
        ApiService.getHerollainService().getHerollainList()?.map {it.toBo() }
}