package com.example.apitest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apitest.data.UserDataEntity
import com.example.apitest.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){



    fun delete(messageEntity: UserDataEntity) {
        viewModelScope.launch {
            repository.delete(messageEntity)
        }
    }

    fun upsert(messageEntity: UserDataEntity) {
        viewModelScope.launch {
            repository.upsert(messageEntity)
        }
    }

    val query = repository.query()

}