package com.akmj.suitmediaproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akmj.suitmediaproject.data.UserRepository
import com.akmj.suitmediaproject.data.UserPagingSource
import com.akmj.suitmediaproject.data.remote.response.DataItem

class ThirdScreenViewModel(private val repository: UserRepository) : ViewModel() {

    fun userList(): LiveData<PagingData<DataItem>> =
        repository.getUsers().cachedIn(viewModelScope)
}