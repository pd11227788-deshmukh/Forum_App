package com.example.forum_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forum_app.model.Comment
import com.example.forum_app.model.Post
import com.example.forum_app.view.interfac.PostRepository
import kotlinx.coroutines.launch

class PostViewmodel: ViewModel()
{
    private val repository= PostRepository()
    val posts= MutableLiveData<List<Post>>()
    val commentsLive = MutableLiveData<List<Comment>>()
    fun fetchdata()
    {
        viewModelScope.launch {
            val response=repository.getpost()
            posts.value=response
        }
    }


    fun loadComments(postId: Int) {
        viewModelScope.launch {
            commentsLive.postValue(repository.getComments(postId))
        }
    }
}