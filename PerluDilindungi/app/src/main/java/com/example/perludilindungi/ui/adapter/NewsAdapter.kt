package com.example.perludilindungi.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.perludilindungi.MainActivity
import com.example.perludilindungi.NewsPageActivity
import com.example.perludilindungi.data.model.Content
import com.example.perludilindungi.data.model.Enclosure
import com.example.perludilindungi.data.model.News
import com.example.perludilindungi.data.model.NewsResult
import com.example.perludilindungi.databinding.ItemNewsBinding
import com.google.firebase.firestore.util.Assert
import com.google.gson.Gson
import java.util.*

class NewsAdapter (val data: NewsResult?):

    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    var title: String = ""
    var url: String = ""
    var pubDate: String = ""

    var newsContent: String = " "

    var imgUrl: String = " "


    inner class NewsHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.textTitle.text = item.title
            title = item.title

            binding.textSource.text = item.url[0]
            url = item.url[0]

            binding.date.text = item.date
            pubDate = item.date

            newsContent = Gson().fromJson(item.content, Content::class.java).__cdata
            imgUrl =   Gson().fromJson(item.enclosure, Enclosure::class.java)._url






        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val v = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        v.newsContainer.setOnClickListener { item->
            val intent = Intent(parent.context, NewsPageActivity::class.java)
            intent.putExtra("url", url)
            intent.putExtra("pubDate", pubDate)
            intent.putExtra("title", title)
            intent.putExtra("content", newsContent)
            intent.putExtra("imgUrl", imgUrl)
            parent.context.startActivity(intent)
        }
        return NewsHolder(v)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
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


