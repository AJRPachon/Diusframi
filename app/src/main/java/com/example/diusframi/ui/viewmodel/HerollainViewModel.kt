package com.example.diusframi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.local.repository.HerollainLocalRepository
import com.example.diusframi.data.remote.repository.HerollainRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HerollainViewModel : ViewModel(){

    private val herollainListLiveData : MutableLiveData<List<HerollainBo>> = MutableLiveData()
    private val herollainListAuxLiveData : MutableLiveData<List<HerollainBo>> = MutableLiveData()

    fun getHerollainList() : LiveData<List<HerollainBo>>{
        loadHerollainList()
        return herollainListLiveData
    }

    fun getHerollainDataList() : LiveData<List<HerollainBo>> {
        requestHerollainListApi()
        insertHerollainListOnBBDD()
        return getHerollainList()
    }

    private fun loadHerollainList() {
        viewModelScope.launch(Dispatchers.IO) {
            herollainListLiveData.postValue(HerollainLocalRepository.getHerollainList())
        }
    }

    private fun insertHerollainListOnBBDD(){
        viewModelScope.launch(Dispatchers.IO){
            herollainListAuxLiveData.value?.let { HerollainLocalRepository.insertHerollainList(it) }
        }
    }


    ///// API ////////////////////////////////////////////////////////////////////////////////////
    private fun requestHerollainListApi() {
        viewModelScope.launch(Dispatchers.IO) {
            herollainListAuxLiveData.postValue(HerollainRemoteRepository.getHerollainList())
        }
    }



}