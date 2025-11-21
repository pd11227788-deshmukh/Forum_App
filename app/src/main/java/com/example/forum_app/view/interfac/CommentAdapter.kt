package com.example.forum_app.view.interfac

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forum_app.databinding.SingleCommentLayoutBinding
import com.example.forum_app.model.Comment

class CommentAdapter(
    private var list: List<Comment>?
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    inner class CommentViewHolder(val binding: SingleCommentLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = SingleCommentLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CommentViewHolder(binding)
    }

    override fun getItemCount(): Int = list?.size ?: 0

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = list?.get(position)

        holder.binding.txtSub.text = "Subject: ${comment?.name}"
        holder.binding.txtUserbody.text = "Body: ${comment?.body}"
        holder.binding.txtEmail.text = "Email: ${comment?.email}"
    }
}
