package com.example.data.remote

import com.example.domain.entity.PostModelItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    suspend fun getPosts() : List<PostModelItem>

    @GET("posts/{id}")
    suspend fun getPostItemById(@Path("id") id : Int) : PostModelItem

    @GET("posts")
    suspend fun getPostsByPostId(@Query("postId") id : Int) : List<PostModelItem>

    @POST("posts")
    suspend fun addPost(@Body post : PostModelItem) : List<PostModelItem>


}