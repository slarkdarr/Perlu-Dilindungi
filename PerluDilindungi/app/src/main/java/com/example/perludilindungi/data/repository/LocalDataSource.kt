package com.example.perludilindungi.data.repository

import android.content.Context
import com.example.perludilindungi.data.model.FaksesResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDataSource(context: Context) {
    private val bookmarkDatabase = BookmarkDatabase.getDatabase(context)
    private val bookmarkDao= bookmarkDatabase.bookmarkDao()

    fun getBookmarks(callback:(List<FaksesResult>) -> Unit){
        CoroutineScope(Dispatchers.Main).launch{
            callback(bookmarkDao.getAllBookmark())
        }
    }

    fun saveBookmark(data:FaksesResult){
        CoroutineScope(Dispatchers.Main).launch{
            bookmarkDao.addBookmark(data)
        }
    }

    fun deleteBookmark(data:FaksesResult){
        CoroutineScope(Dispatchers.Main).launch{
            bookmarkDao.deleteBookmark(data)
        }
    }

 
}