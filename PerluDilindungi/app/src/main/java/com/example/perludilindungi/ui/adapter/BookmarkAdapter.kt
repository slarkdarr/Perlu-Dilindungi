package com.example.perludilindungi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.databinding.ItemBookmarkBinding

class BookmarkAdapter(private val onClickListener: OnClickListener):RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: FaksesResult){
            binding.faksesName.text = item.nama
            binding.faksesAddress.text  = item.alamat
            binding.faksesCode.text  = item.kode
            binding.faksesTelp.text  = item.telp
            binding.faksesType.text  = item.jenisFaskes


        }
    }
    private val bookmarkList = ArrayList<FaksesResult>()
    fun setData(items: List<FaksesResult>){
        bookmarkList.clear()
        bookmarkList.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkAdapter.ViewHolder {
        val binding = ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = bookmarkList.size

    override fun onBindViewHolder(holder: BookmarkAdapter.ViewHolder, position: Int) {
        holder.bind(bookmarkList[position])
        holder.itemView.setOnClickListener {
            onClickListener.onClick(bookmarkList[position])
        }

    }
    class OnClickListener(val clickListener : (faksesResult: FaksesResult) ->Unit){
        fun onClick(faksesResult: FaksesResult) = clickListener(faksesResult)
    }
}