package com.example.newsletter.repositories
import com.example.newsletter.ApiService.ArticleOnlineService
import com.example.newsletter.ApiService.ArticleService
import com.example.newsletter.data.Article
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository {
    private val articleService: ArticleOnlineService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
        }
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        articleService = retrofit.create(ArticleOnlineService::class.java)
    }

    fun list(category: String): List<Article> {
        val response = articleService.getArticles()
        return response?: emptyList()
    }
}
