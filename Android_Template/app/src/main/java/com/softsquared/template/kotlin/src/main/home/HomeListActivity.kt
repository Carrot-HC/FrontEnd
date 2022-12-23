package com.softsquared.template.kotlin.src.main.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
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

        binding.homeListBack.setOnClickListener {
            val intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        }

        val product = intent.getIntExtra("productIdx", 0)
        Log.d("fff", product.toString())


        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.sandy1017.shop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val contentService = retrofit.create(ContentService::class.java)
        contentService.getContent(
            4,
            "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4Ijo0LCJpYXQiOjE2NzE3NTM1MjgsImV4cCI6MTY3MzIyNDc1N30.wnSucJ0011DLb32WclUie4d1Y4MXDJJzE9DrIeXYKEA",
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

                            Glide.with(binding.sliderViewPager.context)
                                .load(data.image[0])
                                .into(binding.sliderViewPager)

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