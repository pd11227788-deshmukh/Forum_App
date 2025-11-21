package com.example.forum_app.view.interfac

import com.example.forum_app.model.Comment
import com.example.forum_app.model.Post

interface Onclick
{
    fun onClick(post: Post)
    fun onClickUser(post: Post)
}