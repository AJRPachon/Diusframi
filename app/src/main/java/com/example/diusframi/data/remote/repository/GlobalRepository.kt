package com.example.diusframi.data.remote.repository

import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.local.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class GlobalRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
){

    suspend fun getHerollainList() : Flow<List<HerollainBo>> = flow {
        if (localDataSource.isEmpty()){
            val herollainList = remoteDataSource.getHerollainListR()
            herollainList?.let { localDataSource.saveHerollains(it) }
        }
        emitAll(localDataSource.getHerollainListL())
    }

    fun gerHerollain(name: String): HerollainBo {
        return LocalRepository.getHerollain(name)
    }
}

interface RemoteDataSource {
    suspend fun getHerollainListR(): List<HerollainBo>?
}

interface LocalDataSource {
    suspend fun isEmpty() : Boolean
    suspend fun saveHerollains(herollainList: List<HerollainBo>)
    suspend fun getHerollainListL() : Flow<List<HerollainBo>>
}