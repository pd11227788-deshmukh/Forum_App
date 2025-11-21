package com.example.forum_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.forum_app.databinding.ActivityUserDataBinding

class UserDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding= ActivityUserDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userId = intent.getIntExtra("userid", -1)

        // Receive String
        val userTitle = intent.getStringExtra("usertitle")
        binding.txtUserid.text="User Id=$userId"
        binding.txtUsertitle.text="User title=$userTitle"


    }
}