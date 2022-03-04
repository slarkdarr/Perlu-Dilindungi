package com.example.perludilindungi.data.repository

import androidx.room.*
import androidx.room.Dao
import com.example.perludilindungi.data.model.FaksesResult

@Dao

interface BookmarkDao {
    @Query("SELECT * FROM tb_bookmark")
    suspend fun getAllBookmark() : List<FaksesResult>
    
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun addBookmark(data:FaksesResult)

    @Delete
    suspend fun deleteBookmark(data:FaksesResult)

}