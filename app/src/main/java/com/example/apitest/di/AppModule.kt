package com.example.apitest.di

import android.content.Context
import androidx.room.Room
import com.example.apitest.data.remote.CommentsRemoteDataSource
import com.example.apitest.data.repository.RepositoryImpl
import com.example.apitest.data.userDatabase
import com.example.apitest.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  AppModule {

    @Singleton
    @Provides
    fun name(): String {
        return "AppHatchery --0324"
    }

    @Singleton
    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): userDatabase {
        return Room.databaseBuilder(context, userDatabase::class.java, userDatabase.DB_NAME)
            .build()
    }


    @Provides
    fun providesRepository(
        database: userDatabase,
        remoteDataSource: CommentsRemoteDataSource
    ): Repository {
        return RepositoryImpl(database,remoteDataSource)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): CommentsRemoteDataSource {
        return Retrofit.Builder()
            .baseUrl(CommentsRemoteDataSource.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CommentsRemoteDataSource::class.java)
    }

}