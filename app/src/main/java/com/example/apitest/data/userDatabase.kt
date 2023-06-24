package com.example.apitest.data

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(
    entities = [UserDataEntity::class],
    version = 1
)
abstract class userDatabase : RoomDatabase() {
    abstract val dao: UserDataDao

    companion object{
        const val DB_NAME ="userDb"
    }

}