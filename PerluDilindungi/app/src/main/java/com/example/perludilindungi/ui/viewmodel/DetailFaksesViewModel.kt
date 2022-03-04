package com.example.perludilindungi.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.data.repository.LocalDataSource

class DetailFaksesViewModel: ViewModel() {
    fun addBookmark(context: Context, faksesResult: FaksesResult, onSuccess: (Boolean)-> Unit)
    {
        val localDataSource = LocalDataSource(context)
        localDataSource.saveBookmark(faksesResult)
        onSuccess(true)
    }
}