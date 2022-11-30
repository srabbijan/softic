package com.softic.bitdeposit.data.remote

import com.softic.bitdeposit.utils.CommonUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object APIHelper {

    var client = OkHttpClient.Builder()
        .connectTimeout(1000, TimeUnit.SECONDS)
        .readTimeout(1000, TimeUnit.SECONDS).build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(CommonUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}