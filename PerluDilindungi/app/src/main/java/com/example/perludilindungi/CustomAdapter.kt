package com.example.perludilindungi

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter @JvmOverloads constructor(
    itemView: View,
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView.Adapter<CustomViewHolder>(){
    private var context: Context = context;
    private var headlines: List<NewsHeadlines> = listOf<NewsHeadlines>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.news_list_items, parent, false))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.text_title.setText(headlines.get(position).getHeadlineTitle())
        holder.text_source.setText(headlines.get(position).getHeadlineSource())
    }

    override fun getItemCount(): Int {
        return headlines.size
    }

}