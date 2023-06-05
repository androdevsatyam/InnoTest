package com.andro.innobuzz.api

import com.andro.innobuzz.db.UserData
import retrofit2.Call
import retrofit2.http.GET


interface ConnectionMethods {

    @GET("posts")
    fun getData(): Call<List<UserData>>

}