package com.andro.innobuzz.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_info")
data class UserData(
    @PrimaryKey
    @ColumnInfo("id") val id:Int?,
    @ColumnInfo("userId") val userId :Int?,
    @ColumnInfo("title") val title:String?,
    @ColumnInfo("body") val body:String?,
)
