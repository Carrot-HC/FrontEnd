package com.softsquared.template.kotlin.src.main.category

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityCategoryBinding
import com.softsquared.template.kotlin.src.main.MainActivity

class CategoryActivity : BaseActivity<ActivityCategoryBinding>(ActivityCategoryBinding::inflate) {
    private val categoryList:ArrayList<Category> = arrayListOf(
        Category(R.drawable.category_icon8, "인기매물"),
        Category(R.drawable.category_icon8, "디지털기기"),
        Category(R.drawable.category_icon8, "생활가전"),
        Category(R.drawable.category_icon8, "가구/인테리어"),
        Category(R.drawable.category_icon8, "생활/주방"),
        Category(R.drawable.category_icon8, "유아동"),
        Category(R.drawable.category_icon8, "유아도서"),
        Category(R.drawable.category_icon8, "여성의류"),
        Category(R.drawable.category_icon8, "여성잡화"),
        Category(R.drawable.category_icon8, "남성패션/잡화"),
        Category(R.drawable.category_icon8, "뷰티/미용"),
        Category(R.drawable.category_icon8, "스포츠/레저"),
        Category(R.drawable.category_icon8, "취미/게임/음반"),
        Category(R.drawable.category_icon8, "도서"),
        Category(R.drawable.category_icon8, "중고차"),
        Category(R.drawable.category_icon8, "티켓/교환권"),
        Category(R.drawable.category_icon8, "가공식품"),
        Category(R.drawable.category_icon8, "반려동물용품"),
        Category(R.drawable.category_icon8, "식물"),
        Category(R.drawable.category_icon8, "기타 중고물품"),
        Category(R.drawable.category_icon8, "삽니다"),




        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerGridView.adapter = CategoryAdapter(this, categoryList)
        binding.recyclerGridView.layoutManager = GridLayoutManager(this, 4)
        binding.recyclerGridView.setHasFixedSize(false)

    }





}