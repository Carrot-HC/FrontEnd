package com.softsquared.template.kotlin.src.main.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.databinding.ItemHomeDataBinding
import com.softsquared.template.kotlin.src.main.home.models.ResultHome
import com.softsquared.template.kotlin.src.main.home.models.ResultProduct

class HomeAdapter(private val homeList: ArrayList<ResultProduct>, private val context: HomeFragment): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    inner class HomeViewHolder(val binding: ItemHomeDataBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data : ResultProduct){
            binding.homeListInfoTv.text = data.title
            binding.homeListLocationTv.text = data.town
            binding.homeListTimeTv.text = data.updateAt
            binding.homeListMoneyTv.text = data.price.toString() + "원"
            binding.homeListLikeTv.text = data.interestCount.toString()

            Glide.with(binding.homeListImg.context)
                .load(data.productPhotoAddress)
                .into(binding.homeListImg)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemHomeDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    }

    interface OnItemClickListener {
        fun onClick(position: Int)
    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(homeList[position])
        holder.itemView.setOnClickListener {
             itemClickListener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        itemClickListener = onItemClickListener
    }
}