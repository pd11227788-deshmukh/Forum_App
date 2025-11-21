package com.example.forum_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
): Parcelable
