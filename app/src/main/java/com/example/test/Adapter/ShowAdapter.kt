package com.example.test.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.DetailActivity
import com.example.test.Models.ShowModel
import com.example.test.R
import com.example.test.databinding.ShowRvBinding

class ShowAdapter(private var context: Context,private val showList: List<ShowModel>):RecyclerView.Adapter<ShowAdapter.ViewHolder>() {
    class ViewHolder(var binding: ShowRvBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ShowRvBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(showList[position].img).placeholder(R.drawable.img_error).into(holder.binding.img)
        holder.binding.title.setText(showList[position].title)
        holder.binding.desc.setText(showList[position].desc)
        holder.binding.layout.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("img",showList[position].img)
            intent.putExtra("title",showList[position].title)
            intent.putExtra("desc",showList[position].desc)
            context.startActivity(intent)
        }
    }
}