package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.test.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    lateinit var img:String
    lateinit var title:String
    lateinit var desc:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        img= intent.getStringExtra("img").toString()
        title= intent.getStringExtra("title").toString()
        desc= intent.getStringExtra("desc").toString()

        Glide.with(this).load(img).into(binding.img)
        binding.title.setText(title)
        binding.desc.setText(desc)
    }
}