package com.example.forum_app.view.interfac

import com.example.forum_app.model.Post
import com.example.forum_app.view.RetrofitInstance

class PostRepository
{
    suspend fun getpost():List<Post>
    {
        return RetrofitInstance.api.getposts()
    }

    suspend fun getComments(postId: Int) = RetrofitInstance.api.getComments(postId)

}