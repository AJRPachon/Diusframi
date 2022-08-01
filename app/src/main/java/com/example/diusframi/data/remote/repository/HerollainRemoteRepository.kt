package com.example.diusframi.data.remote.repository

import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.remote.ApiService
import com.example.diusframi.data.utils.toBo

object HerollainRemoteRepository {

    private val apiService = ApiService.getHerollainService()


    //////// SELECT ////////////////////////////////////////////////////////////////////////////

    suspend fun getHerollainList() : List<HerollainBo>? {
        return apiService.getHerollainList()?.map { herollainDto -> herollainDto.toBo()  }
    }

}