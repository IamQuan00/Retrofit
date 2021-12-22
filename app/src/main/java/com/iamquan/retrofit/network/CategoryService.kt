package com.iamquan.retrofit.network

import com.iamquan.retrofit.model.CategoryRespone
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {
    @GET("categories.php/")
    fun getAllCategory(): Call<CategoryRespone>
}