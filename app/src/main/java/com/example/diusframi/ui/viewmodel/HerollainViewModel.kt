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
        return herollainListLiveData
    }

    fun requestHerollainList() {

        requestHerollainListApi()

//        viewModelScope.launch(Dispatchers.IO) {
//            herollainListLiveData.postValue(HerollainLocalRepository.getHerollainList())
//        }
    }

    fun insertHerollainListOnBBDD(){
        viewModelScope.launch(Dispatchers.IO){
            herollainListLiveData.value?.let { HerollainLocalRepository.insertHerollainList(it) }
        }
    }


    ///// API ////////////////////////////////////////////////////////////////////////////////////
    private fun requestHerollainListApi() {
        viewModelScope.launch(Dispatchers.IO) {
            herollainListLiveData.postValue(HerollainRemoteRepository.getHerollainList())
        }
    }


}