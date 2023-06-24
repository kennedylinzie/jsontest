package com.example.apitest.data.repository

import android.util.Log
import androidx.room.PrimaryKey
import com.example.apitest.data.UserDataEntity
import com.example.apitest.data.remote.CommentsRemoteDataSource
import com.example.apitest.data.userDatabase
import com.example.apitest.domain.repository.Repository
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import org.json.JSONObject

class RepositoryImpl  (   private val database: userDatabase,private val remoteDataSource: CommentsRemoteDataSource
) : Repository {

    private val dao = database.dao

    override suspend fun upsert(message: UserDataEntity) {
        dao.upsert(message)
    }

    override suspend fun delete(message: UserDataEntity) {
        dao.delete(message)
    }

    override fun query(): Flow<List<UserDataEntity>> {

        return flow {

                    val com0 = remoteDataSource.getComments()
                    val com = com0.body()
                    if(com0.isSuccessful){
                        for (i in com!!) {

                                // The audioPaths value doesn't exist
                                // Perform necessary actions
                                dao.upsert(UserDataEntity(
                                    i.avatarUrl,
                                    i.eventsUrl,
                                    i.followersUrl,
                                    i.followingUrl,
                                    i.gistsUrl,
                                    i.gravatarId,
                                    i.htmlUrl,
                                    i.id,
                                    i.login,
                                    i.nodeId,
                                    i.organizationsUrl,
                                    i.receivedEventsUrl,
                                    i.reposUrl,
                                    i.siteAdmin,
                                    i.starredUrl ,
                                    i.subscriptionsUrl,
                                    i.type,
                                    i.url,
                                ))
                            }

                        }
                        emitAll(dao.query())
          //  }else emitAll(dao.query())

        }

    }
}