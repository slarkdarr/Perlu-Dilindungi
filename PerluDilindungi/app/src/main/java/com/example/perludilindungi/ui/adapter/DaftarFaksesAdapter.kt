package com.example.perludilindungi.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perludilindungi.data.model.Fakses
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.databinding.ItemFaksesBinding

class DaftarFaksesAdapter(val data: List<FaksesResult>, private val onClickListener: OnClickListener):
    RecyclerView.Adapter<DaftarFaksesAdapter.DaftarFaksesHolder>() {

    inner class DaftarFaksesHolder(val binding: ItemFaksesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: FaksesResult){
            binding.faksesName.text = item.nama
            binding.faksesAddress.text = item.alamat
            binding.faksesCode.text = item.kode
            binding.faksesType.text = item.jenisFaskes
            binding.faksesTelp.text = item.telp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaftarFaksesHolder {
        val v = ItemFaksesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DaftarFaksesHolder(v)
    }

    override fun onBindViewHolder(holder: DaftarFaksesHolder, position: Int) {
        Log.d("TAG","ADAPTER BIND DATA::: $data")
        if (data != null) {
            holder.bind(data?.get(position)!!)
            holder.itemView.setOnClickListener {
                onClickListener.onClick(data?.get(position)!!)
            }
        }
        
    }

    override fun getItemCount(): Int {
        Log.d("TAG","ADAPTER COUNT DATA::: $data")
        if (data == null){
            return 0
        }
        else {
            Log.d("TAG","DATA RESULTS.SIZE::: $data.results.size")
            return data.size
        }
    }
    class OnClickListener(val clickListener : (faksesResult: FaksesResult) ->Unit){
        fun onClick(faksesResult: FaksesResult) = clickListener(faksesResult)
    }
}