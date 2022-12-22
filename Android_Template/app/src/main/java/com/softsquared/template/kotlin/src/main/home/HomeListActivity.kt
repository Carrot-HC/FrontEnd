package com.softsquared.template.kotlin.src.main.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityHomeListBinding
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.main.home.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeListBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getIntExtra("productIdx", 0)
        Log.d("fff", product.toString())


        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.sandy1017.shop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val contentService = retrofit.create(ContentService::class.java)
        contentService.getContent(
            5,
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4Ijo1LCJpYXQiOjE2NzE3MTQ4NjcsImV4cCI6MTY3MzE4NjA5Nn0.59EeKiJGnNZ8S2L1hJxYqShSrmT30w0PWyxFsZS9By8",
            product
        )
            .enqueue(object : Callback<ContentResponse> {


                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<ContentResponse>,
                    response: Response<ContentResponse>
                ) {
                    Log.d("thing", response.body().toString())
                    if (response.body()?.isSuccess == true) {
                        val data = response.body()!!.result

                        if (response.body()!!.isSuccess) {
                            binding.homeThingNameTv.text = data.nickName
                            binding.homeThingLocationTv.text = data.sellertown
                            binding.homeThingTitleTv.text = data.title
                            binding.homeThingTemp.text = data.mannerTemp.toString()
                            binding.homeListTimeTv.text = data.updateAt
                            binding.homeThingContentTv.text = data.content
                            binding.homeThingLikeTv.text = "관심 " + data.interestCount.toString()

                            //val img: List<String> = mutableListOf(data.image[0], data.image[1],data.image[2])


                        }
                    }
                }

                override fun onFailure(call: Call<ContentResponse>, t: Throwable) {
                    Log.e("test", "Error", t)
                }
            })
    }

}