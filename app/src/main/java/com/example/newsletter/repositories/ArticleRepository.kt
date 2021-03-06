package com.example.newsletter.repositories
import com.example.newsletter.ApiService.RetrofitApiService
import com.example.newsletter.data.Article
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

    fun listByCategory(category: String): List<Article> {
        val response = articleService.listByCategory(category).execute()
        return response.body()?.articles?: emptyList()
    }

    fun listByEditor(editor: String): List<Article> {
        val response = articleService.listByEditor(editor).execute()
        return response.body()?.articles?: emptyList()
    }

    fun listByCountry(country: String): List<Article> {
        val response = articleService.listByCountry(country).execute()
        return response.body()?.articles?: emptyList()
    }


}