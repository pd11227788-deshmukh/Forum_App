package com.example.forum_app.view.interfac

import com.example.forum_app.model.Comment
import com.example.forum_app.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService
{
    @GET("posts")
    suspend fun getposts():List<Post>


    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") postId: Int): List<Comment>
}