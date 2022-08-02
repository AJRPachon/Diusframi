package com.example.diusframi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.local.repository.HerollainLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HerollainDetailViewModel : ViewModel() {

    private val herollainLiveData : MutableLiveData<HerollainBo> = MutableLiveData()

    fun getHerollainLiveData() : LiveData<HerollainBo> {
        return herollainLiveData
    }

    fun requestHerollain(id : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            herollainLiveData.postValue(HerollainLocalRepository.getHerollain(id))
        }
    }

    fun setHerollainFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO){
            HerollainLocalRepository.setHerollainFavorite(id)
        }
    }

}