package com.softsquared.template.kotlin.src.main.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemGridDataBinding
import com.softsquared.template.kotlin.src.main.MainActivity



class CategoryAdapter(private val context: Context, private val dataList: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemGridDataBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(context: Context, item: Category) {
            binding.categoryListImg.setImageResource(item.profileImg)
            binding.categoryListTv.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGridDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}