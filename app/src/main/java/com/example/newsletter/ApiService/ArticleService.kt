package com.example.newsletter.ApiService
import com.example.newsletter.data.ArticleResponse
import com.example.newsletter.data.Country

interface ArticleService {
     fun getArticlesByCategory(category: String): retrofit2.Response<ArticleResponse>
     fun getArticlesByEditor(editor: String): retrofit2.Response<ArticleResponse>
     fun getArticlesByCountry(country: String): retrofit2.Response<ArticleResponse>
}