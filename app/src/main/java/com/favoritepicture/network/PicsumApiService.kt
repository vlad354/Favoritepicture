package com.favoritepicture.network

import com.favoritepicture.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PicsumApiService {

    @GET("v2/list?page=1&limit=100")
    suspend fun getPageOne(): List<PicsumPageData>
}

object PicsumApi {
    val retrofitService : PicsumApiService by lazy {
        retrofit.create(PicsumApiService::class.java) }
}