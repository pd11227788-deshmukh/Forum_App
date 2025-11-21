package com.example.forum_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forum_app.databinding.ActivityMainBinding
import com.example.forum_app.model.Comment
import com.example.forum_app.model.Post
import com.example.forum_app.view.interfac.Onclick
import com.example.forum_app.view.interfac.PostAdapter
import com.example.forum_app.viewmodel.PostViewmodel
import kotlinx.coroutines.flow.combineTransform

class MainActivity : AppCompatActivity(), Onclick {

    private val viewModel: PostViewmodel by viewModels()
    lateinit var post: Post
    lateinit var originalList: MutableList<Post>
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        originalList=mutableListOf()
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        adapter= PostAdapter(originalList,this)
        binding.recyclerView.adapter = adapter

        viewModel.fetchdata()

setObserver()
        // 🔍 Search Listener
        binding.edtSearch.addTextChangedListener { text ->
            filterList(text.toString())
        }

    }
    private fun filterList(query: String) {
        val filtered = originalList.filter {
            it.id.toString().contains(query, true) ||
                    it.title.contains(query, true)
        }

        adapter.updateList(filtered)
    }

    fun setObserver()
    {
        getpostobserver()
        getCommentsObserver()
    }

    fun getpostobserver() {
        viewModel.posts.observe(this) {
            list->
            originalList.addAll(list)
            list?.let {

                adapter.updateList(list)
            }
            list.forEach {
                //binding.txt1.text="title ${it.title}"
                Log.v("data","title=${it.title}")
            }
        }
    }
    fun getCommentsObserver()
    {
        viewModel.commentsLive.observe(this){
            list->
            var intent= Intent(this, CommentActivity::class.java)
            intent.putExtra("userid",post.id)
            intent.putExtra("usertitle",post.title)
            intent.putParcelableArrayListExtra("commentList", ArrayList(list))
            startActivity(intent)
        }
    }

    override fun onClick(post1: Post) {
        this.post=post1
viewModel.loadComments(post.id)

    }

    override fun onClickUser(post: Post) {
        var intent= Intent(this, UserDataActivity::class.java)
        intent.putExtra("userid",post.id)
        intent.putExtra("usertitle",post.title)

        startActivity(intent)
    }

}