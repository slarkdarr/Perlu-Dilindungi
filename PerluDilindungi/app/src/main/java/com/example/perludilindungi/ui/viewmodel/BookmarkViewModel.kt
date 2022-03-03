package com.example.perludilindungi.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.data.repository.LocalDataSource

class BookmarkViewModel: ViewModel() {
    val bookmarks = MutableLiveData<List<FaksesResult>>()

    fun getBookmark(context:Context){
        val dataSource = LocalDataSource(context)
        dataSource.getBookmarks {
            result ->
            bookmarks.postValue(result)
        }
    }
}