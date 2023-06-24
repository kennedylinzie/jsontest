package com.example.apitest.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDataDao {

    @Upsert
    suspend fun upsert(message: UserDataEntity)

    @Delete
    suspend fun delete(message: UserDataEntity)

//    @Query("SELECT EXISTS(SELECT 1 FROM UserDataEntity WHERE audioPaths = :audioPaths LIMIT 1)")
//    suspend fun existsByAudioPath(audioPaths: String): Boolean


    @Query("SELECT * FROM UserDataEntity")
    fun query(): Flow<List<UserDataEntity>>


}