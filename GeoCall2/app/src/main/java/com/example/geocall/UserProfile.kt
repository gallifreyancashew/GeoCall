package com.example.geocall

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "userProfile_table")
class UserProfile(@PrimaryKey
                  @ColumnInfo(name="email") val email: String,
                  @ColumnInfo(name="password") val password: String,
                  @ColumnInfo(name="fullName") val fullName: String)