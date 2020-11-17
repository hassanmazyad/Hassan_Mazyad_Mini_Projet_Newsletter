package com.example.newsletter.ApiService

import com.example.newsletter.data.Article

interface ArticleService {
    fun getArticles(): List<Article>
}