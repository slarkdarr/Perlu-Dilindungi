package com.example.perludilindungi.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.perludilindungi.data.model.FaksesResult
import com.example.perludilindungi.data.repository.LocalDataSource

class BookmarkViewModel: ViewModel() {
    var bookmarks = MutableLiveData<List<FaksesResult>>()
    val isBookmarkExist = MutableLiveData<Boolean>()

    fun getBookmark(context:Context){
        val dataSource = LocalDataSource(context)
        dataSource.getBookmarks {
            result ->
            bookmarks.postValue(result)
        }
    }
    fun addBookmark(context: Context, faksesResult: FaksesResult, onSuccess: (Boolean)-> Unit)
    {
        val localDataSource = LocalDataSource(context)
        localDataSource.saveBookmark(faksesResult)
        onSuccess(true)
    }

    fun deleteBookmark(context: Context,faksesResult:FaksesResult,onSuccess: (Boolean)-> Unit){
        val localDataSource = LocalDataSource(context)
        localDataSource.deleteBookmark(faksesResult)
        onSuccess(true)
    }
    fun checkBookmarkExists(context: Context,id: Int)
    {  // val localDataSource = LocalDataSource(context)
        isBookmarkExist.postValue(false)
        val dataSource = LocalDataSource(context)
        dataSource.getBookmarks {
                result ->
            for (i in result){
                if(i.id == id){
                    isBookmarkExist.postValue(true)
                    break
                }
            }
        }


//        Log.d("TAG","BOOKMARKS ID :: ${
//            id}")
//        Log.d("TAG","BOOKMARKS STATUS :: ${
//            isBookmarkExist.value}")

    }
}