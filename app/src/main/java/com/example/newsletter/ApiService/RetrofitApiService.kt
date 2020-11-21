
package com.example.newsletter.ApiService

import retrofit2.Call
import com.example.newsletter.data.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("everything?apiKey=34ff6b016d3740f2bfa3863fde56c1a4")
    fun list(@Query("q") category: String): Call<ArticleResponse>

}