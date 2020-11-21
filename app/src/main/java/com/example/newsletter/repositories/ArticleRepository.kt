package com.example.newsletter.repositories
import com.example.newsletter.ApiService.RetrofitApiService
import com.example.newsletter.data.Article
import com.example.newsletter.data.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository {
    private val articleService: RetrofitApiService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
        }
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        articleService = retrofit.create(RetrofitApiService::class.java)
    }

    fun list(category: String): List<Article> {
        val response = articleService.list(category).execute()
        return response.body()?.articles?: emptyList()
    }
}