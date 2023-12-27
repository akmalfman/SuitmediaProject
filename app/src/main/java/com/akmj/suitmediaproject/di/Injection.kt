package com.akmj.suitmediaproject.di

import android.content.Context
import com.akmj.suitmediaproject.data.UserRepository
import com.akmj.suitmediaproject.data.remote.retrofit.ApiConfig


object Injection {
    fun provideRepository(): UserRepository {
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService)
    }
}