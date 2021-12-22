package com.iamquan.retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iamquan.retrofit.databinding.ItemCategoryBinding
import com.iamquan.retrofit.model.CateGoryModel

class CategoryAdapter(private var listCategory: List<CateGoryModel>,private var context : Context) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),context
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCategory[position])
    }

    override fun getItemCount(): Int = listCategory.size


    class ViewHolder(private var binding: ItemCategoryBinding, private var context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categorp: CateGoryModel) {
            binding.tvFoodID.text =categorp.idCategory
            binding.tvFoodName.text = categorp.strCategory
            binding.tvFoodDescription.text = categorp.strCategoryDescription
            Glide.with(context).load(categorp.strCategoryThumb).into(binding.imgFood)

        }
    }
}