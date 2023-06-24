package com.example.apitest.domain.repository

import com.example.apitest.data.UserDataEntity
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun upsert(message: UserDataEntity)

    suspend fun delete(message: UserDataEntity)

    fun query(): Flow<List<UserDataEntity>>

}