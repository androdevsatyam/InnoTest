package com.andro.innobuzz.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDataDao {

    @Insert
    suspend fun insert(userData: UserData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(userdata:List<UserData>)

    @Query("SELECT * FROM user_info WHERE id=:id")
    suspend fun getDatabyId(id:Int): UserData

    @Query("SELECT * FROM user_info ")
    suspend fun getAllUser(): List<UserData>
}