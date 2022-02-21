package com.melyseev.cocktails.network

import com.melyseev.cocktails.network.response.DrinkFilterResponse
import com.melyseev.cocktails.network.response.DrinkFullbyIdResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    //www.thecocktaildb.com/api/json/v1/1/search.php?f=a
    @GET("search.php")
    suspend fun searchByFirstLetter(
        @Query("f") firstLetter: String
    ): DrinkFilterResponse

    //www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita
    @GET("search.php")
    suspend fun searchByName(
        @Query("s") name: String
    ): DrinkFilterResponse

    @GET("filter.php")
    suspend fun filterByAlcoholic(
        @Query("a") alco: String
    ): DrinkFilterResponse

    @GET("filter.php")
    suspend fun filterByIngredient(
        @Query("i") ingredient: String
    ): DrinkFilterResponse

    @GET("filter.php")
    suspend fun filterByGlass(
        @Query("g") glass: String
    ): DrinkFilterResponse


    @GET("filter.php")
    suspend fun filterByCategory(
        @Query("c") category: String
    ): DrinkFilterResponse

    //by ingredienst
    //www.thecocktaildb.com/api/json/v1/1/filter.php?i=orange


    @GET("lookup.php")
    suspend fun lookupById(
        @Query("i") idDrink: String
    ): DrinkFullbyIdResponse


}