package com.example.geocall

import androidx.room.*

@Dao
interface UserProfileDao {
    @Query("SELECT * FROM userProfile_table WHERE email = :em AND password = :pw")
    fun getUserProfile(em: String, pw: String) : UserProfile

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(userProfile: UserProfile)
}