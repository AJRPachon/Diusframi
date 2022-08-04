package com.example.diusframi.ui.viewmodel

import androidx.lifecycle.*
import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.remote.repository.GlobalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HerollainViewModel(private val repository: GlobalRepository) : ViewModel(){

    private val herollainListLiveData : MutableLiveData<List<HerollainBo>> = MutableLiveData()
    private val herollainLiveData : MutableLiveData<HerollainBo> = MutableLiveData()

    fun getHerollainLD() = herollainListLiveData
    fun getHerollain() = herollainLiveData

    fun herollainLiveData() {
        viewModelScope.launch(Dispatchers.IO) {
            requestHerollainList()
        }
    }

    private suspend fun requestHerollainList(){
        repository.getHerollainList().collect{
            herollainListLiveData.postValue(it)
        }
    }

    fun requestHerollain(name : String){
        viewModelScope.launch(Dispatchers.IO) {
            herollainLiveData.postValue(repository.gerHerollain(name))
        }
    }

}