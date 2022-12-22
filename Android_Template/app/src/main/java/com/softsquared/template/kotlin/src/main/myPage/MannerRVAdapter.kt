package com.softsquared.template.kotlin.src.main.myPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.ItemRvMannerBinding
import com.softsquared.template.kotlin.src.main.myPage.models.UserMannerReview

class MannerRVAdapter(private val dataList: ArrayList<UserMannerReview>): RecyclerView.Adapter<MannerRVAdapter.DataViewHolder>() {

    // ViewHolder 객체
    inner class DataViewHolder(val binding: ItemRvMannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UserMannerReview) {
            if (data.num > 0) {
                binding.tvMannerCnt.text = data.num.toString()
                binding.tvMannerComment.text = data.comment
            }
        }
    }

    // ViewHolder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding =
            ItemRvMannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    // ViewHolder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }


    // 표현할 Item의 총 개수
    override fun getItemCount(): Int = dataList.size
}