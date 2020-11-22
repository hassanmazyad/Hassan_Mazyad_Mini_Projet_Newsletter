package com.example.newsletter.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsletter.data.Article


@Dao
interface ArticleDao {
    @Query("SELECT * FROM article ORDER BY title")
    fun getArticles(): List<Article>

    @Query("SELECT * FROM article WHERE author = :author")
    fun getArticle(author: String): List<Article>

    @Query("SELECT * FROM article WHERE url = :url")
    fun getArticleByUrl(url: String): List<Article>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Article>)
}