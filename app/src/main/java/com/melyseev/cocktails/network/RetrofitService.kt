package com.melyseev.cocktails.network

import com.melyseev.cocktails.network.response.DrinkFilterResponse
import com.melyseev.cocktails.network.response.DrinkFullbyIdResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("filter.php")
    suspend fun filter(
        @Query("a") query: String
    ): DrinkFilterResponse


    @GET("lookup.php")
    suspend fun lookupById(
        @Query("i") idDrink: String
    ): DrinkFullbyIdResponse


}