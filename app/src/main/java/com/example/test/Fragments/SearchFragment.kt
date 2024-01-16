package com.example.test.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.test.Adapter.ShowAdapter
import com.example.test.Models.ShowModel
import com.example.test.Models.TVShow
import com.example.test.databinding.FragmentSearchBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: ShowAdapter
    private var url="https://api.tvmaze.com/search/shows?q="
    private var showList = ArrayList<ShowModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)

        binding.searchBtn.setOnClickListener {
            if(binding.seachText.length() <3){
                binding.seachText.setError("Username length should be at least 3 charter")
            }else{
                showList.clear()

                val stringRequest = StringRequest(Request.Method.GET, url+binding.seachText.text.toString(), {
                    val gson = Gson()
                    val tvShows: List<TVShow> = gson.fromJson(it, object : TypeToken<List<TVShow>>() {}.type)
                    for (tvShow in tvShows) {
                        val imageUrl = tvShow.show.image?.medium ?: ""
                        showList.add(ShowModel(imageUrl, tvShow.show.name, tvShow.show.summary))
                    }
                    adapter.notifyDataSetChanged()
                }, { Toast.makeText(context, "fetching failed", Toast.LENGTH_LONG).show() })

                val volleyQuery = Volley.newRequestQueue(context)
                volleyQuery.add(stringRequest)

                adapter= ShowAdapter(requireContext(),showList)
                binding.recyclerView?.layoutManager=LinearLayoutManager(requireContext())
                binding.recyclerView.adapter=adapter
            }
        }

        return binding.root
    }
}
