package com.example.perludilindungi.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perludilindungi.data.model.News
import com.example.perludilindungi.data.model.NewsResult
import com.example.perludilindungi.databinding.NewsListItemsBinding

class NewsAdapter (val data: NewsResult?):
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {


    inner class NewsHolder(val binding: NewsListItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.textTitle.text = item.title
            binding.textSource.text = item.url.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsHolder {
        val v = NewsListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(v)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsHolder, position: Int) {
        Log.d("TAG", "ADAPTER BIND DATA::: $data")
        if (data != null) {
            holder.bind(data?.results?.get(position)!!)
        }
    }

    override fun getItemCount(): Int {
        Log.d("TAG", "ADAPTER COUNT DATA::: $data")
        if (data == null) {
            return 0
        } else {
            Log.d("TAG", "DATA RESULTS.SIZE::: $data.results.size")
            return data.results.size

        }
    }
}


