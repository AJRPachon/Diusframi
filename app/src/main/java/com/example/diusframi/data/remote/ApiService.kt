package com.example.diusframi.data.remote

import com.example.diusframi.data.entities.dto.HerollainListDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    //TODO Mirar si esto es correcto
    @GET("all.json")
    suspend fun getHerollainList(): HerollainListDto

    companion object {

        @Volatile
        private var API_SERVICE: ApiService? = null

        fun getHerollainService(): ApiService {

            return API_SERVICE ?: synchronized(this) {

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://akabab.github.io/superhero-api/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val instance = retrofit.create(ApiService::class.java)
                API_SERVICE = instance
                instance
            }

        }

    }
}