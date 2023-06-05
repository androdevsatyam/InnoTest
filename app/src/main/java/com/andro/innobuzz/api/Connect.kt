package com.andro.innobuzz.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Connect {

    val baseUrl = " https://jsonplaceholder.typicode.com/"

    fun getInstance(): ConnectionMethods {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build().create(ConnectionMethods::class.java)
    }

}