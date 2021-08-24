package com.melyseev.cocktails.domain.data

data class DataState<T>(

    //data
    val data: T? = null,

    //error
    val error: String? = null,

    //loading
    val loading: Boolean = false,

    ) {

    companion object{
        fun <T> success(data: T): DataState<T>{
            return DataState(data = data)
        }

        fun <T> error(message: String): DataState<T>{
            return DataState(error = message)
        }

        fun <T> loading(): DataState<T> = DataState(loading = true)

    }
}