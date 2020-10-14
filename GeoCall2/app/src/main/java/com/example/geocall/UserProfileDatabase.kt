package com.example.geocall

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserProfile::class], version=1, exportSchema = false)
abstract class UserProfileDatabase: RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao

    companion object {
        private var INSTANCE: UserProfileDatabase? = null
        fun getDatabase(context: Context): UserProfileDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                UserProfileDatabase::class.java,
                "userProfile_database"
            ).allowMainThreadQueries().build()
            INSTANCE = instance
            return instance
        }
    }
}