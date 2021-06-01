package com.codingwithmitch.daggerhiltplayground.retrofit

// This interface is responsible for creating the Retrofit object that gets the network data

import retrofit2.http.GET

interface BlogRetrofit {

    @GET ("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}