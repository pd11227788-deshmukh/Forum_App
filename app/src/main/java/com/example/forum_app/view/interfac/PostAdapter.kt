package com.example.forum_app.view.interfac

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forum_app.databinding.SingleItemLayoutBinding
import com.example.forum_app.model.Post

class PostAdapter(
    private var list: List<Post>,
    var listener: Onclick
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: SingleItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = SingleItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PostViewHolder(binding)
    }

    fun updateList(newList: List<Post>) {

        list = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]

        holder.binding.txtUserid.text = "User ID: ${post.id}"
        holder.binding.txtUsertitle.text = "Title: ${post.title}"

        holder.binding.root.setOnClickListener {
            listener.onClick(post)
        }
        holder.binding.txtUserid.setOnClickListener {
            listener.onClickUser(post)
        }
    }
}
