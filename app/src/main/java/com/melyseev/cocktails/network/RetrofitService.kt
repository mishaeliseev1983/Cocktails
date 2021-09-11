package com.melyseev.cocktails.network

import com.melyseev.cocktails.network.response.DrinkFilterResponse
import com.melyseev.cocktails.network.response.DrinkFullbyIdResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("filter.php")
    suspend fun filter(
        @Query("g") query: String
    ): DrinkFilterResponse


    @GET("filter.php")
    suspend fun filterByIngredient(
        @Query("i") ingredient: String
    ): DrinkFilterResponse

    @GET("filter.php")
    suspend fun filterByGlass(
        @Query("g") ingredient: String
    ): DrinkFilterResponse

    //by ingredienst
    //www.thecocktaildb.com/api/json/v1/1/filter.php?i=orange


    @GET("lookup.php")
    suspend fun lookupById(
        @Query("i") idDrink: String
    ): DrinkFullbyIdResponse


}