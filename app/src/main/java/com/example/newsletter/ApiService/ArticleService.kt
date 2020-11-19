package com.example.newsletter.ApiService
import com.example.newsletter.data.ArticleResponse

interface ArticleService {
     fun getArticles(category: String): retrofit2.Response<ArticleResponse>
}