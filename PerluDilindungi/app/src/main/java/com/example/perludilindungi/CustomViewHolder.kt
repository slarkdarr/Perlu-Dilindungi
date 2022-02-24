package com.example.perludilindungi

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.cardview.widget.CardView

import androidx.recyclerview.widget.RecyclerView


class CustomViewHolder @JvmOverloads constructor(
    itemView: View
) : RecyclerView.ViewHolder(itemView){

    var text_title: TextView = itemView.findViewById(R.id.text_title)
    var text_source: TextView = itemView.findViewById(R.id.text_source)

    var image_headline: ImageView = itemView.findViewById(R.id.img_headline)

    var card_view: CardView = itemView.findViewById(R.id.mainContainer)
}
