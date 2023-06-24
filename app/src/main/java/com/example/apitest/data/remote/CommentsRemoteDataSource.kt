package com.example.apitest.data.remote

import com.example.apitest.data.remo_UserDataEntity
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface CommentsRemoteDataSource {

    @GET("users")
    suspend fun getComments(
    ): Response<List<remo_UserDataEntity>>


    companion object{
        const val BASE_URL = " https://api.github.com/"

    }

}