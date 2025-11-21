package com.example.forum_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forum_app.databinding.ActivityCommentBinding
import com.example.forum_app.model.Comment
import com.example.forum_app.view.interfac.CommentAdapter

class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    lateinit var adapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getIntExtra("userid", -1)

        // Receive String
        val userTitle = intent.getStringExtra("usertitle")

        binding.txtUserid.text="User id= $userId"
        binding.txtUsertitle.text="Title=$userTitle"
        // Receive List<Comment>
        val commentList = intent.getParcelableArrayListExtra<Comment>("commentList")

       // Toast.makeText(this,"listsizr=${commentList?.size}", Toast.LENGTH_SHORT).show()
        binding.recyclerviewComment.layoutManager= LinearLayoutManager(this)
        adapter= CommentAdapter(commentList)
        binding.recyclerviewComment.adapter=adapter

    }
}