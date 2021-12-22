package com.iamquan.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iamquan.retrofit.adapter.CategoryAdapter
import com.iamquan.retrofit.databinding.ActivityMainBinding
import com.iamquan.retrofit.model.CateGoryModel
import com.iamquan.retrofit.model.CategoryRespone
import com.iamquan.retrofit.network.CategoryClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lisst = arrayListOf<CateGoryModel>()
    private lateinit var adapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = CategoryAdapter(lisst,this)
        binding.rvAPI.adapter = adapter
        binding.rvAPI.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getAllCategory()
    }

    fun getAllCategory() {

        lifecycleScope.launch(Dispatchers.IO) {
            var response: Response<CategoryRespone> = CategoryClient().getAllCategory().execute()
            if (response.isSuccessful) {
                  response.body()?.category?.let {
                      lisst.addAll(it)
                }
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}